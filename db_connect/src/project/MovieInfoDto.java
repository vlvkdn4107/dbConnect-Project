package project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieInfoDto {

	private int movieNumber;
	private String movieName;
	private String releasedDate;
	private long revenue; 
	private long audience;
	private int screen;
	private float starRating;
	
	
	
}
