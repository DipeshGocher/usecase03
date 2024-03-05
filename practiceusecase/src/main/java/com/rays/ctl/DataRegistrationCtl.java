package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.PaymentDTO;
import com.rays.model.PaymentModel;

@WebServlet("/DataRegistrationCtl")
public class DataRegistrationCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("DataRegistrationView.jsp");
		
		rd.forward(req, resp);
		

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		String id = req.getParameter("id");
		PaymentModel model = new PaymentModel();
		PaymentDTO dto = new PaymentDTO();
		try {
			dto.setPaymentDate(sdf.parse(req.getParameter("paymentDate")));
		} catch (Exception e) {		
		}
		dto.setDescription(req.getParameter("description"));
		dto.setAmount(Integer.parseInt(req.getParameter("amount")));
		dto.setPaymentMethod(req.getParameter("paymentmethod"));
		dto.setStatus(req.getParameter("status"));
		dto.setPayer(req.getParameter("payer"));
		
		String op = req.getParameter("operation");
		 System.out.println("in iff");
		
			model.add(dto);	
			req.setAttribute("msg","Data added");
			RequestDispatcher rd = req.getRequestDispatcher("DataRegistrationView.jsp");
			rd.forward(req, resp);

		
		
System.out.println("Out iff");
	
	}	
		
	}


