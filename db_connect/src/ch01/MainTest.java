package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {

	// DB 서버와 연결하기 위한 준비물
	private Connection conn; // DB 커넥션 연결 객체
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt; // String --> 쿼리 구문으로 변경해줌
	private ResultSet rs; // 결과값을 받아줌

	// 생성자 !!!
	public MainTest() {

		//
		try {
			// reflect 기법 : 컴파일 시점 문자열 --> 런타임 시점에 실제 클래스가 존재하는지 확인
			// 메모리 (heap) 영역에 올라간다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();

			String sql1 = "select * from memberTBL";
			rs = stmt.executeQuery(sql1);

			while(rs.next()) {
				String memberId = rs.getString("memberId");
				String memberName = rs.getString("memberName");
				System.out.println("id : " + memberId + " , " + "name : " + memberName);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	// 코드의 시작점
	public static void main(String[] args) {
		new MainTest();
	} // end of main

}
