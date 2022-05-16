package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;

public class ShopDbDao implements IShopDb {

	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet resultSet = null;

	@Override
	public ArrayList<ShopDbDto> innerJoin1() {

		ArrayList<ShopDbDto> result = new ArrayList<ShopDbDto>();

		try {

			String innerJoinQuery1 = "SELECT * FROM usertbl join buytbl on usertbl.userName = buytbl.userName WHERE usertbl.userName = '이승기' ";
			PreparedStatement preparedStatement = connection.prepareStatement(innerJoinQuery1);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ShopDbDto dto = new ShopDbDto();

				dto.setUserName(resultSet.getString("userName"));
				dto.setBirthYear(resultSet.getInt("birthYear"));
				dto.setAddr(resultSet.getString("addr"));
				dto.setMobile(resultSet.getString("mobile"));
				dto.setProdName(resultSet.getString("prodName"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setAmount(resultSet.getInt("amount"));

				result.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<ShopDbDto> leftJoin1() {
		
		ArrayList<ShopDbDto> result = new ArrayList<ShopDbDto>();
		
		try {
			
			String leftJoinQuery1 =  "SELECT * FROM userTbl AS u LEFT JOIN buytbl AS b on u.username = b.username where b.username is not null";
			PreparedStatement preparedStatement = connection.prepareStatement(leftJoinQuery1);
		
			resultSet = preparedStatement.executeQuery();
		
			
			
			while(resultSet.next()) {
				
				ShopDbDto dto = new ShopDbDto();

				dto.setUserName(resultSet.getString("userName"));
				dto.setBirthYear(resultSet.getInt("birthYear"));
				dto.setAddr(resultSet.getString("addr"));
				dto.setMobile(resultSet.getString("mobile"));
				dto.setProdName(resultSet.getString("prodName"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setAmount(resultSet.getInt("amount"));

				result.add(dto);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
		
	}

	@Override
	public void leftJoin2() {

	}

//	//   select *
//	  from usertbl as u
//	  join buytbl as b
//	  on u.userName = b.userName
//	  where u.userName = '이순신';
	
	@Override
	public ArrayList<ShopDbDto> buyInfo(String userName) {
		
		ArrayList<ShopDbDto> result = new ArrayList<ShopDbDto>();
		
		try {
			
			String query = "SELECT * FROM usertbl join buytbl on usertbl.userName = buytbl.userName WHERE usertbl.userName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, userName);
		
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				ShopDbDto dto = new ShopDbDto();

				dto.setUserName(resultSet.getString("userName"));
				dto.setBirthYear(resultSet.getInt("birthYear"));
				dto.setAddr(resultSet.getString("addr"));
				dto.setMobile(resultSet.getString("mobile"));
				dto.setProdName(resultSet.getString("prodName"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setAmount(resultSet.getInt("amount"));
				
				result.add(dto);
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
