
package com.mycompany.myapp.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;
import org.springframework.stereotype.*;

import com.mycompany.myapp.dto.*;

@Component
public class FCFlistDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//캡슐을 볼 수 있는 권한을 가진 친구목록 보기 페이징처리
	public List<FCFlist> selectByPageNo(String memberEmail, int pageNo, int rowsPerPage)  {

		String sql = "select member_email, FCFlist_gno from FCFlist where member_email = ? limit ?, ?";

		List<FCFlist> list = jdbcTemplate.query(   
				sql,
				new Object[] {memberEmail, (pageNo-1)*rowsPerPage , rowsPerPage},
				new RowMapper<FCFlist>() {

					@Override 
					public FCFlist mapRow(ResultSet rs, int rowNum) throws SQLException {
						FCFlist fcfList = new FCFlist();
						fcfList.setMemberEmail(rs.getString("member_email"));
						fcfList.setGroupNo(rs.getInt("FCFlist_gno"));
						return fcfList;
					} 	
				}        
 			);
		return list;
	}
	
	//캡슐을 볼 수 있는 친구 추가하기
	public void insert(int groupNo, String memberEmail) {
		Integer pk = null;
		String sql = "insert into FCFlist (FCFlist_gno, member_email) values(?, ?)";
			KeyHolder keyHolder=new GeneratedKeyHolder();
			jdbcTemplate.update(
					sql, 
					memberEmail, 
					groupNo 
			);	
	}
	
	//캡슐을 볼 수 있는 친구 삭제하기
	public int delete(String memberEmail, int groupNo)  {
		String sql = "delete from FCFlist where member_email= ?, FCFlist_gno= ? ";
		int rows = jdbcTemplate.update(
				sql,
				memberEmail, groupNo
			);
		return rows;
	}
}