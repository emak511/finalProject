package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.dao.ShowtimeRequestDao;
import com.mycompany.myapp.dto.Diary;
import com.mycompany.myapp.dto.ShowtimeRequest;

public class ShowtimeRequestService {
	@Autowired
	private ShowtimeRequestDao showtimeRequestDao;
	
	//요청 다 보기
	public List<ShowtimeRequest> viewRequestList(int showtimeRequestNo, int rowsPerPage,String memberEmail){
		List<ShowtimeRequest> list=showtimeRequestDao.selectByPage(showtimeRequestNo,rowsPerPage, memberEmail);
		return list;
	}
	
	//타임캡슐 승락 =보기 
	public int acceptRequest(int showtimeRequestNo){
		showtimeRequest.delete()
		
	}
	public void remove(int diaryNo){
		 diaryDao.delete(diaryNo);
	}
	
	//거절
/*	rejectRequest
	*/
	//
}
