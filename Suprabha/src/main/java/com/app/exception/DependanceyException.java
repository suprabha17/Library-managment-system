package com.app.exception;



public class DependanceyException extends RuntimeException {

	public DependanceyException(String msg)
	{
		super(msg);
	}
	
	public DependanceyException(String msg,Throwable cause)
	{
		super(msg,cause);
	}
	
	
}
