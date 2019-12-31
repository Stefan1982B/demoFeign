package com.example.demoFeign.CAP;

import com.example.demoFeign.CAP.model.CAPResponse;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Service
public class CAPService {


    private static final Logger LOG = LoggerFactory.getLogger(CAPService.class);
    private static final String SCT_REQUEST_TYPE = "GetSctData";
    private static final int DEFAULT_REQUEST_SIZE = 2;

    private final CAPClient capClient;

    public CAPService(final CAPClient capClient) {
        this.capClient = capClient;
    }


    public String retrieveAPECode(String nationalClientIdentificationNumber) {
        LOG.info("Fetching CAPAddress for client with nationalClientIdentificationNumber {}", nationalClientIdentificationNumber);
        CAPResponse capResponse = null;
        try {
            capResponse = capClient.getCAP(SCT_REQUEST_TYPE, nationalClientIdentificationNumber, DEFAULT_REQUEST_SIZE);
        } catch (FeignException e) {
            LOG.info("Could not retrieve CAP Response for {} , got a {}", nationalClientIdentificationNumber, e.getMessage(), e);
            return null;
        }
        String APECode = null;

            String sAPET700 = capResponse.getSiret().get(0).getsAPET700();
            String sAPEN700 = capResponse.getSiret().get(0).getsAPEN700();

            APECode = sAPEN700 + sAPET700;

        return APECode;

    }
}


