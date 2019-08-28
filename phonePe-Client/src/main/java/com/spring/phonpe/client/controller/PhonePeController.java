package com.spring.phonpe.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.phonpe.client.model.Payment;
import com.spring.phonpe.client.model.PaymentResponse;
import com.spring.phonpe.client.service.PhonePeService;

@RestController
@RequestMapping("/PhonePe")
public class PhonePeController {
	
	@Autowired
	private PhonePeService phonePeService;
	
	@PostMapping("/payment")
	public PaymentResponse pay(@RequestBody Payment payment) {
		return phonePeService.quickPay(payment);
	}
	
	@GetMapping("/findTransactions")
	public PaymentResponse getPayments(@PathVariable String vendor) {
		return phonePeService.getPaymentByVendor(vendor);
	}

}
