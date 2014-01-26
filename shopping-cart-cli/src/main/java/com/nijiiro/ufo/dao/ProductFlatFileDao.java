package com.nijiiro.ufo.dao;

import java.io.IOException;
import java.util.List;

import com.nijiiro.ufo.domain.AppConstants;
import com.nijiiro.ufo.domain.Product;
import com.nijiiro.ufo.exception.FlatFileException;
import com.nijiiro.ufo.util.ShoppingCartUtility;

public class ProductFlatFileDao implements ProductDao {
	
	private String fileName;
	
	public ProductFlatFileDao(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * Implements the showing of product from flat file.
	 * @throws FlatFileException 
	 */
	public String showProducts() throws FlatFileException {
		ShoppingCartUtility utility = new ShoppingCartUtility(fileName);
		List<Product> productList;
		try {
			productList = utility.getProductList();
			
			//Holds the string representation of the products.
			StringBuilder productBuilder = new StringBuilder();
	
			//If the list is empty, show a message.
			if(productList.isEmpty()){
				productBuilder.append(AppConstants.PRODUCT_LIST_IS_EMPTY_MESSAGE.getValue());
			}else {
				utility.buildProductTable(productBuilder);
			}
					
			return productBuilder.toString();
		
		} catch (IOException e) {
			throw new FlatFileException("Unable to show products",e);
		}
	}
	

}
