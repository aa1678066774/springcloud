package com.tww.base;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ApiResult")
public class ApiResult<T> extends CommonResult<T> {
    
    public ApiResult() {
        this(null);
    }
    
    public ApiResult(String code) {
        this(null,code);
    }

    public ApiResult(T data,String code) {
        this(data, true,code);
    }

    public ApiResult(T data, boolean success,String code) {
        this(null,data, success,code);
    }

    public ApiResult( String message,T data, boolean success,String code) {
        super(message,data, success,code);
    }

	public void error(String string) {
		// TODO Auto-generated method stub
		this.setSuccess(false);
		this.setMessage(string);
		this.setData(null);
	}
}
