package com.nijiiro.ufo.domain;

import java.math.BigDecimal;

public class Product {
	
	private int id;
	private String name;
	private BigDecimal price;
	private int quantity;
	
	private final static String TAB = "\t";
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(BigDecimal price) {
		
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String arrangeProductFields(){
		
		StringBuilder builder = new StringBuilder();

		builder.append(id);
		builder.append(TAB);
		builder.append(name);
		builder.append(TAB);
		builder.append(price);
		builder.append(TAB);
		builder.append(quantity);
		return builder.toString();
	}

	public BigDecimal calculateTotal() {
		return new BigDecimal(quantity).multiply(price) ;
	}
	
}
