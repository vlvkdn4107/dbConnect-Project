package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest5 {
	
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
	
	
	private Statement stmt;
	private ResultSet rs;
	
	public MainTest5(){
		try(Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from membertbl");
			
			
			while(rs.next()) {
				
				String id = rs.getString("memberId");
				String name = rs.getString("memberName");
				
				System.out.println("Id : " + id + " , " + "Name : " + name);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new MainTest5();
	}
	
	
}
