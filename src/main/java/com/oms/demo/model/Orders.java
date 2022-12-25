package com.oms.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int order_id;
	int customerId;
	double totalAmount;
	double discount;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customerId=" + customerId + ", totalAmount=" + totalAmount
				+ ", discount=" + discount + "]";
	}

	public Orders(int customerId, double totalAmount, double discount) {
		this.customerId = customerId;
		this.totalAmount = totalAmount;
		this.discount = discount;
	}

	public Orders() {
	}

}
