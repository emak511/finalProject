package com.mycompany.myapp.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.MemberDao;
import com.mycompany.myapp.dto.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public String addMember(Member member){
		String check=null;
		/* 회원가입 하려는 이메일이 데이터베이스에 존재하는지 확인 */
		Member mem=memberDao.select(member.getMemberEmail());
		
		/* 존재하지 않으면 중복 회원가입이 아니기 때문에 회원가입 성공 */
		if(mem==null){
			check="OK";
			memberDao.insert(member);

		}else{  // 존재하면 중복 회원가입이므로 회원가입 실패
			check="Fail";
		}
		return check;
	}
	
	public String login(String memberEmail, String memberPW, HttpSession session){
		String state=null;
		Member member=memberDao.select(memberEmail);
		
		if(member!=null){
			if(memberEmail.equals(member.getMemberEmail())){
				if(memberPW.equals(member.getMemberPw())){
					memberDao.updateLoginDate(member);
					session.setAttribute("memberEmail", memberEmail);
					state="OK";
				}else{
					state="wrongPw";
				}
			}
		}else{
			state="wrongEmail";
		}
		return state;
	}
	
	public void Delete(String memberEmail){
		memberDao.delete(memberEmail);
	}
	
	
	
}
