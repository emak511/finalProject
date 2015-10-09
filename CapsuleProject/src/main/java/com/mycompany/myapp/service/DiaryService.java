package com.mycompany.myapp.service;

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
}
