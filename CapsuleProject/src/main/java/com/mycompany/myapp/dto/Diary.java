package com.mycompany.myapp.dto;

import java.sql.Date;

public class Diary {
	
	private int diaryNo;
	private int capsule1;
	private int capsule3;
	private String memberEmail;
	private String diaryTitle;
	private String diaryContent;
	private Date diaryDate;
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
	public int getCapsule3() {
		return capsule3;
	}
	public void setCapsule3(int capsule3) {
		this.capsule3 = capsule3;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getDiaryTitle() {
		return diaryTitle;
	}
	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public Date getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}
	public String getDiaryContent() {
		return diaryContent;
	}
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	
	

}
