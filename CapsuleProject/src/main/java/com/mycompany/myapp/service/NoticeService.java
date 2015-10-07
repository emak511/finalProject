package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.NoticeDao;
import com.mycompany.myapp.dto.Notice;

@Component
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	
	public List<Notice>  getPage(int pageNo, int rowsPerPage) {
		List<Notice> list = noticeDao.selectByPage(pageNo, rowsPerPage);
		return list;
	}
	
	public Notice getNotice(int noticeNo) {
		Notice notice = noticeDao.selectByPk(noticeNo);
		return notice;
	}
	
	//관리자 이메일 받아서 추가, 수정, 삭제
	public void add(Notice notice, String memberEmail) {
		noticeDao.insert(notice, memberEmail);
	}
	
	
	public void modify(Notice notice, String memberEmail) {
		noticeDao.update(notice, memberEmail);
	}
	
	public void remove(int noticeNo, String memberEmail) {
		noticeDao.delete(noticeNo, memberEmail);
	}
	
	//전체 게시글
	public int getTotalNoticeNo() {
		int rows = noticeDao.selectCount();
		return rows;
	}
	
}
