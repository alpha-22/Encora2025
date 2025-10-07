package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillMaster implements Serializable,Comparable<BillMaster>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	@ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private CustomerMaster customer;
	
	private Date date;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public CustomerMaster getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(billId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillMaster other = (BillMaster) obj;
		return billId == other.billId;
	}
	@Override
	public int compareTo(BillMaster o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.billId, this.billId);
	}
	@Override
	public String toString() {
		return "BillMaster [billId=" + billId + ", customer=" + customer + ", date=" + date + "]";
	}
	
	
}
