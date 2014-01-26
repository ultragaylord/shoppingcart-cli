package com.nijiiro.ufo.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.nijiiro.ufo.domain.Product;
import com.nijiiro.ufo.util.ShoppingCartUtility;

public class UtilityTest {
	
	public static String testFileName;
	
	@BeforeClass
	public static void setUp(){
		ShoppingCartAppTest.setUp();
		testFileName = ShoppingCartAppTest.productTestFile;
	}
	
	/**
	 * Test the method in reading a file and
	 * outputs a Array of string.
	 * @throws IOException 
	 */
	@Test
	public void fileToStringArrayTest() throws IOException{
		assertNotNull(testFileName);
		ShoppingCartUtility util = new ShoppingCartUtility(testFileName);
		
		for(Product content:util.getProductList()){
			assertNotEquals(content, "");
			System.out.println(content);
		}
	}
}
