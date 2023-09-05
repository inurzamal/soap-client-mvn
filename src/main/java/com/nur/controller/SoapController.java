package com.nur.controller;

import com.nur.client.SoapClient;
import com.nur.loaneligibility.Acknowledgement;
import com.nur.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapController {

    @Autowired
    SoapClient soapClient;

    @PostMapping("/sendData")
    public Acknowledgement invokeWebserviceToSendData(@RequestBody CustomerRequest request){
        return soapClient.getLoanStatus(request);
    }
}
