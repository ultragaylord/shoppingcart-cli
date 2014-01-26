package com.nijiiro.ufo.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
	
	private List<Product> cartItems;
	private BigDecimal grandTotal;
	
	public ShoppingCart() {
		cartItems = new ArrayList<Product>();
		grandTotal = new BigDecimal(0.00);
	}
	
	public BigDecimal calculateGrandTotal(){
		for(Product item :cartItems){
			grandTotal = item.calculateTotal();
		}
		return grandTotal;
	}
	
	public void addItemsToCart(Product product){
		cartItems.add(product);	
	}
	
	
}
