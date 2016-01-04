package com.edia.tsearch.rest.service.exceptions;

/**
 * Error code enums 
 * @author mehmetyaman
 *
 */
public enum ERROR_CODES {
	
	ERROR_1(1,"ERROR_1 No title or content set, please set a content here ");

	 private int code;
	 private String description;
	 
	private ERROR_CODES(int errorNumber, String errorStatement) {
		this.code = errorNumber;
		this.description = errorStatement;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}


}
