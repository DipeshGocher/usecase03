package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.PaymentDTO;
import com.rays.model.PaymentModel;

@WebServlet("/PaymentListCtl")
public class PaymentListCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PaymentDTO	dto=null;
		PaymentModel model=new PaymentModel();
		List list=model.search(dto,0,0);
		RequestDispatcher rd=req.getRequestDispatcher("PaymentListView.jsp");
		req.setAttribute("List", list);		
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String op=req.getParameter("operation");
		PaymentDTO dto=null;
		PaymentModel model= new PaymentModel();
		System.out.println("dipesh");
		
		if (op!=null && op.equalsIgnoreCase("search")) {
			System.out.println("search done");
		     dto=new PaymentDTO();
			try {
				dto.setPaymentDate(sdf.parse(req.getParameter("paymentDate")));
			} catch (Exception e) {				
			}
			dto.setDescription(req.getParameter("description"));
			dto.setAmount(Integer.parseInt(req.getParameter("amount")));
			dto.setPaymentMethod(req.getParameter("paymentmethod"));
			dto.setStatus(req.getParameter("status"));
			dto.setPayer(req.getParameter("payer"));
					
		}
		if (op.equalsIgnoreCase("delete")) {
			System.out.println("success delete");
			String[] ids=req.getParameterValues("ids");
			for (String id : ids) {
				PaymentDTO dto1=new PaymentDTO();
				dto1.setId(Integer.parseInt(id));
				model.delete(dto1);
			}
			
		}
			List list=model.search(dto,0,0);
			System.out.println("got it");
			req.setAttribute("List", list);
			RequestDispatcher rd=req.getRequestDispatcher("PaymentListView.jsp");
			rd.forward(req, resp);
			


		}
	}


