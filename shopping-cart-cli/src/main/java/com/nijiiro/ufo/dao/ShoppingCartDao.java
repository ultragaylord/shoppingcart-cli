package com.nijiiro.ufo.dao;

import com.nijiiro.ufo.exception.FlatFileException;

public interface ShoppingCartDao {
	
	/**
	 * Shows item inside your cart.
	 * @return String output in table form with grand total.
	 * @throws FlatFileException
	 */
	public String showCartItems() throws FlatFileException;
	
}
