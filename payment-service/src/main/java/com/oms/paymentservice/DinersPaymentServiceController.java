package com.oms.paymentservice;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.oms.paymentservice.dto.*;
import com.oms.service.DinersPaymentService;

@RestController
@RequestMapping("/dinersPaymentService")
public class DinersPaymentServiceController {

    @Autowired
    private DinersPaymentService dinersPaymentService;

    @PostMapping(value = "/reverseAuth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DinersPaymentServiceReverseAuthOutDTO> reverseAuth(@RequestBody DinersPaymentServiceReverseAuthInDTO in) {
        DinersPaymentServiceReverseAuthOutDTO ret = new DinersPaymentServiceReverseAuthOutDTO();
        ret.setRetVal(dinersPaymentService.reverseAuth(in.getAuthorizationRequestDto()));
        return ResponseEntity.ok(ret);
    }

    @PostMapping(value = "/authorize", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DinersPaymentServiceAuthorizeOutDTO> authorize(@RequestBody DinersPaymentServiceAuthorizeInDTO in) {
        DinersPaymentServiceAuthorizeOutDTO ret = new DinersPaymentServiceAuthorizeOutDTO();
        ret.setRetVal(dinersPaymentService.authorize(in.getAuthorizationRequestDto()));
        return ResponseEntity.ok(ret);
    }

}
