package com.oms.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
