package project;

import lombok.Data;

@Data
public class ReviewDto extends MovieInfoDto {

	private String nickname;
	private int movieNumber;
	private String movieName;
	private float startRating;
	private String review;
}
