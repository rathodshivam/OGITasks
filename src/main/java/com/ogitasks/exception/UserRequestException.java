package com.ogitasks.exception;

public class UserRequestException extends GenricException {

	public UserRequestException(String message) {
		super(message);
	}

	public UserRequestException(String message, Throwable e) {
		super(message, e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
