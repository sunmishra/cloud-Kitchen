package com.serviceonepavilion.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serviceonepavilion.entities.Customer;
import com.serviceonepavilion.services.CustomerService;

@RestController
public class CustomerControllerImpl {

	@Autowired
	private CustomerService custService;

	Logger log = LoggerFactory.getLogger(CustomerControllerImpl.class);

	@GetMapping("/getCustomers")
	public List<Customer> getItems() {
		log.debug("...........Listing Customer........");
		List<Customer> custList = custService.findCustomers();
		log.debug("{}",custList);
		return custList;
	}
	
	@GetMapping("/findCustomer/{id}")
	public Customer findCustomer(@PathVariable int id) {
		log.info("...........Getting Customer {}........", custService.findCustomer(id));
		Customer c = custService.findCustomer(id);
		return c;
	}

	@PostMapping("/addCustomer")
	private int saveorUpdateCustomer(@RequestBody Customer cust) {
		custService.addCustomer(cust);
		return cust.getId();
	}
	
	@DeleteMapping("/removeCustomer/{id}")
	public void removeCustomer(@PathVariable int id) {
		custService.delCustomerById(id);
	}
	
}




