package com.mycompany.myapp.dto;

public class RequestInfo {

	private int requestInfoNo;
	private String requestInfoEmail;
	private int requestInfoType;
	private String memberEmail;
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
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
}