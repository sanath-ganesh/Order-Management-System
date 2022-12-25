package com.oms.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.demo.model.Customer;
import com.oms.demo.model.Orders;
import com.oms.demo.service.CustomerService;
import com.oms.demo.service.OrderService;

@RestController
public class OMSController {

	@Autowired
	CustomerService customerService;

	@Autowired
	OrderService orderService;

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer.getName(), customer.getEmail());
	}

	@PostMapping("/order")
	public Orders createOrder(@RequestBody Orders order) {
		return orderService.createOrder(order.getCustomerId(), order.getTotalAmount());
	}

}
