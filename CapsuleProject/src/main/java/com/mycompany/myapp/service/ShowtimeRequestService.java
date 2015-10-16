package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.ShowtimeDao;
import com.mycompany.myapp.dao.ShowtimeRequestDao;
import com.mycompany.myapp.dto.Showtime;
import com.mycompany.myapp.dto.ShowtimeRequest;

@Component
public class ShowtimeRequestService {
	@Autowired
	private ShowtimeRequestDao showtimeRequestDao;
	
	@Autowired
	private ShowtimeDao showtimeDao;
	
	//Request List (paging)
	public List<ShowtimeRequest> viewRequestList(int showtimeRequestNo, int pageNo, int rowsPerPage, String memberEmail) {
		List<ShowtimeRequest> list=showtimeRequestDao.selectByPage(showtimeRequestNo, pageNo, rowsPerPage, memberEmail);
		return list;
	}
	
	//Send request 
		public void sendRequest(ShowtimeRequest showtimeRequest, String memberEmail, String friendEmail, Showtime showtime){
			showtimeRequestDao.insert(showtimeRequest, memberEmail, friendEmail, showtime);
		}
		
	//Accept request (showtime + delete in requestList)
	/*public int acceptRequest(int showtimeRequestNo, String memberEmail){
		ShowtimeRequest showtimeRequest = showtimeRequestDao.selectByPk(showtimeRequestNo, memberEmail);
		int capsuleNo = showtimeRequest.getShowtimeNo();
		
		showtimeRequestDao.delete(showtimeRequestNo,memberEmail);
		int showtimePK =showtimeDao.insert(capsuleNo);
		
		//insert한 캡슐 번호 반환
		return showtimePK; 
	}*/
	

    //reject + delete
	public void rejectRequest(int showtimeRequestNo, String memberEmail){
		showtimeRequestDao.delete(showtimeRequestNo,memberEmail);
		
	}
	
	//paging : all showtimeRequests
	public int getTotalNo() {
		int rows = showtimeRequestDao.selectCount();
		return rows;
	}
}
