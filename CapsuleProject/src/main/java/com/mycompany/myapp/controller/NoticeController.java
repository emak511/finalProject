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
		//������ ���̽��� �Խù� ���� ����
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
				
		//��ü �Խù� ��
		int totalNoticeNo = noticeService.getTotalNoticeNo();
		
		//��ü ������ ��
		int totalPageNo = totalNoticeNo/rowsPerPage;
		if(totalNoticeNo%rowsPerPage != 0) { totalPageNo++; }
		
		//��ü �׷� ��
		int totalGroupNo = totalPageNo / pagesPerGroup;
		if(totalPageNo%pagesPerGroup != 0) { totalGroupNo++; }
		
		//���� �׷��ȣ, ������������ȣ, ����������ȣ
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo==totalGroupNo) { endPageNo = totalPageNo; }
		
		//���� ������ �Խù� ����Ʈ
		List<Notice> list = noticeService.getPage(pageNo, rowsPerPage);
		
		//View�� �ѱ� ������
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

	
	
	//������
	@RequestMapping("/notice/detail")
	public String detail(int noticeNo, Model model) {
		Notice notice = noticeService.getNotice(noticeNo);
		model.addAttribute("notice", notice);
		return "notice/detail";
	}
	
	
	//����
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
	
	
	//����
	@RequestMapping("/notice/delete/{noticeNo}")
	public String delete(@PathVariable int noticeNo, String memberEmail) {
		noticeService.remove(noticeNo,memberEmail);
		return "redirect:/notice/list";
	}
	
}
