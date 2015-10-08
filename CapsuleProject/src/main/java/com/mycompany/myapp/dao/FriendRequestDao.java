
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
import com.mycompany.myapp.dto.FriendRequest;

@Component
public class FriendRequestDao {


/*	 		@Autowired
	 		private JdbcTemplate jdbcTemplate;
	 		
	 		public Integer insert(RequestInfo requestInfo, String memberEmail) {
	 			Integer pk = null;
	 			String sql = "insert into requests(request_email, request_type, member_email) values(?,?,?)";
	 			KeyHolder keyHolder = new GeneratedKeyHolder();
	 			jdbcTemplate.update(new PreparedStatementCreator() {
	 				@Override
	 				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
	 					PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"request_no"});
	 					pstmt.setString(1, requestInfo.getRequestInfoEmail());
	 					pstmt.setInt(2, requestInfo.getRequestInfoType());
	 					pstmt.setString(3, memberEmail);
	 					return pstmt;
	 				}
	 			},keyHolder);
	 			Number keyNumber = keyHolder.getKey();
	 			pk = keyNumber.intValue();
	 			return pk;
	 		}
	 		
	 		public List<RequestInfo> selectByPage(int requestNo, int rowsPerPage, String memberEmail) {
	 			String sql ="select request_no, request_email, request_type from requests where memberEmail= ? order by request_no desc limit ?,?";
	 			
	 			List<RequestInfo> list = jdbcTemplate.query(
	 				sql, 
	 				new Object[] { (requestNo-1)*rowsPerPage, rowsPerPage },
	 				new RowMapper<RequestInfo>() {
	 					@Override
	 					public RequestInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
	 						RequestInfo requestInfo = new RequestInfo();
	 						requestInfo.setRequestInfoNo(rs.getInt("request_no"));
	 						requestInfo.setRequestInfoEmail(rs.getString("request_email"));
	 						requestInfo.setRequestInfoType(rs.getInt("request_type"));
	 						
	 						return requestInfo;
	 					}
	 				}
	 			);
	 			return list;
	 		}
	 		
	 		public RequestInfo selectByPk(int requestInfoNo, String memberEmail) {
	 			String sql = "select * from requests where request_no=?";
	 			RequestInfo requestInfo = jdbcTemplate.queryForObject(
	 				sql,
	 				new Object[] {requestInfoNo},
	 				new RowMapper<RequestInfo>() {
	 					@Override
	 					public RequestInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
	 						RequestInfo requestInfo = new RequestInfo();
	 						requestInfo.setRequestInfoNo(rs.getInt("request_no"));
	 						requestInfo.setRequestInfoEmail(rs.getString("request_email"));
	 						requestInfo.setRequestInfoType(rs.getInt("request_type"));
	 						memberEmail;
	 						return requestInfo;
	 					}
	 				}
	 			);
	 			return requestInfo;
	 		}
	 		

	 		public int delete(int requestInfoNo, String memberEmail) {
	 			String sql = "delete from requests where request_no=? and memberEmail=?";
	 			int rows = jdbcTemplate.update(
	 				sql,
	 				requestInfoNo,
	 				memberEmail
	 			);
	 			return rows;
	 		}
	 		*/

	 }


