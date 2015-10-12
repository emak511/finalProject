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
		String check=null;
		Member member=new Member();
		member.setMemberEmail(memberEmail);
		member.setMemberName(memberName);
		member.setMemberPw(memberPW);
		
		if(member.getMemberPw().length()<6){
			check="ErrorPW";
			return "redirect:/login/newMember?check="+check;
		}
		check=memberService.addMember(member);
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
			return "redirect:/mmain";
		}else{
			return "redirect:/login/log?result="+result;
		}
	}
	
	@RequestMapping("/login/findPW")
	public String findPW(String findp, Model model){
		model.addAttribute("findp",findp);
		return "login/findPW";
	}
	
	@RequestMapping("/login/find")
	public String find(String memberEmail, Model model){
		Member find=memberService.findPW(memberEmail);
		String findp=null;
		if(find==null){
			findp="해당 이메일이 존재하지 않습니다";
			return "redirect:/login/findPW?findp="+findp;
		}else{
			findp="비밀번호:"+"\n"+find.getMemberPw();
			return "redirect:/login/findPW?findp="+findp;
		}
	}
}