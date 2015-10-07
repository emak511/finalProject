package com.mycompany.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login/log")
	public String log(String result, Model model){
		model.addAttribute("result",result);
		return "login/log";
	}
	
	@RequestMapping("/login/newMember")
	public String newMember(String check, Model model){
		model.addAttribute("check",check);
		return "login/newMember";
	}
	
	@RequestMapping("/login/add")
	public String add(String memberEmail, String memberName, String memberPW, Model model){
		Member member=new Member();
		member.setMemberEmail(memberEmail);
		member.setMemberName(memberName);
		member.setMemberPw(memberPW);
		String check=memberService.addMember(member);
		if(check.equals("OK")){
			return "redirect:/login/log";
		}else{
			return "redirect:/login/newMember?check="+check;
		}
	}
	
	@RequestMapping("/login/logcheck")
	public String logcheck(String memberEmail, String memberPW, HttpSession session, Model model){
		String result=memberService.login(memberEmail, memberPW, session);
		if(result.equals("OK")){
			return "redirect:/";
		}else{
			return "redirect:/login/log?result="+result;
		}
	}
}