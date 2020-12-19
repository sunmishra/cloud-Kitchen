package com.serviceonepavilion.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serviceonepavilion.entities.Customer;
import com.serviceonepavilion.models.Login;
import com.serviceonepavilion.services.CustomerService;

@Controller
public class LoginControllerImpl {
	
	@Autowired
	private CustomerService custService;
	
	@RequestMapping("/index")
	public String index(Model model) {		
		model.addAttribute("command",new Login());
		return "index";		
	}
	
	
//	@RequestMapping("/auth")
//	public String authenticate(Login l, HttpSession session) {  
//										 
//		Customer cust = custService.findCustomer(l.getEmail(), l.getPassword());
//		if(cust != null) {
//			session.setAttribute("customer", cust);
//			session.setAttribute("cart", new ArrayList<Integer>());
//			return "redirect:getItems";
//		}
//		else
//			return "failed";
//	}
	
	@RequestMapping("/logout")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
}
