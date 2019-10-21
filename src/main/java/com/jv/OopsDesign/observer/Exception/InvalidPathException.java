package com.jv.OopsDesign.observer.Exception;

/**
 * 
 * @author jeevi.natarajan
 *
 */
public class InvalidPathException extends RuntimeException {

	private static final long serialVersionUID = -8618030494369453454L;
	
	public InvalidPathException(String message) {
		super(message);
	}
	
	public InvalidPathException(String message, Throwable cause) {
		super(message,cause);
	}

}
