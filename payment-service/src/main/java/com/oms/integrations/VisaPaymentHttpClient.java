package com.oms.integrations;

import org.springframework.stereotype.Component;

@Component
public class VisaPaymentHttpClient extends AbstractPaymentHttpClient {
        
	public VisaPaymentHttpClient() {
            super(7.0);
            this.getClass().getClassLoader().getResource("payment-info.xml");
        }

}
