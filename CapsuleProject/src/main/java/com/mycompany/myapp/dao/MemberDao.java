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
import org.springframework.stereotype.Component;


import com.mycompany.myapp.dto.Member;

@Component
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String insert(Member member){
		String sql = "insert into members"
				+ " (member_email, member_name, member_pw, member_request, member_friends) "
				+ "values (?, ?, ?, 0, 0)";
		
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberEmail());
				pstmt.setString(2, member.getMemberName());
				pstmt.setString(3, member.getMemberPw());
				
				return pstmt;
			}
			
		});
		return member.getMemberEmail();
	}
	
	public Member select(String memberEmail){
		String sql="select * from members where member_email =?";
		List<Member> list=jdbcTemplate.query(sql,
				new Object[] {memberEmail},
				new RowMapper<Member>(){
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
						Member member=new Member();
						member.setMemberEmail(rs.getString("member_email"));
						member.setMemberName(rs.getString("member_name"));
						member.setMemberPw(rs.getString("member_pw"));
						member.setMemberFriend(rs.getInt("member_friends"));
						member.setMemberRequest(rs.getInt("member_request"));
						return member;
					}
				}
			);
			if(list.isEmpty()){
				return null;
				
			}else{
				Member member=list.get(0);
				return member;
			}
	}
	
	public int updateLoginDate(Member member) {
		String sql = "update members set member_logindate=now() where member_email=?";
		int rows = jdbcTemplate.update(
			sql,
			member.getMemberEmail()
		);
		return rows;
	}
	
	public int updateRequest(Member member){
		String sql="update members set member_request=? where member_email=?";
		int rows=jdbcTemplate.update(
				sql,
				member.getMemberRequest(),
				member.getMemberEmail()
		);
		return rows;
	}
	
	public int updateFriend(Member member){
		String sql="update members set member_friends=? where member_email=?";
		int rows=jdbcTemplate.update(
				sql,
				member.getMemberFriend(),
				member.getMemberEmail()
		);
		return rows;
	}
	
	public int delete(String memberEmail) {
		String sql = "delete from members where member_email=?";
		int rows = jdbcTemplate.update(
			sql,
			memberEmail
		);
		return rows;
	}
	
	public List<Member> selectByFriends(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "select member_email, member_name " ;
		sql += "from members ";
		sql += "limit ?,?";
		
		List<Member> list = jdbcTemplate.query(
			sql, 
			new Object[] { (pageNo-1)*rowsPerPage, rowsPerPage },
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member=new Member();
					member.setMemberEmail(rs.getString("member_email"));
					member.setMemberName(rs.getString("member_name"));
					return member;
				}
			}
		);
		return list;
	}
	
}
