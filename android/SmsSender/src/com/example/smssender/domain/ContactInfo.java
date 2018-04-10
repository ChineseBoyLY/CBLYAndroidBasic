package com.example.smssender.domain;

public class ContactInfo {
	private String name;
	private String number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ContactInfo(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	public ContactInfo() {
		super();
	}
	
	
}
