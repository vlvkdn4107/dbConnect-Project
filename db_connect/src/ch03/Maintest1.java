package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch02.DBClient;

public class Maintest1 {

	public static void main(String[] args) {

		// object는 main 메서드에서 new 하기 때문에 언제 태어나서 언제 죽을 수 있는 것들을 말하고
		// static 만들어진 것들은 프로그램 시작과 끝으로만 처리된다.
		// DBClient.getInstance() (new )
		DBClient client = DBClient.getInstance();
		Connection connection = client.getConnection();
		ResultSet resultSet = null;
		
		// 데이터 한 건 조회
		// Statement stmt = connection.createStatement();
		
		try {
			String selectQuery1 = "SELECT * FROM memberTBL WHERE memberId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			preparedStatement.setString(1, "jsa");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberID"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}

			System.out.println("=============================");
//			String selectQuery2 = "SELECT * FROM memberTBL WHERE memberId IN(?, ?)";
//			preparedStatement = connection.prepareStatement(selectQuery2);
//			preparedStatement.setString(1, "jsa");
//			preparedStatement.setString(2, "Han");
//			
//			resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				System.out.println(resultSet.getString("memberID"));
//				System.out.println(resultSet.getString("memberName"));
//				System.out.println(resultSet.getString("memberAddress"));
//			}
//			
//			System.out.println("=============================");
//
//			// insert 데이터 등록
//			String insertQuery = "INSERT INTO memberTBL VALUES(?, ?, ?)";
//			preparedStatement = connection.prepareStatement(insertQuery);
//			preparedStatement.setString(1, "boot1");
//			preparedStatement.setString(2, "개발자");
//			preparedStatement.setString(3, "서울판교");
//			
//			int resultCount = 0;
//			resultCount = preparedStatement.executeUpdate();
//			
//			if(resultCount >= 1) {
//				System.out.println("정상 등록 되었습니다.");
//			} else {
//				System.out.println("동일한 아이디가 존재하거나 잘못된 입력입니다.");
//			}
			
			// update : 데이터 수정
			String updateQuery = "UPDATE memberTBL SET memberName = ? WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, "이름변경1");
			preparedStatement.setString(2, "boot1");
			
			int updateCount = preparedStatement.executeUpdate();
			System.out.println("updateCount : " + updateCount);
			
			// delete 데이터 삭제
			String deleteQuery = "DELETE FROM memberTBL WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, "boot1");
			
			int deleteCount = preparedStatement.executeUpdate();
			System.out.println(deleteCount);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
