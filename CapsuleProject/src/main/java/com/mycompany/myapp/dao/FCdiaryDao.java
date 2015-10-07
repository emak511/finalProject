
package com.mycompany.myapp.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;
import org.springframework.stereotype.*;

import com.mycompany.myapp.dto.*;
@Component
public class FCdiaryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// FCdiary목록 보기 페이징 처리
	public List<FCdiary> selectByPageNo(String memberEmail, int pageNo, int rowsPerPage)  {

		String sql = "select * from Fcdiarys where member_email = ? limit ?, ?";

		List<FCdiary> list = jdbcTemplate.query(   
				sql,
				new Object[] {memberEmail, (pageNo-1)*rowsPerPage , rowsPerPage},
				new RowMapper<FCdiary>() {

					@Override
					public FCdiary mapRow(ResultSet rs, int rowNum) throws SQLException {
						FCdiary fcDiary = new FCdiary();
						fcDiary.setGroupNo(rs.getInt("FCFlist_gno"));
						fcDiary.setDiaryNo(rs.getInt("diary_dno"));
						fcDiary.setMemberEmail(rs.getString("member_email"));
						return fcDiary;
					} 	
				}        
 			);
		return list;
	}
	
	// FCdiary 목록 조회
		public List<FCdiary> select(String memberEmail)  {

			String sql = "select  * from Fcapsules where member_email = ? ";
			List<FCdiary> list = jdbcTemplate.query(  
					sql,
					new Object[] {memberEmail},
					new RowMapper<FCdiary>() {
					
						@Override 
						public FCdiary mapRow(ResultSet rs, int rowNum) throws SQLException {
							FCdiary fcDiary = new FCdiary();
							fcDiary.setFCdiaryNo(rs.getInt("FCdiary_no"));
							fcDiary.setDiaryNo(rs.getInt("diary_dno"));
							fcDiary.setGroupNo(rs.getInt("FCFlist_gno"));
							fcDiary.setMemberEmail(rs.getString("member_email"));						
							return fcDiary;
						} 
					}        
	 			);
			return list;

		}
	
	// FCdiary  추가
	public Integer insert(String memberEmail, Diary diary, Fcapsule fCapsule)  {
		Integer pk = null;
		
		String sql = "insert into FCdiarys (FCFlist_gno, diary_dno, member_email) values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"FCdiary_no"});
				
				pstmt.setInt(2, diary.getDiaryNo());
				pstmt.setInt(1, fCapsule.getGroupNo());
				pstmt.setString(3, memberEmail);
				return pstmt;
			}	
		}, keyHolder );
		Number keyNumber = keyHolder.getKey();
		pk = keyNumber.intValue();
		return pk;
	}
	
	// FCdiary 삭제
	public int delete(int FCdiaryNo)  {
		String sql = "delete from FCdiarys where FCdiary_no= ? ";
		int rows = jdbcTemplate.update(
				sql,
				FCdiaryNo
			);
		return rows;
	}
}