package com.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users implements Serializable , Comparable<Users> {

	
	@Id
	@GeneratedValue( strategy =  GenerationType.UUID)
	private UUID id;
	private String name;
	private String pass;
	private boolean flag;
	
	
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	@Override
	public int compareTo(Users o) {
		return 0;
	}

}
