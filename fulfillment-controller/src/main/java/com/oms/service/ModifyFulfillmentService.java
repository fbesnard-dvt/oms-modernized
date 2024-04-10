package com.oms.service;

import com.oms.dto.AuthorizationRequestDto;
import com.oms.dto.AuthorizationResponseDto;
import com.oms.dto.EmailRequestDto;
import com.oms.dto.EmailResponseDto;
import com.oms.dto.PaymentServiceReverseAuthInDTO;
import com.oms.dto.PaymentServiceReverseAuthOutDTO;
import com.oms.entity.OrderLine;
import com.oms.entity.SalesOrder;
import com.oms.entity.Shipping;
import com.oms.repository.SalesOrderRepository;
import com.oms.util.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import com.oms.dto.ShippingRequestDto;
import com.oms.dto.ShippingResponseDto;

@Service
@Transactional
public class ModifyFulfillmentService {

    @Autowired
    SalesOrderRepository salesOrderRepository;

    // @Autowired
    // PaymentService paymentService;
    WebClient paymentServiceClient = WebClient.create("http://oms-payment:8084");

    //@Autowired
    //DinersPaymentService dinersPaymentService;
    WebClient dinersPaymentServiceClient = WebClient.create("http://oms-payment:8084");

    //@Autowired
    //EmailService emailService;
    WebClient emailServiceClient = WebClient.create("http://oms-email:8083");

    //@Autowired
    //ShippingService shippingService;
    WebClient shippingServiceClient = WebClient.create("http://oms-shipping:8085");

    @Autowired
    Logger logger;

    public SalesOrder modifyToShipping(String lineItemId, SalesOrder salesOrder) {
        logger.log(this.getClass().getName());
        if (salesOrder != null && !StringUtils.isEmpty(salesOrder.getCustomerOrderId())) {
            SalesOrder originalSalesOrder = salesOrderRepository.getOne(salesOrder.getCustomerOrderId());
            OrderLine orderLine = fetchOrderLineFromItemId(lineItemId, originalSalesOrder);
            double shippingAmount = getShippingAmount(orderLine.getCustomerSKU());
            if (orderLine != null && orderLine.getCharges() != null && orderLine.getCharges().getTotalCharges() != null) {
                if (orderLine.getCharges().getTotalCharges() > 0) {
                    AuthorizationRequestDto authorizationRequestDto =
                            new AuthorizationRequestDto(originalSalesOrder.getPaymentInfo().getCardType(), "23445567"
                                    , "12/24", "123", shippingAmount);
                    //AuthorizationResponseDto responseDto = paymentService.authorize(authorizationRequestDto);
                    AuthorizationResponseDto responseDto = paymentServiceClient.post()
                        .uri("paymentService/authorize")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body(Mono.just(authorizationRequestDto), AuthorizationRequestDto.class).retrieve()
                        .bodyToMono(AuthorizationResponseDto.class).block();

                    //dinersPaymentService.authorize(authorizationRequestDto);
                    
                    if (responseDto != null && !StringUtils.isEmpty(responseDto.getId()) && !StringUtils.isEmpty(responseDto.getAmount())) {
                        originalSalesOrder.getPaymentInfo().setAuthorizedAmount(originalSalesOrder.getPaymentInfo().getAuthorizedAmount() + responseDto.getAmount());
                        salesOrderRepository.save(originalSalesOrder);
                        
                        //emailService.sendEmail(buildEmailRequest(originalSalesOrder));
                        EmailRequestDto emailRequestDto =
                            new EmailRequestDto("AY56332", "Your shipment is ready", "Incuding a brand new laptop","whatever");
                        //EmailResponseDto emailResponseDto = emailService.sendEmail(emailRequestDto);
                        EmailResponseDto emailResponseDto = emailServiceClient.post()
                            .uri("emailService/sendEmail")
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .body(Mono.just(emailRequestDto), EmailRequestDto.class).retrieve()
                            .bodyToMono(EmailResponseDto.class).block();
                        
                        BeanUtils.copyProperties(originalSalesOrder, salesOrder);
                    }
                }
            }
        }
        return salesOrder;
    }

    public OrderLine fetchOrderLineFromItemId(String lineItemId , SalesOrder salesOrder) {
        List<OrderLine> orderLines = salesOrder.getOrderLines();
        OrderLine orderLine = orderLines.stream().filter(line -> line.getLineItemId().equalsIgnoreCase(lineItemId)).findAny().orElse(null);
        return orderLine;
    }

    public EmailRequestDto buildEmailRequest(SalesOrder salesOrder) {
        return new EmailRequestDto("1234","Modify fulfillment","Your line item have been successfully modified for fulfillment","Modify to shipping from store pickup");
    }

