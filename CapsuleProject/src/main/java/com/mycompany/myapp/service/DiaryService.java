package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.DiaryDao;
import com.mycompany.myapp.dto.Diary;

@Component
public class DiaryService {
	@Autowired
	private DiaryDao diaryDao;
	
	public Integer addDiary(Diary diary, String memberEmail){
		Integer d=diaryDao.insert(diary, memberEmail);
		return d;
	}
	
	public List<Diary> getDiaryList(int pageNo, int rowsPerPage, int diary_c1, int diary_c3, String memberEmail){
		List<Diary> list=diaryDao.select(pageNo, rowsPerPage, diary_c1, diary_c3, memberEmail);
		return list;
	}
	
	public Diary getDiary(int diaryNo){
		Diary diary=diaryDao.selectByPk(diaryNo);
		return diary;
	}
	
	public void modify(Diary diary){
		diaryDao.update(diary);
	}
	
	public void remove(int diaryNo){
		 diaryDao.delete(diaryNo);
	}
	
	public int getTotalDiaryNo(int diary_c1, int diary_c3, String member_email){
		int rows=diaryDao.selectCount(diary_c1, diary_c3, member_email);
		return rows;
	}
}
