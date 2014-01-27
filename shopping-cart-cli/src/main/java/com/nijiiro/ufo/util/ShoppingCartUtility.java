package com.nijiiro.ufo.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.nijiiro.ufo.domain.Product;
import com.nijiiro.ufo.domain.ShoppingCart;
import com.nijiiro.ufo.domain.AppConstants;

public class ShoppingCartUtility {

	private String fileName;
	private List<Product> productList;
	
	/**
	 * Constructor which takes filename for processing.
	 * @param fileName
	 */
	public ShoppingCartUtility(String fileName){
		this.fileName = fileName;
		productList = new ArrayList<Product>();
	}
	
	
	/**
	 * Converts characters from a file and return an Array of String.
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Product> getProductList() throws IOException{
		int index = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while(br.ready()){
			index ++;
			Product product = setValuesToProduct(index, br.readLine());
			productList.add(product);
		}
		br.close();
		
		return productList;
	}
	
	/**
	 * Builds and arrange the product list in table form.
	 * @param productBuilder
	 */
	public void buildProductTable(StringBuilder productBuilder){
		//Puts a table header.
		productBuilder.append(AppConstants.PRODUCT_TABLE_TITLE.getValue());
		productBuilder.append(AppConstants.NEWLINE.getValue());
		buildProductTableHeader(productBuilder);
		
		for(Product product: productList){
			productBuilder.append(product.arrangeProductFields());
			productBuilder.append(AppConstants.NEWLINE.getValue());
		}
	}
	
	
	/**
	 * Sets the values for product object from the file.
	 * @param index
	 * @param content
	 * @return
	 */
	private Product setValuesToProduct(int index, String content) {
		Product product = new Product();
		String[] splittedString  = content.split(AppConstants.TABDELIMETER.getValue());
		
		product.setId(index);
		product.setName(splittedString[0]);
		product.setQuantity(Integer.parseInt(splittedString[1]));
		product.setPrice(new BigDecimal(splittedString[2]));
		return product;
	}

	/**
	 * Build the common table headers defined in
	 * {@link AppConstants}
	 * 
	 * @param productBuilder
	 */
	private void buildProductTableHeader(StringBuilder productBuilder) {
		productBuilder.append(AppConstants.TABLE_HEADER.getValue());
		productBuilder.append(AppConstants.NEWLINE.getValue());
	}

	/**
	 * Builds and arrange the shopping item list in table form.
	 * @param cartBuilder
	 */
	public void buildShoppingCartTable(StringBuilder cartBuilder) {
		ShoppingCart cart = new ShoppingCart();
		cartBuilder.append(AppConstants.CART_TABLE_TITLE.getValue());
		cartBuilder.append(AppConstants.NEWLINE.getValue());
		buildProductTableHeader(cartBuilder);
		
		for(Product product: productList){
			cartBuilder.append(product.arrangeProductFields());
			cartBuilder.append(AppConstants.NEWLINE.getValue());
			cart.addItemsToCart(product);
		}
		
		cartBuilder.append("Grand Total : "+cart.calculateGrandTotal());
	}
	
	
}
