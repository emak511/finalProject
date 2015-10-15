package com.mycompany.myapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.mycompany.myapp.dao.*;
import com.mycompany.myapp.dto.*;

@Component
public class CapsuleService {
	
	@Autowired
	private FCFlistDao fcfListDao;	
	@Autowired
	private FcapsuleDao fCapsuleDao;
	@Autowired
	private FCdiaryDao fcDiaryDao;

	//FCFlist 친구추가
	public void addFCFlist(int groupNo, String memberEmail){
		fcfListDao.insert(groupNo, memberEmail);
	}
	//FCFlist 캡슐 볼 수 있는 권한을 가진 친구보기
	public List<FCFlist>  getFCFlist(String memberEmail, int pageNo, int rowsPerPage) {
		List<FCFlist> list = fcfListDao.selectByPageNo(memberEmail, pageNo, rowsPerPage);
		return list;
	}	
	//FCFlist 친구삭제
	public void removeFCFlist(String memberEmail, int groupNo) {
		fcfListDao.delete(memberEmail, groupNo);
		}
	
	//fCapsule 목록 조회
	public List<Fcapsule> getFcapsule(String memberEmail){
		List <Fcapsule> list =  fCapsuleDao.select("capsule@naver.com");
		return list;
	}
	
	//fCapsule 추가하기
	public void addFcapsule(String fCapsuleGname,String memberEmail){
		fCapsuleDao.insert(fCapsuleGname, memberEmail);
	}
	
	//fCapsule 삭제하기
	public void removefCapsule(int groupNo){
		fCapsuleDao.delete(groupNo);
	}
	
	//fcDiary 목록 조회
	public List<FCdiary> getFCdiary(String memberEmail){
		List <FCdiary> list =  fcDiaryDao.select(memberEmail);
		return list;
	}
	
	//fcDiary 추가하기
	public void addfcDairy(String memberEmail, Diary diary, Fcapsule fCapsule){
		fcDiaryDao.insert(memberEmail, diary, fCapsule);
	}
	//fcDiary 삭제하기
	public void removefcDiary(int FCdiaryNo){
		fcDiaryDao.delete(FCdiaryNo);
	}
	
	
}
