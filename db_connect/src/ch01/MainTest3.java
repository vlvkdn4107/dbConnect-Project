package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.DocFlavor.URL;

public class MainTest3 {

	private Connection conn;
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt;
	private ResultSet rs;

	public MainTest3() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();
			
			String sql1 = "select * from producttbl";
			rs = stmt.executeQuery(sql1);
			
			while (rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				int cost = rs.getInt("cost");
				String company = rs.getString("company");
				int amount = rs.getInt("amount");
				System.out.println(
						"productId : " + productId + " , " + "productName : " + productName + " , " + "cost : " + cost
								+ " , " + "company : " + company + " , " + "amount : " + amount);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// producttbl
	public static void main(String[] args) {
		new MainTest3();
	}

}
