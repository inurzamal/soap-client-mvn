package com.nur.client;

import com.nur.stub.Acknowledgement;
import com.nur.stub.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);
    public static final String URI = "http://localhost:8080/ws";
    @Autowired
    private Jaxb2Marshaller marshaller;
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public Acknowledgement getLoanStatus(CustomerRequest request){
        LOGGER.info("Soap call started with request {}: ", request);
        Acknowledgement acknowledgement = (Acknowledgement) webServiceTemplate.marshalSendAndReceive(URI, request);
        LOGGER.info("Soap call ended with response {}: ", acknowledgement);
        return acknowledgement;
    }
}
