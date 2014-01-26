package com.nijiiro.ufo.exception;
/**
 * A Generic concrete exception class
 * @author gAiL
 *
 */
public class FlatFileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlatFileException() {
		
	}

	public FlatFileException(String message) {
		super(message);
		
	}

	public FlatFileException(Throwable cause) {
		super(cause);
		
	}

	public FlatFileException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FlatFileException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
