package com.oms.integrations;

import org.springframework.stereotype.Component;

@Component
public class AmexPaymentHttpClient extends AbstractPaymentHttpClient {
    public AmexPaymentHttpClient() {
        super(8.0);
    }
}
