package com.oms.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.demo.dao.CustomerRepo;
import com.oms.demo.exception.ResourceNotFoundException;
import com.oms.demo.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	public Customer createCustomer(String name, String email) {
		Customer customer = new Customer(name, email, "regular", 0);
		customerRepo.save(customer);
		return customer;
	}

	public void promoteToGold(int id) {
		Customer customer = customerRepo.findById(id).orElse(null);
		if (customer == null) {
			throw new ResourceNotFoundException("Customer not found with id: " + id);
		}

		if (customer.getOrderCount() >= 10) {
			customer.setCustomerType("gold");
			customerRepo.save(customer);
		}
	}

	public void promoteToPlatinum(int id) {
		Customer customer = customerRepo.findById(id).orElse(null);
		if (customer == null) {
			throw new ResourceNotFoundException("Customer not found with id: " + id);
		}

		if (customer.getOrderCount() >= 20) {
			customer.setCustomerType("platinum");
			customerRepo.save(customer);
		}
	}

}
