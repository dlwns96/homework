package com.tech.spring_tx_board.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tech.spring_tx_board.dto.BoardDto;

public class BoardDao {
	DataSource dataSource;
	public BoardDao() {
		System.out.println("BoardDao() 호출");
		//db 접속객체 얻기
		try {
			Context context=new InitialContext();
			dataSource=
					(DataSource) context.lookup("java:comp/env/jdbc/orcl");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	}
	public ArrayList<BoardDto> list() {
		System.out.println("dao list()");
		//db에서 데이터 추출 list에 담아 리턴
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			String sql="select bid,bname,btitle,bcontent,"
					+"bdate,bhit,bgroup," 
					+"bstep,bindent from mvc_board "
					+"order by bgroup desc,bstep asc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				int bid=rs.getInt("bid");
				String bname=rs.getString("bname");
				String btitle=rs.getString("btitle");
				String bcontent=rs.getString("bcontent");
				Timestamp bdate=rs.getTimestamp("bdate");
				int bhit=rs.getInt("bhit");
				int bgroup=rs.getInt("bgroup");
				int bstep=rs.getInt("bstep");
				int bindent=rs.getInt("bindent");
				//db에서 데이터 가져온 상태
				BoardDto dto=new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;	
	}

}
