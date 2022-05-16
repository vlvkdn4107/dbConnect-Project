package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDao implements IReview{


	private DBClient client;
	private Connection connection;
	private ResultSet rs = null;
//	Review review;
	
	private ArrayList<ReviewDto> reviewInfo;
	
	public ReviewDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}
	
	@Override
	public ArrayList<ReviewDto> selectAll(){
		
		reviewInfo = new ArrayList<ReviewDto>();
		
		//MovieInfo info = new MovieInfo();
		
		try {
			String query = "select * from reviewTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ReviewDto dto = new ReviewDto();
				
				String nickname = rs.getString("nickname");
				int movieNumber = rs.getInt("movieNumber");
				String movieName = rs.getString("movieName");
				float starRating = rs.getFloat("starRating");
				String review = rs.getString("review");
				
				dto.setNickname(nickname);
				dto.setMovieNumber(movieNumber);
				dto.setMovieName(movieName);
				dto.setStarRating(starRating);
				dto.setReview(review);
				
				reviewInfo.add(dto);
				
//				reviewInfo.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
//						rs.getString("releasedDate"), rs.getLong("audience"), rs.getFloat("starRating"),
//						rs.getString("review")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reviewInfo;
	}

	@Override
	public ArrayList<ReviewDto> sendData(ReviewDto dto, String movieName) {
		//insert into reviewtbl values(1, '홍원일', 1, '명량', '2014-07-30', 17613682, 9.79, '노잼');
//		ArrayList<ReviewDto> dto = new ArrayList<ReviewDto>();
		try {
			// ? 여기 이상함
			String query = "insert into reviewtbl(nickName, movieNumber, movieName, starRating, review) values(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			Review review1 = new Review();
			ReviewList list = new ReviewList();
			
			
//			Object movieNumber = review1.findMovie(movieName);
//			
//			preparedStatement.setString(1, review1.getNickNameField().getText() + "");
//			preparedStatement.setObject(2, movieNumber);
//			preparedStatement.setString(3, movieName);
//			preparedStatement.setString(4, review1.getStarRatingField().getText() +"");
//			preparedStatement.setString(5, review1.getTextArea().getText() + "");
			
			
			preparedStatement.executeUpdate();

			reviewInfo.add(dto);
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviewInfo;
	}
	
	
	
	
}