package com.raysdata.kapacitor_cli.exception;

public class BlankException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BlankException(){
		super();
	}
	public BlankException(String mess){
		super(mess);
	}
}
