package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import attendance.dto.DBto;
import attendance.dto.PDto;
import attendance.dto.SCDto;

public class MemberDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn;
	
	public MemberDao(Connection conn) {
		this.conn = conn;
	}
	
	//로그인
	public DBto login(String name, String student_id, String password) {
		String sql = "select * from student where name=? and student_id=? and password=?";
		DBto dto = new DBto();
		
		try {
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, student_id);
			System.out.println(pstmt);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setStudent_id(rs.getString("student_id"));
				dto.setPassword(rs.getString("password"));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		return dto;
		
	}
	//로그인(교수)
	public PDto login(String name, String password) {
		String sql = "select * from professor where name=? and userpass=?";
		PDto dto = new PDto();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			System.out.println(pstmt);
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setUserpass(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	//수강신청
	public int code(String student_id, String code) {
		int rs= 0;
		String sql = "UPDATE students set code = ? where student_id=?";
		DBto dto = new DBto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, student_id);
			rs = pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {e.printStackTrace();
		}
	}
	return rs;
	}
	
	//출석부
	public ArrayList<SCDto> schedule(String code) {
		String sql = "select * from schedule where lecturecode=?";
		
		ArrayList<SCDto> list = new ArrayList<SCDto>();
		
		try {
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			System.out.println(pstmt);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				SCDto dto = new SCDto();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setTime(rs.getString("time"));
				dto.setWeek(rs.getString("week"));
				dto.setlecturecode(rs.getString("lecturecode"));
				
				list.add(dto);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		return list;
		
	}
	
	}
