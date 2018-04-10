package com.example.les10_advance2;

import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	List<String> list;
	
	public Dao(List<String> list) {
		// TODO Auto-generated constructor stub
		this.list=list;
	}
	
	public List<String> getAll(){
		
		list.add("ºï×Ó");
		list.add("ĞÉĞÉ");
		list.add("áôáô");
		return list;
	}
}
