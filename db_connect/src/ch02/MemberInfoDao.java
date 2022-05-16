package ch02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberInfoDao implements IMemberInfoDao {

	private static final String TABLE_NAME = "memberTBL";
	// DBClient를 통해서 DB 접속 처리를 하자 !
	private DBClient dbClient;
	private Connection conn;

	public MemberInfoDao() {
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	}

	@Override
	public synchronized ArrayList<MemberDto> select() {

		ArrayList<MemberDto> dataResult = new ArrayList<MemberDto>();

		String sqlFormat;
		String sql;

		sqlFormat = "SELECT * FROM %s";
		sql = String.format(sqlFormat, TABLE_NAME);

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberDto dto = new MemberDto();
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddress(rs.getString("memberAddress"));

				dataResult.add(dto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dataResult;

	}

	@Override
	public synchronized  int insert(MemberDto dto) {
		String sqlFormat = "INSERT INTO %s VALUES('%s', '%s', '%s')";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberId(), dto.getMemberName(),
				dto.getMemberAddress());

		Statement stmt = null;
		int result = 0;

		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
//			stmt.executeQuery(sql);
			System.out.println("result : 행(레코드) 개수 " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public synchronized int update(MemberDto dto) {
		// 해당 레코드 존재 여부 검사 select

//		if(dto.getMemberAddress() != null) {
//			
//		} else {
//			
//		}

		String sqlFormat = "UPDATE %s SET memberName = '%s' WHERE memberID = '%s'";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberName(), dto.getMemberId(),
				dto.getMemberAddress());
		int result = 0;

		try (Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public synchronized int delete(String memberId) {

		String sqlFomat = "DELETE FROM %s WHERE memberId = '%s'";
		String sql = String.format(sqlFomat, TABLE_NAME, memberId);
		int result = 0;

		try (Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
