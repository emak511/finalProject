
package com.mycompany.myapp.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;
import org.springframework.stereotype.*;

import com.mycompany.myapp.dto.*;

@Component
public class FcapsuleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// Fcapsule 목록 조회 페이징 처리
	public List<Fcapsule> selectByPageNo(String memberEmail, int pageNo, int rowsPerPage)  {

		String sql = "select member_email, FCFlist_gno, Fcapsule_gname from Fcapsule where member_email = ? limit ?, ?";

		List<Fcapsule> list = jdbcTemplate.query(   
				sql,
				new Object[] {memberEmail, (pageNo-1)*rowsPerPage , rowsPerPage},
				new RowMapper<Fcapsule>() {

					@Override 
					public Fcapsule mapRow(ResultSet rs, int rowNum) throws SQLException {
						Fcapsule fCapsule = new Fcapsule();
						fCapsule.setMemberEmail(rs.getString("member_email"));
						fCapsule.setGroupNo(rs.getInt("FCFlist_gno"));
						fCapsule.setfCapsuleGname(rs.getString("Fcapsule_gname"));
						return fCapsule;
					} 	
				}        
 			);
		return list;
	}
	
		//Fcapsule 추가하기
		public Integer insert(String fCapsuleGname, String memberEmail)  {
			Integer pk = null;
			
			String sql = "insert into Fcapsules (Fcapsule_gname, member_email) values(?, ?)";

			KeyHolder keyHolder = new GeneratedKeyHolder(); 
			
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"FCFlist_gno"});
					
					pstmt.setString(1, fCapsuleGname);
					pstmt.setString(2, memberEmail);
					return pstmt;
				}	
			}, keyHolder );
			Number keyNumber = keyHolder.getKey();
			pk = keyNumber.intValue();
			return pk;
		}
		
		//Fcapsule 삭제
		public int delete(int groupNo)  {
			String sql = "delete from Fcapsules where FCFlist_gno= ? ";
			int rows = jdbcTemplate.update(
					sql,
					groupNo
				);
			return rows;
		}
}
