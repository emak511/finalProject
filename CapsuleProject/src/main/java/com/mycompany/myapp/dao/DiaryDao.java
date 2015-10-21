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

import com.mycompany.myapp.dto.Diary;


@Component
public class DiaryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Integer insert(Diary diary, String memberEmail){
		Integer pk=null;
		String sql="insert into diarys (diary_title, diary_content, diary_date, diary_c1, diary_c3, member_email) values(?,?,now(),?,?,?)";
		KeyHolder keyHolder=new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
				PreparedStatement pstmt=conn.prepareStatement(sql, new String[] {"diary_dno"});
				pstmt.setString(1, diary.getDiaryTitle());
				pstmt.setString(2, diary.getDiaryContent());
				pstmt.setInt(3, diary.getCapsule1());
				pstmt.setInt(4, diary.getCapsule3());
				pstmt.setString(5, memberEmail);
				return pstmt;
			}
		}, keyHolder);
		Number keyNumber=keyHolder.getKey();
		pk=keyNumber.intValue();
		return pk;
	}
	
	public List<Diary> select(int pageNo, int rowsPerPage, int diary_c1, int diary_c3, String memberEmail){
		String sql="select diary_dno, diary_title, diary_content, diary_date "
				+ "from diarys where diary_c1=? and diary_c3=? and member_email=?"
				+ " order by diary_dno desc "
				+ "limit ?,?";
		List<Diary> list=jdbcTemplate.query(
				sql,
				new Object[] {diary_c1, diary_c3, memberEmail, (pageNo-1)*rowsPerPage, rowsPerPage},
				new RowMapper<Diary>(){
					@Override
					public Diary mapRow(ResultSet rs, int rowNum) throws SQLException{
						Diary diary=new Diary();
						diary.setDiaryNo(rs.getInt("diary_dno"));
						diary.setDiaryTitle(rs.getString("diary_title"));
						diary.setDiaryDate(rs.getDate("diary_date"));
						diary.setDiaryContent(rs.getString("diary_content"));
						return diary;
					}
			});
		return list;
	}
	
	public Diary selectByPk(int diaryNo){
		String sql="select * from diarys where diary_dno=?";
		Diary diary=jdbcTemplate.queryForObject(sql,
				new Object[] {diaryNo},
				new RowMapper<Diary>(){
			@Override
			public Diary mapRow(ResultSet rs, int rowNum) throws SQLException{
				Diary diary=new Diary();
				diary.setDiaryNo(rs.getInt("diary_dno"));
				diary.setDiaryTitle(rs.getString("diary_title"));
				diary.setDiaryContent(rs.getString("diary_content"));
				diary.setCapsule1(rs.getInt("diary_c1"));
				diary.setCapsule3(rs.getInt("diary_c3"));
				diary.setDiaryDate(rs.getDate("diary_date"));
				diary.setMemberEmail(rs.getString("member_email"));
				return diary;
			}
		});
		return diary;
	}
	
	
	
	public int update(Diary diary){
		String sql="update diarys set diary_title=?, diary_content=?, diary_c1=?, diary_c3=? where diary_dno=?";
		int rows=jdbcTemplate.update(
			sql,
			diary.getDiaryTitle(),
			diary.getDiaryContent(),
			diary.getCapsule1(),
			diary.getCapsule3(),
			diary.getDiaryNo()
		);
		return rows;
	}
	
	public int delete(int diaryNo){
		String sql="delete from diarys where diary_dno=?";
		int rows=jdbcTemplate.update(
			sql,
			diaryNo
		);
		return rows;
	}
	
	public int selectCount(int diary_c1, int diary_c3, String member_email){
		String sql="select count(*) from diarys where diary_c1=? and diary_c3=? and member_email=?";
		int rows=jdbcTemplate.queryForObject(
				sql,
				new Object[]{diary_c1, diary_c3, member_email},
				Integer.class
			);
		return rows;
	}
}
