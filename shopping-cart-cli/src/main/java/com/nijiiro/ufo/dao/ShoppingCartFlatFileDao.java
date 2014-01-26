package com.nijiiro.ufo.dao;

import java.io.IOException;
import java.util.List;

import com.nijiiro.ufo.domain.AppConstants;
import com.nijiiro.ufo.domain.Product;
import com.nijiiro.ufo.exception.FlatFileException;
import com.nijiiro.ufo.util.ShoppingCartUtility;

public class ShoppingCartFlatFileDao implements ShoppingCartDao {
	
	private String fileName;
	
	public ShoppingCartFlatFileDao(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * Implements the showing of product items in shopping cart
	 * @throws FlatFileException 
	 */
	public String showCartItems() throws FlatFileException {
		ShoppingCartUtility utility = new ShoppingCartUtility(fileName);
		List<Product> productList;
		try {
			productList = utility.getProductList();
			
		//Holds the string representation of the products.
		StringBuilder cartBuilder = new StringBuilder();

		//If the list is empty, show a message.
		if(productList.isEmpty()){
			cartBuilder.append(AppConstants.SHOPPING_CART_IS_EMPTY_MESSAGE.getValue());
		}else {
			utility.buildShoppingCartTable(cartBuilder);
		}
				
		return cartBuilder.toString();
		
		} catch (IOException e) {
			throw new FlatFileException("Unable to show products",e);
		}
	}

}
