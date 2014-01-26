package com.nijiiro.ufo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.nijiiro.ufo.dao.ProductDao;
import com.nijiiro.ufo.dao.ProductFlatFileDao;
import com.nijiiro.ufo.dao.ShoppingCartDao;
import com.nijiiro.ufo.dao.ShoppingCartFlatFileDao;
import com.nijiiro.ufo.exception.FlatFileException;


/**
 * Test Class for the product lists.
 * @author gAiL
 *
 */
public class ShoppingCartAppTest {
	
	private final static String ACTUAL_PROJECT_HOME = "G:\\004 - Workspace\\shopping-cart-cli";
	private final static String ACTUAL_TESTFILE_PATH = "src\\test\\resource";
	
	private final static String ACTUAL_P_TESTFILENAME = "product-list.txt";
	private final static String ACTUAL_P_TESTFILENAME_EMPTY = "product-list-empty.txt";
	
	private final static String ACTUAL_SC_TESTFILENAME = "shoppingcart-list.txt";
	private final static String ACTUAL_SC_TESTFILENAME_EMPTY = "shoppingcart-list-empty.txt";
	
	
	public static String productTestFile;
	public static String productTestEmptyFile;
	
	public static String cartTestFile;
	public static String cartTestEmptyFile;
	
	
	@BeforeClass
	public static void setUp(){
		productTestFile = ACTUAL_TESTFILE_PATH+File.separator+ACTUAL_P_TESTFILENAME;
		productTestEmptyFile = ACTUAL_TESTFILE_PATH+File.separator+ACTUAL_P_TESTFILENAME_EMPTY;
		
		cartTestFile = ACTUAL_TESTFILE_PATH+File.separator +ACTUAL_SC_TESTFILENAME;
		cartTestEmptyFile = ACTUAL_TESTFILE_PATH+File.separator +ACTUAL_SC_TESTFILENAME_EMPTY;
		
	}
	
	/**
	 * Test for existence of a file.
	 * @throws IOException 
	 * 
	 */
	@Test
	public void testFileExistence() throws IOException{
		String expectedFilePath = "src\\test\\resource";
		String expectedFileName = "product-list.txt";
		
		File productFile = new File(productTestFile);
		assertNotNull(productFile);
		assertEquals(expectedFilePath +File.separator +expectedFileName,productFile.getPath());
		
	}
	
	/**
	 * Test for reading from file.
	 * @throws IOException 
	 */
	@Test
	public void testFileReader() throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(ACTUAL_PROJECT_HOME +File.separator +productTestFile));
		System.out.println("Test for Flat File Content: ");
		while(reader.ready()){
			String line = reader.readLine();
			System.out.println(line);
			assertNotNull(line);
		}
		reader.close();
		
	}
	
	
	/**
	 * UC-SC001
	 * Test for displaying products.
	 * @throws IOException 
	 * @throws FlatFileException 
	 */
	@Test
	public void testProductDisplay() throws FlatFileException{
		System.out.println("Test for Show Product: ");
		ProductDao product = new ProductFlatFileDao(productTestFile);
		System.out.println(product.showProducts());
	}
	
	/**
	 * UC-SC002
	 * Test for displaying products.
	 * @throws IOException 
	 * @throws FlatFileException 
	 */
	@Test
	public void testProductDisplayWithEmptyFile() throws FlatFileException{
		System.out.println("Test for Empty Product: ");
		ProductDao product = new ProductFlatFileDao(productTestEmptyFile);
		System.out.println(product.showProducts());
	}
	
	/**
	 * UC-SC003
	 * Test for displaying shopping cart items.
	 * @throws FlatFileException 
	 * 
	 */
	@Test
	public void testCartItemDisplay() throws FlatFileException{
		System.out.println("Test for Show Cart: ");
		ShoppingCartDao cart = new ShoppingCartFlatFileDao(cartTestFile);
		assertNotNull(cart.showCartItems());
		System.out.println(cart.showCartItems());
	}
	
	/**
	 * UC-SC004
	 * Test for displaying empty shopping cart
	 * @throws FlatFileException 
	 * 
	 */
	@Test
	public void testEmptyCart() throws FlatFileException{
		System.out.println("Testing for Empty Shopping Cart");
		ShoppingCartDao emptyCart = new ShoppingCartFlatFileDao(cartTestEmptyFile);
		assertNotNull(emptyCart.showCartItems());
		System.out.println(emptyCart.showCartItems());
	}
	
	
}
