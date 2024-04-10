package com.oms.paymentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.oms.paymentservice.dto.*;
import com.oms.service.PaymentService;

@RestController
@RequestMapping("/paymentService")
public class PaymentServiceController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceController.class);

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/reverseAuth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentServiceReverseAuthOutDTO> reverseAuth(@RequestBody PaymentServiceReverseAuthInDTO in) {
        PaymentServiceReverseAuthOutDTO ret = new PaymentServiceReverseAuthOutDTO();
        try {
            ret.setRetVal(paymentService.reverseAuth(in.getAuthorizationRequestDto()));
            return ResponseEntity.ok(ret);
        } catch (Exception e) {
            logger.error("Error during reverseAuth", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/authorize", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentServiceAuthorizeOutDTO> authorize(@RequestBody PaymentServiceAuthorizeInDTO in) {
        PaymentServiceAuthorizeOutDTO ret = new PaymentServiceAuthorizeOutDTO();
        try {
            ret.setRetVal(paymentService.authorize(in.getAuthorizationRequestDto()));
            return ResponseEntity.ok(ret);
        } catch (Exception e) {
            logger.error("Error during authorize", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}