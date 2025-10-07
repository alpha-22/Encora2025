package com.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompKey implements Serializable{
	
	private int billno;
	private int itemno;
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	@Override
	public String toString() {
		return "CompKey [billno=" + billno + ", itemno=" + itemno + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(billno, itemno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompKey other = (CompKey) obj;
		return billno == other.billno && itemno == other.itemno;
	}
	
}