package com.orderservice.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description="primary key",example="1")
	private Long id;
	private Long productId;
	private int quantity;
	private double price;
	private LocalDateTime orderDate;
	public Order() {
	}
	public Order(Long productId, int quantity, double price, LocalDateTime orderDate) {
		
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	// Getters & Setters
	public Long getId() {
		return id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
}