    public SalesOrder modifyToStorePickup(String lineItemId,SalesOrder salesOrder) {
        logger.log(this.getClass().getName());
        if(salesOrder != null && !StringUtils.isEmpty(salesOrder.getCustomerOrderId())){
            SalesOrder originalSalesOrder = salesOrderRepository.getOne(salesOrder.getCustomerOrderId());
            // System.out.println("Fetched original sales order with ID: " + salesOrder.getCustomerOrderId());

            OrderLine orderLine = fetchOrderLineFromItemId(lineItemId ,originalSalesOrder);
            // System.out.println("Fetched order line with item ID: " + lineItemId + " from sales order with ID: " + salesOrder.getCustomerOrderId());

            double shippingAmount = getShippingAmount(orderLine.getCustomerSKU());
            // System.out.println("Fetched shipping amount for SKU: " + orderLine.getCustomerSKU());

            if(orderLine != null && orderLine.getCharges() != null && orderLine.getCharges().getTotalCharges() != null){
                if(orderLine.getCharges().getTotalCharges() > 0) {
                    // System.out.println("Creating authorization request");
                    AuthorizationRequestDto authorizationRequestDto =
                            new AuthorizationRequestDto(originalSalesOrder.getPaymentInfo().getCardType(), "23445567"
                                    , "12/24", "123", shippingAmount);
                    
                    // System.out.println("Requesting payment reverse authorization");
                    PaymentServiceReverseAuthInDTO inDTO = new PaymentServiceReverseAuthInDTO();
                    inDTO.setAuthorizationRequestDto(authorizationRequestDto);
                    
                    PaymentServiceReverseAuthOutDTO outDTO = paymentServiceClient.post()
                            .uri("paymentService/reverseAuth")
                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .body(Mono.just(inDTO), PaymentServiceReverseAuthInDTO.class).retrieve()
                            .bodyToMono(PaymentServiceReverseAuthOutDTO.class).block();
                    
                    // System.out.println("Extracting details from payment reverse authorization");
                    AuthorizationResponseDto responseDto = new AuthorizationResponseDto();
                    responseDto = outDTO.getRetVal();

                    // dinersPaymentService.reverseAuth(authorizationRequestDto);

                    if(responseDto != null && !StringUtils.isEmpty(responseDto.getId()) && !StringUtils.isEmpty(responseDto.getAmount())){
                        // System.out.println("Updating authorized amount in sales order");
                        originalSalesOrder.getPaymentInfo().setAuthorizedAmount(originalSalesOrder.getPaymentInfo().getAuthorizedAmount() - responseDto.getAmount());
                        // System.out.println("Saving sales order");
                        salesOrderRepository.save(originalSalesOrder);
                        // emailService.sendEmail(buildEmailRequest(originalSalesOrder));
                        EmailRequestDto emailRequestDto =
                            new EmailRequestDto("AY56332", "Your shipment is ready", "Incuding a brand new laptop","whatever");
                        //EmailResponseDto emailResponseDto = emailService.sendEmail(emailRequestDto);
                        // System.out.println("Sending email");
                        EmailResponseDto emailResponseDto = new EmailResponseDto();
                        emailResponseDto = emailServiceClient.post()
                                .uri("emailService/sendEmail")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .body(Mono.just(emailRequestDto), EmailRequestDto.class).retrieve()
                                .bodyToMono(EmailResponseDto.class).block();
                        // System.out.println(emailResponseDto.getRetVal());

                        BeanUtils.copyProperties(originalSalesOrder, salesOrder);
                    }
                }
            }
        }

        return salesOrder;
    }

    private double getShippingAmount(String skuId) {
        // System.out.println("Fetching shipping amount for SKU ID: " + skuId);

        // System.out.println("Creating shipping request");
        ShippingRequestDto shippingRequestDto = new ShippingRequestDto();
        shippingRequestDto.setSkuId(skuId);

        // System.out.println("Requesting shipping details");
        ShippingResponseDto shippingResponseDto = shippingServiceClient.post()
            .uri("shippingService/fetchShippingCharges")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(shippingRequestDto), ShippingRequestDto.class).retrieve()
            .bodyToMono(ShippingResponseDto.class).block();

        // System.out.println("Extracting details from shipping details");
        Shipping shipping  = shippingResponseDto.getRetVal();

        if (shipping != null) {
            // System.out.println("Shipping amount for SKU ID " + skuId + ": " + shipping.getStandardShipping());
            return shipping.getStandardShipping();
        } else {
            // System.out.println("No shipping amount found for SKU ID: " + skuId);
            return 0;
        }
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
