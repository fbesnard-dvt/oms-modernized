package com.oms.integrations;

import org.springframework.stereotype.Component;

@Component
@PaymentQualifier("diners")
public class DinersPaymentHttpClient extends AbstractPaymentHttpClient {
    public DinersPaymentHttpClient() {
        super(10.0);
    }
}
