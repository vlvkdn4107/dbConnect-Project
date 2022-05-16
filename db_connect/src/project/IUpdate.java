package project;

import java.util.ArrayList;

public interface IUpdate {

	ArrayList<MovieInfoDto> updateData(int movieNumber, String movieName, String releasedDate, long revenue, long audience, int screen, float starRating,  String updateMovieName);
	
}
