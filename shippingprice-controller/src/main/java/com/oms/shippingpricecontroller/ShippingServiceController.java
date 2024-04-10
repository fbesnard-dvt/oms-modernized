package com.oms.shippingpricecontroller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.oms.shippingpricecontroller.dto.*;
import com.oms.service.ShippingService;

@RestController
@RequestMapping("/shippingService")
public class ShippingServiceController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping(value = "/fetchShippingCharges", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShippingServiceFetchShippingChargesOutDTO> fetchShippingCharges(@RequestBody ShippingServiceFetchShippingChargesInDTO in) {
        ShippingServiceFetchShippingChargesOutDTO ret = new ShippingServiceFetchShippingChargesOutDTO();
        ret.setRetVal(shippingService.fetchShippingCharges(in.getSkuId()));
        return ResponseEntity.ok(ret);
    }

}
