package com.mycompany.myapp.dto;

public class Diary {
	
	private int diaryNo;
	private int capsule1;
	private int capsule2;
	private String memberEmail;
	
	public int getDiaryNo() {
		return diaryNo;
	}
	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}
	public int getCapsule1() {
		return capsule1;
	}
	public void setCapsule1(int capsule1) {
		this.capsule1 = capsule1;
	}
	public int getCapsule2() {
		return capsule2;
	}
	public void setCapsule2(int capsule2) {
		this.capsule2 = capsule2;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

}
