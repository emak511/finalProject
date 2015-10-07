package com.mycompany.myapp.dto;

public class RequestInfo {

	private int requestInfoNo;
	private String requestInfoEmail;
	private int requestInfoType;

	public int getRequestInfoNo() {
		return requestInfoNo;
	}
	public void setRequestInfoNo(int requestInfoNo) {
		this.requestInfoNo = requestInfoNo;
	}
	public String getRequestInfoEmail() {
		return requestInfoEmail;
	}
	public void setRequestInfoEmail(String requestInfoEmail) {
		this.requestInfoEmail = requestInfoEmail;
	}
	public int getRequestInfoType() {
		return requestInfoType;
	}
	public void setRequestInfoType(int requestInfoType) {
		this.requestInfoType = requestInfoType;
	}

}