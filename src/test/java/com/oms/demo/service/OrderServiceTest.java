package com.oms.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oms.demo.exception.ResourceNotFoundException;
import com.oms.demo.model.Customer;

@SpringBootTest
public class OrderServiceTest {
	@Autowired
	@InjectMocks
	OrderService orderService;
	
	@Test
	public void testCreateCustomer() {
		
		assertThrows(ResourceNotFoundException.class, () -> orderService.createOrder(1, 1000));		
	}
	
	@Test
	public void testSendEmailsToApproachingCustomers() {
		orderService.sendEmailsToApproachingCustomers();
	}
}
