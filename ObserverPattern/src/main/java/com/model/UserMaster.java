package com.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserMaster implements Serializable , Comparable<UserMaster>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String userpass;
	private int flag;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMaster other = (UserMaster) obj;
		return userid == other.userid;
	}
	@Override
	public String toString() {
		return "UserMaster [userid=" + userid + ", username=" + username + ", userpass=" + userpass + ", flag=" + flag + "]";
	}
	@Override
	public int compareTo(UserMaster o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.userid,o.userid);
	}

	
}
