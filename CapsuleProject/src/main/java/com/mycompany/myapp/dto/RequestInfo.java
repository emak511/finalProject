package com.mycompany.myapp.dto;

public class RequestInfo {

	private int requestNo;
	private String requestEmail;
	private int requestType;
	private String memberEmail;
	
	public int getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}
	public String getRequestEmail() {
		return requestEmail;
	}
	public void setRequestEmail(String requestEmail) {
		this.requestEmail = requestEmail;
	}
	public int getRequestType() {
		return requestType;
	}
	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
}
