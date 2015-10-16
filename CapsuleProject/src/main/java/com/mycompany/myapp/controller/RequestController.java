package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Diary;
import com.mycompany.myapp.dto.ShowtimeRequest;
import com.mycompany.myapp.service.ShowtimeRequestService;

@Controller
public class RequestController {
	
//showtime Request
	
			@Autowired
			private ShowtimeRequestService showtimeRequestService;
			
			@RequestMapping("/request/list")
			public String list(int showtimeRequestNo,  int rowsPerPage, int pageNo, String memberEmail, Model model){
				List<ShowtimeRequest> list=showtimeRequestService.viewRequestList(showtimeRequestNo, rowsPerPage, pageNo, memberEmail);
				model.addAttribute("list", list);
				return "request/list";
			}
			//paging 
			/*@RequestMapping("/request/list")
			public String list(
				@RequestParam(value="pageNo", defaultValue="1") int pageNo, int showtimeRequestNo, String memberEmail, Model model, HttpSession session) {
			
				session.setAttribute("pageNo", pageNo);
				
				int rowsPerPage = 10;
				int pagesPerGroup = 5;
				int totalBoardNo = showtimeRequestService.getTotalNo();
				
				int totalPageNo = totalBoardNo/rowsPerPage;
				if(totalBoardNo%rowsPerPage != 0) { totalPageNo++; }
				
				int totalGroupNo = totalPageNo / pagesPerGroup;
				if(totalPageNo%pagesPerGroup != 0) { totalGroupNo++; }
				
				int groupNo = (pageNo-1)/pagesPerGroup + 1;
				int startPageNo = (groupNo-1)*pagesPerGroup + 1;
				int endPageNo = startPageNo + pagesPerGroup - 1;
				if(groupNo==totalGroupNo) { endPageNo = totalPageNo; }
				
				List<ShowtimeRequest> list = showtimeRequestService.viewRequestList(showtimeRequestNo, pageNo, rowsPerPage, memberEmail);
				
				model.addAttribute("pagesPerGroup", pagesPerGroup);
				model.addAttribute("totalPageNo", totalPageNo);
				model.addAttribute("totalGroupNo", totalGroupNo);
				model.addAttribute("groupNo", groupNo);
				model.addAttribute("startPageNo", startPageNo);
				model.addAttribute("endPageNo", endPageNo);
				model.addAttribute("pageNo", pageNo);
				model.addAttribute("list", list);
				
				return "request/list";
			}
			
			//reject
			@RequestMapping("/request/rejectRequest/{showtimeRequestNo}")
			public String delete(@PathVariable int showtimeRequestNo, String memberEmail) {
				showtimeRequestService.rejectRequest(showtimeRequestNo, memberEmail);
				return "redirect:/request/list";
			}*/
			
			
//===================================================================
//friend Request			
			
			
	}

