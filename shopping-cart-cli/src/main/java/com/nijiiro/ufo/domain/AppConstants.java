package com.nijiiro.ufo.domain;

public enum AppConstants {
	
	TABDELIMETER("\t"),
	NEWLINE("\n"),
	TABLE_HEADER("No\tName\tPrice\tQty"),
	PRODUCT_LIST_IS_EMPTY_MESSAGE("No Products available for purchase."),
	SHOPPING_CART_IS_EMPTY_MESSAGE("Your cart is empty."),
	
	COMMAND_SHOW_PRODUCT_LIST("list-products"),
	COMMAND_BUY_PRODUCT("buy"),
	COMMAND_SHOW_CART("show-cart"),
	
	PRODUCT_FILE_PATH("G:\\004 - Workspace\\shopping-cart-cli\\src\\main\\resource\\product-list.txt"),
	CART_FILE_PATH("G:\\004 - Workspace\\shopping-cart-cli\\src\\main\\resource\\shoppingcart-list.txt");
	
	;
	
	
	
	private String value;
	private AppConstants(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
}
