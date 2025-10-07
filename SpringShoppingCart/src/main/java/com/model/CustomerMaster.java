package com.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerMaster implements Serializable,Comparable<CustomerMaster>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private int customerName;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerName() {
		return customerName;
	}
	public void setCustomerName(int customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMaster other = (CustomerMaster) obj;
		return customerId == other.customerId;
	}
	@Override
	public int compareTo(CustomerMaster o) {
		
		return Integer.compare(o.customerId, this.customerId);
	}
	@Override
	public String toString() {
		return "CustomerMaster [customerId=" + customerId + ", customerName=" + customerName + "]";
	}
	
}
