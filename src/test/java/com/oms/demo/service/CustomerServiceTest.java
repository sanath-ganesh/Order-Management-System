package com.oms.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oms.demo.dao.CustomerRepo;
import com.oms.demo.exception.ResourceNotFoundException;
import com.oms.demo.model.Customer;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	@InjectMocks
	CustomerService customerService;
	
	@Mock
	CustomerRepo customerRepo;
	
	@Test
	public void testCreateCustomer() {
		
		Customer mockCustomer = mock(Customer.class);
        when(customerRepo.save(any(Customer.class))).thenReturn(mockCustomer);

        assertNotNull(customerService.createCustomer("Sanath", "sanath@mail.com"));
		
	}
	
	@Test
	public void testPromoteToGold() {
		//when id is not present
		assertThrows(ResourceNotFoundException.class, () -> customerService.promoteToGold(10));
		
	}
	
	@Test
	public void testPromoteToPlatinum() {
		//when id is not present
		assertThrows(ResourceNotFoundException.class, () -> customerService.promoteToPlatinum(20));
		
	}

}
