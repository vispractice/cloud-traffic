package com.vispractice.vcloud.traffic.domain;

public class TCResponse {

	private int errorCode;
	private String description;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TCResponse(int errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
	}
}
