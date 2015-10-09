package com.mycompany.myapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Diary;
import com.mycompany.myapp.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	
	@RequestMapping("/writeForm")
	public String homewrite(){
		return "redirect:/diary/writeForm";
	}
	
	@RequestMapping("/diary/writeForm")
	public String writeForm(){
		return "diary/writeForm";
	}
	
	@RequestMapping("/diary/writeDiary")
	public String writeDiary(String title, String content, String type, String memberEmail){
		Diary diary=new Diary();
		diary.setDiaryTitle(title);
		diary.setDiaryContent(content);
		diary.setMemberEmail(memberEmail);
		if(type.equals("all")){
			diary.setCapsule1(1);
			diary.setCapsule3(0);
		}else if(type.equals("group")){
			diary.setCapsule1(0);
			diary.setCapsule3(0);
		}else{
			diary.setCapsule1(0);
			diary.setCapsule3(1);
		}
		Integer dd=diaryService.addDiary(diary, memberEmail);
		return "redirect:/diary/writeForm";
	}

}
