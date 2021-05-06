package com.example.product_usuer_order;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class UserOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	@ManyToOne
	private Product products;
	
	private int quantity;
	
	@CreationTimestamp
	private LocalDateTime orderTime;
	
	@UpdateTimestamp
	private LocalDateTime lastModified;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDateTime getLastModified() {
		return lastModified;
	}
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
	@Override
	public String toString() {
		return "UserOrder [orderId=" + orderId + ", products=" + products + ", quantity=" + quantity + ", orderTime="
				+ orderTime + ", lastModified=" + lastModified + "]";
	}
	
	

}
