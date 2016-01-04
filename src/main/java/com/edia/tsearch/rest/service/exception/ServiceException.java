package com.edia.tsearch.rest.service.exception;

/**
 * 
 * @author mehmetyaman
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -4687953846493463402L;
	
	private String detail;

	public ServiceException(String detail) {
		super();
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
