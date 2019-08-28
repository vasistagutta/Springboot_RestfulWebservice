package com.spring.phonpe.client.dao;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.phonpe.client.model.Payment;
import com.spring.phonpe.client.model.PaymentResponse;

@Component
@PropertySource(value = "classpath: application.properties")
public class RuleUtil {
	
	@Autowired
	private RestTemplate template;
	
	HttpHeaders headers = null;
	ObjectMapper objectMapper = null;
	
	@Autowired
	private Environment env;
	
	@PostConstruct

	public void init() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		objectMapper = new ObjectMapper();
	}
	
	
	//Post operation
	public PaymentResponse processPayment(Payment payment) {
		PaymentResponse response = null;
		String jsonRequest = null;
		String result ="";
		String URL = "";
		try {
			URL = env.getProperty("payment.url");
			//converting object to string 
			jsonRequest = objectMapper.writeValueAsString(payment);
			HttpEntity<String> entity = new HttpEntity<String>(jsonRequest,headers);
			//getting output as string later converts to object
			result = template.postForObject(URL, entity, String.class);
			//Convert string to JSON object ie PAymentResponse
			response = objectMapper.readValue(result, PaymentResponse.class);
		}catch(IOException ex) {
		 ex.printStackTrace();
			
		}
		
		return response;
	}
	
	public PaymentResponse getTransaction(String Vendor) {
		PaymentResponse response = null;
		String jsonRequest = null;
		String result ="";
		String URL = "";
		try {
			URL = env.getProperty("transactional.url")+ Vendor;
			//getting output as string later converts to object
			result =template.getForObject(URL, String.class);
			//Convert string to JSON object ie PAymentResponse
			response = objectMapper.readValue(result, PaymentResponse.class);
		}catch(IOException ex) {
		 ex.printStackTrace();
			
		}
		
		return response;
	}

}
