package com.mycompany.myapp.dto;

import java.sql.Date;

public class Showtime {

	
	private String showtimeTitle;
	private Date showtimeDate;
	private String showtimeContent;
	private int showtimeNo;
	private String friendEmail;
	private String memberEmail;
	private Date showtimeWritedate;
	
	public String getShowtimeTitle() {
		return showtimeTitle;
	}
	public void setShowtimeTitle(String showtimeTitle) {
		this.showtimeTitle = showtimeTitle;
	}
	public Date getShowtimeDate() {
		return showtimeDate;
	}
	public void setShowtimeDate(Date showtimeDate) {
		this.showtimeDate = showtimeDate;
	}
	public String getShowtimeContent() {
		return showtimeContent;
	}
	public void setShowtimeContent(String showtimeContent) {
		this.showtimeContent = showtimeContent;
	}

	public String getFriendEmail() {
		return friendEmail;
	}
	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getShowtimeNo() {
		return showtimeNo;
	}
	public void setShowtimeNo(int showtimeNo) {
		this.showtimeNo = showtimeNo;
	}
	public Date getShowtimeWritedate() {
		return showtimeWritedate;
	}
	public void setShowtimeWritedate(Date showtimeWritedate) {
		this.showtimeWritedate = showtimeWritedate;
	}
	
	

	
}
