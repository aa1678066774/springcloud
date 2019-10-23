package com.tww.base;

import java.io.Serializable;

public class CommonResult<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private T data;
	private boolean success;
	private String code="500";

	public CommonResult(String message, T data, boolean success,String code) {
		super();
		this.message = message;
		this.data = data;
		this.success = success;
		this.code=code;
	}
	
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
