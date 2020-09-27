package com.miw.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	private HashMap<String, Integer> list;
	
	public ShoppingCart() {
		this.list = new HashMap<String, Integer>();
	}
	
	public HashMap<String, Integer> getList(){
		return list;
	}
		
	public void setList(HashMap<String, Integer> list) {
		this.list = list;
	}

	public void add(String element) {
		Integer num = list.get(element);
		if( num != null ) {
			list.remove(element);
			num++;
			list.put(element, num);
		}
		else {
			list.put(element, 1);
		}
	}
	
	public void mostrar() {
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
		    System.out.println(entry.getKey() + ":   " + entry.getValue());
		}
	}

}
