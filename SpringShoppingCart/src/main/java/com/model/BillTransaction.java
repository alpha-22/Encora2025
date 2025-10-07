package com.model;

import java.io.Serializable;
import java.util.Objects;

import com.model.CompKey;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class BillTransaction implements Serializable,Comparable<BillTransaction>{
	// composite key
		@EmbeddedId
		private CompKey mykey;
		private int qty;

		

		
		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public CompKey getMykey() {
			return mykey;
		}

		public void setMykey(CompKey mykey) {
			this.mykey = mykey;
		}

		

		

		@Override
		public int hashCode() {
			return Objects.hash(mykey);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BillTransaction other = (BillTransaction) obj;
			return Objects.equals(mykey, other.mykey);
		}

		@Override
		public int compareTo(BillTransaction o) {
			// TODO Auto-generated method stub
			int compareItem=Integer.compare(this.mykey.getItemno(), o.mykey.getItemno());
			int compareBill=Integer.compare(this.mykey.getBillno(), o.mykey.getBillno());
			Integer result=compareItem & compareBill;
//			if(compareItem==1 && compareBill==1) {
//				return 1;
//			}
//			else {
//				return 0;
//			}
//			return Optional.ofNullable(result).map(n->result).orElse(0);
			return result;
			
		}

		@Override
		public String toString() {
			return "BillTransaction [mykey=" + mykey + ", qty=" + qty + "]";
		}

		
		
}
