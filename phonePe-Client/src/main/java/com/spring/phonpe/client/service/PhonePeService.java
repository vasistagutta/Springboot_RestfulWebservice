package com.spring.phonpe.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.phonpe.client.dao.RuleUtil;
import com.spring.phonpe.client.model.Payment;
import com.spring.phonpe.client.model.PaymentResponse;

@Service
public class PhonePeService {
	
	@Autowired
	private RuleUtil util;
	
	public PaymentResponse quickPay(Payment payment) {
		return util.processPayment(payment);
	}
	
	public PaymentResponse getPaymentByVendor(String vendor) {
		return util.getTransaction(vendor);
	}

}
