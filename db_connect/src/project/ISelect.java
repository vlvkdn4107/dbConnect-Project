package project;

import java.util.ArrayList;


public interface ISelect {

	//모든 영화 리스트 출력
	ArrayList<MovieInfoDto> selectAll();
	// 영화에대한 정보리스트 출력 OK

	
	// 영화제목으로 출력
	ArrayList<MovieInfoDto> selectByMovieName(String movieName);
	
	// 개봉일로 출력
	ArrayList<MovieInfoDto> selectByReleasedYear(String releasedYear);
}
