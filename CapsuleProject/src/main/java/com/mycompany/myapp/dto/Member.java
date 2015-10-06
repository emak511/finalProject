package com.mycompany.myapp.dto;

import java.util.*;

public class Member {

	private String memberEmail;
	private String memberName;
	private String memberPw;
	private int memberFriend;
	private Date loginDate;
	private int memberRequest;
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public int getMemberFriend() {
		return memberFriend;
	}
	public void setMemberFriend(int memberFriend) {
		this.memberFriend = memberFriend;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public int getMemberRequest() {
		return memberRequest;
	}
	public void setMemberRequest(int memberRequest) {
		this.memberRequest = memberRequest;
	}
	
}
