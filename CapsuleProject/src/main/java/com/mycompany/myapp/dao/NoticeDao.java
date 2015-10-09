package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Notice;

@Component
public class NoticeDao {

		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		
		public List<Notice> selectByPage( int noticeNo, int rowsPerPage) {
			String sql = "";
			sql += "select notice_no, notice_title, notice_date" ;
			sql += "from notices ";
			sql += "order by notice_no desc ";
			sql += "limit ?,?";
			
			List<Notice> list = jdbcTemplate.query(
				sql, 
				new Object[] {(noticeNo-1)*rowsPerPage, rowsPerPage },
				new RowMapper<Notice>() {
					@Override
					public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
						Notice notice = new Notice();
						notice.setNoticeNo(rs.getInt("notice_no"));
						notice.setNoticeTitle(rs.getString("notice_title"));
						notice.setNoticeDate(rs.getDate("notice_date"));
						return notice;
					}
				}
			);
			return list;
		}
		
		public Notice selectByPk(int noticeNo) {
			String sql = "select * from notices where notice_no=? and member_email=?";
			Notice notice = jdbcTemplate.queryForObject(
				sql,
				new Object[] {noticeNo},
				new RowMapper<Notice>() {
					@Override
					public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
						Notice notice = new Notice();
						notice.setNoticeNo(rs.getInt("notice_no"));
						notice.setNoticeTitle(rs.getString("notice_title"));
						notice.setNoticeContent(rs.getString("notice_content"));
						notice.setNoticeDate(rs.getDate("notice_date"));
						return notice;
					}
				}
			);
			return notice;
		}
		
		public Integer insert(Notice notice, String memberEmail) {
			Integer pk = null;
			String sql = "insert into notices(notice_date, notice_title, notice_content, member_email) values(now(),?,?,?) member_email='capsule@naver.com";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"notice_no"});
					pstmt.setString(1, notice.getNoticeTitle());
					pstmt.setString(2, notice.getNoticeContent());
					pstmt.setString(3, memberEmail);
					return pstmt;
				}
			},keyHolder);
			Number keyNumber = keyHolder.getKey();
			pk = keyNumber.intValue();
			return pk;
		}
		
		
		public int update(Notice notice, String memberEmail) {
			String sql = "update notices set notice_title=?, notice_content=? where notice_no=? and member_email='capsule@naver.com'";
			int rows = jdbcTemplate.update(
				sql,
				notice.getNoticeTitle(),
				notice.getNoticeContent(),
				notice.getNoticeNo(), 
				memberEmail
			);
			return rows;
		}
		
		public int delete(int noticeNo, String memberEmail) {
			String sql = "delete from notices where notice_no=? and member_email='capsule@naver.com'";
			int rows = jdbcTemplate.update(
				sql,
				noticeNo,
				memberEmail
			);
			return rows;
		}
		
		public int selectCount() {
			String sql = "select count(*) from notices";
			int rows = jdbcTemplate.queryForObject(sql, Integer.class);
			return rows;
		}

}
