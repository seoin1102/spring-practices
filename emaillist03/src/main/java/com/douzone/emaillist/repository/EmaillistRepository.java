package com.douzone.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistRepository {
	public static boolean insert(EmaillistVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.10.46:3306/webdb?charset=utf8";
			
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. SQL 준비
			String sql = "insert into emaillist values(null, ?, ?, ?)"; //값을 바인딩시킴. 치환시키는것이 아님!
			pstmt = connection.prepareStatement(sql);
			
			//4. Mapping(bind)
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());


			//5. SQL 실생
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection !=null) {
					connection.close();
				}
				}catch(SQLException e) {
					
				}
			}
		
			return result;
	}
	
	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
	try {
		connection = getConnection();
		//1. JDBC Driver 로딩 (JDBC Class 로딩: class loader)
		Class.forName("org.mariadb.jdbc.Driver");
		
		//2. 연결하기
		String url = "jdbc:mysql://192.168.10.46:3306/webdb?charset=utf8";
		
		connection = DriverManager.getConnection(url, "webdb", "webdb");
		
		//3. Statment 생성
		String sql = "select no, first_name, last_name, email \r\n"
				+ "from emaillist order by no desc";
		pstmt = connection.prepareStatement(sql);
		
		//4. SQL 실생
		

		rs = pstmt.executeQuery();
		
		//5. 결과처리
		while(rs.next()) {
			Long no = rs.getLong(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);


			EmaillistVo vo = new EmaillistVo();
			vo.setNo(no);
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			
			result.add(vo);
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 로딩 실패:" + e);
	}finally {
		try {
			if(rs != null) {
				pstmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(connection !=null) {
				connection.close();
			}
			}catch(SQLException e) {
				
			}
		}
			
		return result;
}
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mysql://192.168.10.46:3306/webdb?charset=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"+ e);
		}
		return connection;
	}

}
