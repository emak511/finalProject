package com.mycompany.myapp.dto;

import java.util.*;

public class Showtime {

	
	private String showtime_title;
	private Date showtime_date;
	private String showtime_content;
	private String showtime_no;
	private String friend_email;
	private String member_email;
	
	
	public String getShowtime_title() {
		return showtime_title;
	}
	public void setShowtime_title(String showtime_title) {
		this.showtime_title = showtime_title;
	}
	public Date getShowtime_date() {
		return showtime_date;
	}
	public void setShowtime_date(Date showtime_date) {
		this.showtime_date = showtime_date;
	}
	public String getShowtime_content() {
		return showtime_content;
	}
	public void setShowtime_content(String showtime_content) {
		this.showtime_content = showtime_content;
	}
	public String getShowtime_no() {
		return showtime_no;
	}
	public void setShowtime_no(String showtime_no) {
		this.showtime_no = showtime_no;
	}
	public String getFriend_email() {
		return friend_email;
	}
	public void setFriend_email(String friend_email) {
		this.friend_email = friend_email;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
}
