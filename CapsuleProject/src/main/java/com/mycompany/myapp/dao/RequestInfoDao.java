
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
import com.mycompany.myapp.dto.RequestInfo;

@Component
public class RequestInfoDao {


	 		@Autowired
	 		private JdbcTemplate jdbcTemplate;
	 		
	 		public Integer insert(RequestInfo requestInfo) {
	 			Integer pk = null;
	 			String sql = "insert into requests(request_email, request_type, member_email) values(?,?,?)";
	 			KeyHolder keyHolder = new GeneratedKeyHolder();
	 			jdbcTemplate.update(new PreparedStatementCreator() {
	 				@Override
	 				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
	 					PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"request_no"});
	 					pstmt.setString(1, requestInfo.getRequestInfoEmail());
	 					pstmt.setInt(2, requestInfo.getRequestInfoType());
	 					pstmt.setString(3, requestInfo.getMemberEmail());
	 					return pstmt;
	 				}
	 			},keyHolder);
	 			Number keyNumber = keyHolder.getKey();
	 			pk = keyNumber.intValue();
	 			return pk;
	 		}
	 		
	 		public List<RequestInfo> selectByPage(int requestNo, int rowsPerPage) {
	 			String sql = "";
	 			sql += "select request_no, request_email, request_type, memberEmail" ;
	 			sql += "from requests";
	 			sql += "order by request_no desc ";
	 			sql += "limit ?,?";
	 			
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
	 						requestInfo.setMemberEmail(rs.getString("member_email"));
	 						return requestInfo;
	 					}
	 				}
	 			);
	 			return list;
	 		}
	 		
	 		public RequestInfo selectByPk(int requestInfoNo) {
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
	 						requestInfo.setMemberEmail(rs.getString("member_email"));
	 						return requestInfo;
	 					}
	 				}
	 			);
	 			return requestInfo;
	 		}
	 		

	 		public int delete(long requestInfoNo) {
	 			String sql = "delete from requests where request_no=?";
	 			int rows = jdbcTemplate.update(
	 				sql,
	 				requestInfoNo
	 			);
	 			return rows;
	 		}
	 		

	 }


