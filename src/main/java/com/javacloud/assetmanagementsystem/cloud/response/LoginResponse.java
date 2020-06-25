package com.javacloud.assetmanagementsystem.cloud.response;


public class LoginResponse<T> {
	
	private boolean error;
	
	private String message;
	
	T data;
	
	private String token;
	
	public LoginResponse() {

	}

	public LoginResponse(boolean error, String message, T data, String token) {
		this.error = error;
		this.message = message;
		this.data = data;
		this.token = token;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "LoginResponse [error=" + error + ", message=" + message + ", data=" + data + ", token=" + token + "]";
	}


	
	 
}
