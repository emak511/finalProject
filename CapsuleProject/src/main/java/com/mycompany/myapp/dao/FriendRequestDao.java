
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
import com.mycompany.myapp.dto.Member;

@Component
public class FriendRequestDao {


		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		//insert 요청 들어오는 것 
		public Integer insert(FriendRequest friendRequest, Member member) {
			Integer pk = null;
			String sql = "insert into friendRequests(member_email, member_name) values(?,?)";
			KeyHolder keyHolder = new GeneratedKeyHolder(); 
			jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"friendRequest_no"});
			
				pstmt.setString(1, member.getMemberEmail());
				pstmt.setString(2, member.getMemberName());
					return pstmt;
			}
			},keyHolder);
			Number keyNumber = keyHolder.getKey();
			pk = keyNumber.intValue();
			return pk;
		}
		

		public int delete(int friendRequestNo, String memberEmail) {
			String sql = "delete from friendRequests where friendRequest_no=? and member_email=?";
			int rows = jdbcTemplate.update(
				sql,
				friendRequestNo,
				memberEmail
			);
			return rows;
		}
		
		
		//select
		public List<FriendRequest> selectByPage(int friendRequestNo, int rowsPerPage,Member member) {
			String sql ="select friendRequest_no, member_email from friendRequests where member_email= ? order by friendRequest_no desc limit ?,?";
			
			List<FriendRequest> list = jdbcTemplate.query(
				sql, 
				new Object[] { (friendRequestNo-1)*rowsPerPage, rowsPerPage },
				new RowMapper<FriendRequest>() {
					@Override
					public FriendRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
						FriendRequest friendRequest = new FriendRequest();
						friendRequest.setFriendRequestNo(rs.getInt("friendRequest_no"));
						return friendRequest;
					}
				}
			);
			return list;
		}
		
		public FriendRequest selectByPk(int friendRequestNo, Member member) {
			String sql = "select * from friendRequests where friendRequest_no=? and member_email=?";
			FriendRequest friendRequest = jdbcTemplate.queryForObject(
				sql,
				new Object[] {friendRequestNo},
				new RowMapper<FriendRequest>() {
					@Override
					public FriendRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
						FriendRequest friendRequest = new FriendRequest();
						friendRequest.setFriendRequestNo(rs.getInt("friendRequest_no"));
						member.setMemberEmail(rs.getString("member_email"));
						return friendRequest;
					}
				}
			);
			return friendRequest;
		}
		

	 }


