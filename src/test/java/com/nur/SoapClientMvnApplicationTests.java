package com.nur;

import com.nur.client.SoapClient;
import com.nur.stub.Acknowledgement;
import com.nur.stub.CustomerRequest;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SoapClientMvnApplicationTests {

	@InjectMocks
	SoapClient soapClient;
	@Mock
	WebServiceTemplate webServiceTemplate;
	public static final String URI = "http://localhost:8080/ws";

	@Test
	void getLoanStatusTest() {
		CustomerRequest request = createRequest();
		Acknowledgement acknowledgement = createAcknowledgement();

		when(webServiceTemplate.marshalSendAndReceive(URI,request)).thenReturn(acknowledgement);
//		doReturn(acknowledgement).when(webServiceTemplate).marshalSendAndReceive(URI,request);

		Acknowledgement actualResponse = soapClient.getLoanStatus(request);

		assertNotNull(actualResponse);
		assertEquals(acknowledgement, actualResponse);

	}

	private CustomerRequest createRequest() {
		return Instancio.create(CustomerRequest.class);
	}

	private Acknowledgement createAcknowledgement() {
		return Instancio.create(Acknowledgement.class);
	}
}
