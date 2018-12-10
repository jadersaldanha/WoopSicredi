package com.support;

public class DatapoolExceptionTest extends RuntimeException {

	private static final long serialVersionUID = -7470771617131416330L;

	public DatapoolExceptionTest(String message) {
		super(message);
	}
	
	public DatapoolExceptionTest(Throwable cause) {
		super(cause);
	}
	
	public DatapoolExceptionTest(String message, Throwable cause) {
		super(message, cause);
	}
}