package com.nijiiro.ufo.main;

import com.nijiiro.ufo.dao.ProductDao;
import com.nijiiro.ufo.dao.ProductFlatFileDao;
import com.nijiiro.ufo.dao.ShoppingCartDao;
import com.nijiiro.ufo.dao.ShoppingCartFlatFileDao;
import com.nijiiro.ufo.domain.AppConstants;
import com.nijiiro.ufo.exception.FlatFileException;

public class Runner {

	public static void main(String[] args) throws FlatFileException {
		ProductDao productDao = new ProductFlatFileDao(AppConstants.PRODUCT_FILE_PATH.getValue());
		ShoppingCartDao cartDao = new ShoppingCartFlatFileDao(AppConstants.CART_FILE_PATH.getValue());
		
		if(args.length > 0){
			
			switch (args[0]) {
			
			case "list-products":
				
				System.out.println(productDao.showProducts());
				break;
				
			case "show-cart":
				System.out.println(cartDao.showCartItems());
				break;
				
				
			default:
				System.out.println("Invalid Command Exiting App. . .");
				break;
			}
		}else{
			System.out.println("No Command Specified. . .");
		}
		System.exit(0);
	}
}
