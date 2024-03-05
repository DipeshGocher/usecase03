package com.rays.test;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.List;

import com.rays.dto.PaymentDTO;
import com.rays.model.PaymentModel;

public class TestPayment {
	
	public static void main(String[] args) throws Exception {
		
		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		 testSearch();
		
		
	}

	
	
	private static void testSearch() {
		
		PaymentDTO dto = new PaymentDTO();
		dto.setPayer("dipesh");
		PaymentModel model = new PaymentModel();
						
		List list = model.search(dto,0,0);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			PaymentDTO dto1 = (PaymentDTO) it.next();
			System.out.println(" "+dto.getId());	
			System.out.println(" "+dto.getPaymentDate());
			System.out.println(" "+dto.getDescription());
			System.out.println(" "+dto.getAmount());
			System.out.println(" "+dto.getPaymentMethod());
			System.out.println(" "+dto.getStatus());
			System.out.println(" "+dto.getPayer());
		}
			
		}



	private static void testGet() {
		

		PaymentModel model = new PaymentModel();
		
		PaymentDTO dto = model.findById(2);
		
		System.out.println(" "+dto.getId());	
		System.out.println(" "+dto.getPaymentDate());
		System.out.println(" "+dto.getDescription());
		System.out.println(" "+dto.getAmount());
		System.out.println(" "+dto.getPaymentMethod());
		System.out.println(" "+dto.getStatus());
		System.out.println(" "+dto.getPayer());
			
	}


	private static void testDelete() {

		PaymentDTO dto = new PaymentDTO();
		
		dto.setId(6);
		PaymentModel model = new PaymentModel();
		
		model.delete(dto);
	}
		
		
		
	

	private static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		PaymentDTO dto = new PaymentDTO();
		PaymentModel model = new PaymentModel();
		
		dto.setId(1);
		dto.setPaymentDate(sdf.parse("12-02-2024"));
		dto.setDescription("study loan");
		dto.setAmount(5000);
		dto.setPaymentMethod("cash");
		dto.setStatus("completed");
		dto.setPayer("dipesh");
		
		model.update(dto);
		
	}

	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
		
		PaymentDTO dto = new PaymentDTO();
		PaymentModel model = new PaymentModel();
		
		dto.setPaymentDate(sdf.parse("24-07-2023"));
		dto.setDescription("home loan");
		dto.setAmount(90000);
		dto.setPaymentMethod("cash");
		dto.setStatus("pending");
		dto.setPayer("sagar");
		
		model.add(dto);		
	}
	
}
