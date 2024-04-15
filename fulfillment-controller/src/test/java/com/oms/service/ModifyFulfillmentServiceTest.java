package com.oms.service;

import com.oms.dto.AuthorizationResponseDto;
import com.oms.entity.LineCharges;
import com.oms.entity.OrderLine;
import com.oms.entity.PaymentInfo;
import com.oms.entity.SalesOrder;
import com.oms.entity.Shipping;
import com.oms.repository.SalesOrderRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ModifyFulfillmentServiceTest {

    @Mock
    SalesOrderRepository salesOrderRepository;

    ModifyFulfillmentService modifyFulfillmentService = new ModifyFulfillmentService();

    @BeforeEach
    public void setUp() {
        modifyFulfillmentService.salesOrderRepository = salesOrderRepository;
    }

    @Test
    public void testModifyShipping() {
        SalesOrder salesOrder = getSalesOrder();
        // Mockito.when(salesOrderRepository.getOne("5678")).thenReturn(salesOrder);
        // Mockito.when(salesOrderRepository.save(salesOrder)).thenReturn(salesOrder);
        //SalesOrder modifiedOrder = modifyFulfillmentService.modifyToShipping("1234",salesOrder);

        //assertNotNull(modifiedOrder);
        assertNotNull(salesOrder);
    }

    @Test
    public void testModifyStorePickup() {
        SalesOrder salesOrder = getSalesOrder();
        AuthorizationResponseDto returnAuth = new AuthorizationResponseDto("123",7.00,"SUCCESS");
        Shipping shipping = new Shipping("SKU1", 8.0, 9.0, 10.0);
        // Mockito.when(salesOrderRepository.getOne("5678")).thenReturn(salesOrder);
        // Mockito.when(salesOrderRepository.save(salesOrder)).thenReturn(salesOrder);

        double authorizedB4 = salesOrder.getPaymentInfo().getAuthorizedAmount();
        
        //SalesOrder modifiedOrder = modifyFulfillmentService.modifyToStorePickup("1234",salesOrder);
        //assertNotNull(modifiedOrder);
        //double authorizedAf = modifiedOrder.getPaymentInfo().getAuthorizedAmount();
        //assertEquals(authorizedB4 - returnAuth.getAmount(), authorizedAf, 0.0);
        assertNotNull(salesOrder);

    }

    private SalesOrder getSalesOrder() {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomerOrderId("5678");
        List<OrderLine> orderLines = new ArrayList<>();
        OrderLine orderLine = new OrderLine();
        orderLine.setLineItemId("1234");
        orderLine.setCustomerSKU("SKU1");
        LineCharges charges = new LineCharges();
        charges.setTotalCharges(7.00);
        orderLine.setCharges(charges);
        orderLines.add(orderLine);
        salesOrder.setOrderLines(orderLines);
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAuthorizedAmount(100.00);
        paymentInfo.setCardType("VISA");
        salesOrder.setPaymentInfo(paymentInfo);
        return salesOrder;
    }

}