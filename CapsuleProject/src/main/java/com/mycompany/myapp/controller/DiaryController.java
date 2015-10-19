package com.mycompany.myapp.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Diary;
import com.mycompany.myapp.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping("/writeForm")
	public String writeForm1(){
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
		diaryService.addDiary(diary, memberEmail);
		return "redirect:/diary/list?diary_c1="+diary.getCapsule1()+"&diary_c3="+diary.getCapsule3()+"&memberEmail="+diary.getMemberEmail();
	}
	
	@RequestMapping("/list")
	public String list1(int diary_c1, int diary_c3, String memberEmail){
		return "redirect:/diary/list?diary_c1="+diary_c1+"&diary_c3="+diary_c3+"&memberEmail="+memberEmail;
	}
	
	@RequestMapping("/diary/list")
	public String list(@RequestParam(value="pageNo", defaultValue="1") int pageNo,
			int diary_c1, int diary_c3, String memberEmail, Model model,
			HttpSession session){
		
		session.setAttribute("pageNo", pageNo);
		session.setAttribute("memberEmail", memberEmail);
		session.setAttribute("diary_c1", diary_c1);
		session.setAttribute("diary_c3", diary_c3);
		int rowsPerPage=1;
		int totalPageNo=diaryService.getTotalDiaryNo(diary_c1, diary_c3, memberEmail);
		
		List<Diary> list=diaryService.getDiaryList(pageNo, rowsPerPage, diary_c1, diary_c3, memberEmail);
		
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);
		return "diary/list";
		


	}
	
	

	@RequestMapping("/diary/updateForm")
	public String updateForm(int diary_dno, Model model){
		Diary diary=diaryService.getDiary(diary_dno);
		model.addAttribute("diary",diary);
		return "diary/updateForm";
	}
	
	@RequestMapping("/diary/update")
	public String update(Diary diary, String type){
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

		diaryService.modify(diary);
		return "redirect:/diary/list?diary_c1="+diary.getCapsule1()+"&diary_c3="+diary.getCapsule3()+"&memberEmail="+diary.getMemberEmail();
	}
	
	@RequestMapping("/diary/delete")
	public String delete(int diary_dno){
		diaryService.remove(diary_dno);
		return "redirect:/diary/writeForm";
	}
}
