package com.rays.model;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.PaymentDTO;

public class PaymentModel {
	
	public void add(PaymentDTO dto){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(dto);
		
		tx.commit();
		session.close();
			
	}
	
	public void update(PaymentDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.update(dto);
		
		tx.commit();
		session.close();
	}
	
	public void delete(PaymentDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.delete(dto);
		
		tx.commit();
		session.close();	
	}
	
	public PaymentDTO findById(int id) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		PaymentDTO dto = (PaymentDTO) session.get(PaymentDTO.class, id);
		return dto;
				
	}
	
	
	public List search(PaymentDTO dto,int pageNo,int pageSize) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(PaymentDTO.class);
		if (dto != null) {
			if (dto.getPayer() != null && dto.getPayer().length() > 0) {
				c.add(Restrictions.like("payer", dto.getPayer() + "%"));
			}
		}
		List list = c.list();
		
		session.close();
		return list;

	}


	}
		


