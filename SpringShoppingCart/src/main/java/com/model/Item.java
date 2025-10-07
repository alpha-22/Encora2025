package com.model;

import java.io.Serializable;
import java.util.Objects;

//import com.model.billmaster.BillMaster;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Item implements Comparable<Item>,Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	
	private int shopId;
	private String itemDesc;
	private float itemPrice;
	private int unit;

	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId;
	}
	
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", shopId=" + shopId + ", itemDesc=" + itemDesc + ", itemPrice=" + itemPrice
				+ ", unit=" + unit + "]";
	}
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.itemId, o.itemId);
	}
	
	
	
}
