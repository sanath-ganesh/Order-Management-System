package com.oms.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.oms.demo.dao.CustomerRepo;
import com.oms.demo.dao.OrderRepo;
import com.oms.demo.exception.ResourceNotFoundException;
import com.oms.demo.model.Customer;
import com.oms.demo.model.Orders;

@Service
public class OrderService {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	CustomerService customerService;

	public Orders createOrder(int customerId, double amount) {
		Customer customer = customerRepo.findById(customerId).orElse(null);

		if (customer == null) {
			throw new ResourceNotFoundException("Customer not found with id: " + customerId);
		}

		double discount = 0;

		if (customer.getCustomerType().equals("gold")) {
			discount = amount * 0.1;
		} else if (customer.getCustomerType().equals("platinum")) {
			discount = amount * 0.2;
		}
		Orders order = new Orders(customerId, amount, discount);
		orderRepo.save(order);
		customer.setOrderCount(customer.getOrderCount() + 1);
		customerRepo.save(customer);
		if (customer.getOrderCount() == 10) {
			customerService.promoteToGold(customer.getCustomerId());
		} else if (customer.getOrderCount() == 20) {
			customerService.promoteToPlatinum(customer.getCustomerId());
		}
		return order;
	}

	@Scheduled(cron = "0 0 * * * *")
	@Async
	public void sendEmailsToApproachingCustomers() {
		List<Customer> customers = customerRepo.findAll();
		for (Customer customer : customers) {
			if (customer.getOrderCount() == 9) {
				System.out.println(
						"You have placed 9 orders with us. Buy one more stuff and you will be promoted to Gold customer and enjoy 10% discounts!");
			} else if (customer.getOrderCount() == 19) {
				System.out.println(
						"You have placed 19 orders with us. Buy one more stuff and you will be promoted to Platinum customer and enjoy 20% discounts!");
			}
		}
	}

}
