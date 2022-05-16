package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Data;

@Data
public class MovieInfoDao implements ISelect, ICreate, IDelete, IUpdate{

	
	private DBClient client;
	private Connection connection;
	private ResultSet rs = null;
	
	private ArrayList<MovieInfoDto> movieInfo;
	
//	private MovieInfo info = new MovieInfo();
	
	public MovieInfoDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}
	
	
	public ArrayList<MovieInfoDto> selectAll(){
		
		 movieInfo = new ArrayList<MovieInfoDto>();
		
		 ArrayList<MovieInfoDto> dtoAll = new ArrayList<MovieInfoDto>();
		 
		try {
			String query = "select * from movieTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			
			while(rs.next()) {
				
				MovieInfoDto dto = new MovieInfoDto();
				
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setScreen(rs.getInt("screen"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				dtoAll.add(dto);
				
				
//				movieInfo.add(dto);
				
//				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
//						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
//						rs.getInt("screen"), rs.getFloat("starRating")});
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtoAll;
		
	}
	
	
	@Override
	public ArrayList<MovieInfoDto> selectByMovieName(String movieName) {
		
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "SELECT * FROM movietbl\r\n"
					+ "WHERE movieName LIKE ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			String name = '%' + movieName + '%';
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();
			
			
			while(rs.next()){
				MovieInfoDto dto = new MovieInfoDto();
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setScreen(rs.getInt("screen"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				dtoAll.add(dto);
				
				
//				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
//						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
//						rs.getInt("screen"), rs.getFloat("starRating")});
//				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtoAll;
		
	}
	
	
	
	@Override
	public ArrayList<MovieInfoDto> selectByReleasedYear(String releasedYear) {
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "SELECT * FROM movietbl\r\n"
					+ "WHERE releasedDate LIKE ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			String year = '%' + releasedYear + '%';
			preparedStatement.setString(1, year);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				MovieInfoDto dto = new MovieInfoDto();
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setScreen(rs.getInt("screen"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				dtoAll.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtoAll;
		
	}


	@Override
	public ArrayList<MovieInfoDto> insertData(MovieInfoDto dto) {
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<>();
//		MovieInfoDto dto = new MovieInfoDto();
		
		String query = "INSERT INTO movietbl VALUES(?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
//			System.out.println(result);
			
			preparedStatement.setInt(1,dto.getMovieNumber());
			preparedStatement.setString(2, dto.getMovieName());
			preparedStatement.setString(3, dto.getReleasedDate());
			preparedStatement.setLong(4, dto.getRevenue());
			preparedStatement.setLong(5, dto.getAudience());
			preparedStatement.setLong(6, dto.getScreen());
			preparedStatement.setFloat(7, dto.getStarRating());

			preparedStatement.executeUpdate();

//			dto.setMovieNumber(rs.getInt("movieNumber"));
//			dto.setMovieName(rs.getString("movieName"));
//			dto.setReleasedDate(rs.getString("releasedDate"));
//			dto.setRevenue(rs.getLong("revenue"));
//			dto.setAudience(rs.getLong("audience"));
//			dto.setScreen(rs.getInt("screen"));
//			dto.setStarRating(rs.getFloat("starRating"));
			
//			dtoAll.add(dto);
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dtoAll;
	}


	
	@Override
	public ArrayList<MovieInfoDto> updateData(int movieNumber, String movieName, String releasedDate, long revenue, long audience, int screen, float starRating, String updateMovieName) {
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<>();
//		MovieInfoDto dto = new MovieInfoDto();
		
		
		String query = "update movietbl set movieNumber = ?, movieName = ?, \r\n"
				+ "releasedDate = ?, revenue = ?, audience = ?, \r\n"
				+ "screen = ?, starRating = ? where movieName = ?;";
		
		try {
			PreparedStatement	preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, movieNumber);
			preparedStatement.setString(2, movieName);
			preparedStatement.setString(3, releasedDate);
			preparedStatement.setLong(4, revenue);
			preparedStatement.setLong(5, audience);
			preparedStatement.setLong(6, screen);
			preparedStatement.setFloat(7, starRating);
			preparedStatement.setString(8, updateMovieName);
			
			preparedStatement.executeUpdate();
			
//			dto.setMovieNumber(rs.getInt("movieNumber"));
//			dto.setMovieName(rs.getString("movieName"));
//			dto.setReleasedDate(rs.getString("releasedDate"));
//			dto.setRevenue(rs.getLong("revenue"));
//			dto.setAudience(rs.getLong("audience"));
//			dto.setScreen(rs.getInt("screen"));
//			dto.setStarRating(rs.getFloat("starRating"));
//			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	
	@Override
	public void deleteData(String movieName) {
		
		ArrayList<MovieInfoDto> dtoAll = new ArrayList<>();
//		MovieInfoDto dto = new MovieInfoDto();
		
		String query = "DELETE FROM movietbl where movieName = ?";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, movieName);

			preparedStatement.executeUpdate();

			
//			dto.setMovieNumber(rs.getInt("movieNumber"));
//			dto.setMovieName(rs.getString("movieName"));
//			dto.setReleasedDate(rs.getString("releasedDate"));
//			dto.setRevenue(rs.getLong("revenue"));
//			dto.setAudience(rs.getLong("audience"));
//			dto.setScreen(rs.getInt("screen"));
//			dto.setStarRating(rs.getFloat("starRating"));
			
//			dtoAll.add(dto);
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
	

	

	
	
}
