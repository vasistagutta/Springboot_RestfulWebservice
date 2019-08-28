package com.spring.rest.curd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.curd.model.Payment;

@Repository
public class PaymentDaoImpl  implements PaymentDao{

	@Autowired
	private SessionFactory factory;
	@Override
	public String payNow(Payment payment) {
		// TODO Auto-generated method stub
		getSession().save(payment);
		return "payment Successfull with amount : "+ payment.getAmount();
	}
	
	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		}catch(HibernateException ex) {
			session = factory.openSession();
		}
		
		return session;
	}

	@Override
	public List<Payment> getTransactionInfo(String vendor) {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Payment.class).add(Restrictions.eq("vendor",vendor)).list();
	}

}
