package com.oms.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.demo.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
