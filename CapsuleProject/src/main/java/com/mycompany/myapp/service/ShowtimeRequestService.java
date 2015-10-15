package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.dao.ShowtimeDao;
import com.mycompany.myapp.dao.ShowtimeRequestDao;
import com.mycompany.myapp.dto.ShowtimeRequest;

public class ShowtimeRequestService {
	@Autowired
	private ShowtimeRequestDao showtimeRequestDao;
	
	@Autowired
	private ShowtimeDao showtimeDao;
	
	//��û �� ����
	public List<ShowtimeRequest> viewRequestList(int showtimeRequestNo, int rowsPerPage,String memberEmail){
		List<ShowtimeRequest> list=showtimeRequestDao.selectByPage(showtimeRequestNo,rowsPerPage, memberEmail);
		return list;
	}
	
	//Ÿ��ĸ�� �¶� =���� 
	public int acceptRequest(int showtimeRequestNo, String member_email){
		ShowtimeRequest showtimeReqest = showtimeRequestDao.selectByPk(showtimeRequestNo, member_email);
		int capsuleno = showtimeReqest.getShowtimeNo();
		
		showtimeRequestDao.delete(showtimeRequestNo,member_email);
		int showtimePK =showtimeDao.insert(capsuleno);
		
		//insert한 캡슐 번호 반환
		return showtimePK; 
	}

	

    //요청받은 캡슐 거절햇을 떄 삭제	
	public void rejectRequest(int showtimeRequestNo, String member_email){
		
		showtimeRequestDao.delete(showtimeRequestNo,member_email);
		
	}
}
