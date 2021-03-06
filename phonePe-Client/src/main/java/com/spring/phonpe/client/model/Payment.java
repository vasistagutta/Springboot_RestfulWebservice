package com.spring.phonpe.client.model;

import java.io.Serializable;
import java.util.Date;



public class Payment {
	

	private int id;
	private String transactionID;
	private String vendor;
	private Date paymentDate;
	private double amount;
	
	
	public Payment() {
		super();
	}
	public Payment(String transactionID, String vendor, Date paymentDate, double amount) {
		super();
		this.transactionID = transactionID;
		this.vendor = vendor;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
