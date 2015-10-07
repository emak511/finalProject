package com.mycompany.myapp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Notice;
import com.mycompany.myapp.service.NoticeService;


@Controller
public class NoticeController {
private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice/write",method=RequestMethod.GET)
	public String writeForm() {
		return "notice/writeForm";
	}
	
	@RequestMapping(value="/notice/write",method=RequestMethod.POST)	
	public String write(Notice notice, String memberEmail, HttpSession session) {	
		//데이터 베이스에 게시물 정보 저장
		noticeService.add(notice, memberEmail);		
		return "redirect:/notice/list";
	}
	
	@RequestMapping("/notice/list")
	public String list(
			@RequestParam(value="pageNo", defaultValue="1") int pageNo, 
			Model model, 
			HttpSession session) {
		logger.info("pageNo: " + pageNo);
		
		session.setAttribute("pageNo", pageNo);
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
				
		//전체 게시물 수
		int totalNoticeNo = noticeService.getTotalNoticeNo();
		
		//전체 페이지 수
		int totalPageNo = totalNoticeNo/rowsPerPage;
		if(totalNoticeNo%rowsPerPage != 0) { totalPageNo++; }
		
		//전체 그룹 수
		int totalGroupNo = totalPageNo / pagesPerGroup;
		if(totalPageNo%pagesPerGroup != 0) { totalGroupNo++; }
		
		//현재 그룹번호, 시작페이지번호, 끝페이지번호
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo==totalGroupNo) { endPageNo = totalPageNo; }
		
		//현재 페이지 게시물 리스트
		List<Notice> list = noticeService.getPage(pageNo, rowsPerPage);
		
		//View로 넘길 데이터
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);
		
		return "notice/list";
	}

	
	
	//디테일
	@RequestMapping("/notice/detail")
	public String detail(int noticeNo, Model model) {
		Notice notice = noticeService.getNotice(noticeNo);
		model.addAttribute("notice", notice);
		return "notice/detail";
	}
	
	
	//수정
	@RequestMapping("/notice/updateForm")
	public String updateForm(@RequestParam("bno") int noticeNo, Model model) {
		Notice notice = noticeService.getNotice(noticeNo);
		model.addAttribute("notice", notice);
		return "notice/updateForm";
	}
	
	@RequestMapping("/notice/update")
	public String update(Notice notice, String memberEmail) {
		noticeService.modify(notice, memberEmail);
		return "redirect:/notice/detail?noticeNo="+notice.getNoticeNo();
	}
	
	
	//삭제
	@RequestMapping("/notice/delete/{noticeNo}")
	public String delete(@PathVariable int noticeNo, String memberEmail) {
		noticeService.remove(noticeNo,memberEmail);
		return "redirect:/notice/list";
	}
	
}
