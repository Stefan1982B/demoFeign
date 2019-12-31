package com.example.demoFeign.CAP;


import com.example.demoFeign.CAP.model.CAPResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CAP", url = "${CAP.ribbon.listOfServers}", configuration = CAPClientConfig.class)
public interface CAPClient {

    @GetMapping(consumes = "application/json;charset=UTF-8")
    CAPResponse getCAP(
            @RequestParam(name = "request") String request,
            @RequestParam(name = "sSiret") String siret,
            @RequestParam(name = "iResultTous") int size);
}

