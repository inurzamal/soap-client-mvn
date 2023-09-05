package com.nur.client;

import com.nur.loaneligibility.Acknowledgement;
import com.nur.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;
    private WebServiceTemplate template;

    public Acknowledgement getLoanStatus(CustomerRequest request){
        template = new WebServiceTemplate(marshaller);
        Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("localhost:9090/ws", request);
        return acknowledgement;
    }
}
