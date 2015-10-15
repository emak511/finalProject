package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.mycompany.myapp.dto.Showtime;
import com.mycompany.myapp.dto.ShowtimeRequest;



@Component
public class ShowtimeRequestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//insert ��û ������ �� (���� ����)
	public Integer insert(ShowtimeRequest showtimeRequest, String memberEmail, String friendEmail, Showtime showtime) {
		Integer pk = null;
		String sql = "insert into showtimeRequests(member_email, friend_email, showtime_no, "
				+ "showtime_title, showtime_date, showtime_writedate) values(?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"showtimeRequest_no"});
			
			pstmt.setString(1, memberEmail);
			pstmt.setString(2, friendEmail);
			pstmt.setInt(3,  showtime.getShowtimeNo());
			pstmt.setString(4,  showtime.getShowtimeTitle());
			pstmt.setDate(5, showtime.getShowtimeDate());
			pstmt.setDate(6, showtime.getShowtimeWritedate());
				return pstmt;
		}
		},keyHolder);
		Number keyNumber = keyHolder.getKey();
		pk = keyNumber.intValue();
		return pk;
	}
	

	public int delete(int showtimeRequestNo, String memberEmail) {
		String sql = "delete from showtimeRequests where showtimeRequestNo=? and member_email=?";
		int rows = jdbcTemplate.update(
			sql,
			showtimeRequestNo,
			memberEmail
		);
		return rows;
	}
	
	
	//select
	public List<ShowtimeRequest> selectByPage(int showtimeRequestNo, int rowsPerPage, String memberEmail) {
		String sql ="select showtimeRequest_no, member_email from showtimeRequests "
				+ "where member_email= ? order by showtimeRequest_no desc limit ?,?";
			
		List<ShowtimeRequest> list = jdbcTemplate.query(
			sql, 
			new Object[] { (showtimeRequestNo-1)*rowsPerPage, rowsPerPage },
			new RowMapper<ShowtimeRequest>() {
				@Override
				public ShowtimeRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
					ShowtimeRequest showtimeRequest = new ShowtimeRequest();
					showtimeRequest.setShowtimeRequestNo(rs.getInt("showtimeRequest_no"));
					return showtimeRequest;
				}
			}
		);
		return list;
	}
	
	//�¶��� ��û�� ��Ÿ�� �־��ֱ� 
	public ShowtimeRequest selectByPk(int showtimeRequestNo, String memberEmail) {
		String sql = "select * from showtimeRequests where showtimeRequest_no=? and member_email=?";
		ShowtimeRequest showtimeRequest = jdbcTemplate.queryForObject(
			sql,
			new Object[] {showtimeRequestNo},
			new RowMapper<ShowtimeRequest>() {
				@Override
				public ShowtimeRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
					ShowtimeRequest showtimeRequest = new ShowtimeRequest();
					showtimeRequest.setShowtimeRequestNo(rs.getInt("showtimeRequest_no"));
					showtimeRequest.setShowtimeNo(rs.getInt("showtime_no"));
					return showtimeRequest;
				}
			}
		);
		return showtimeRequest;
	}
	
}
