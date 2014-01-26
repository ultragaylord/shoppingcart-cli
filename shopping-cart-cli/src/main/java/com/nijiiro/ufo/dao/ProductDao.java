package com.nijiiro.ufo.dao;

import com.nijiiro.ufo.exception.FlatFileException;

public interface ProductDao {
	
	/**
	 * Shows the product list.
	 * @return String output in table form with grand total.
	 * @throws FlatFileException 
	 */
	public String showProducts() throws FlatFileException;
	
}
