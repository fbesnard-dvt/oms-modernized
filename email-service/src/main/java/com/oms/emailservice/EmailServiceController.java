package com.oms.emailservice;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.oms.emailservice.dto.*;
import com.oms.service.EmailService;

@RestController
@RequestMapping("/emailService")
public class EmailServiceController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/sendEmail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmailServiceSendEmailOutDTO> sendEmail(@RequestBody EmailServiceSendEmailInDTO in) {
        EmailServiceSendEmailOutDTO ret = new EmailServiceSendEmailOutDTO();
        ret.setRetVal(emailService.sendEmail(in.getEmailRequestDto()));
        return ResponseEntity.ok(ret);
    }

}
