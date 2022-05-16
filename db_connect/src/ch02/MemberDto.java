package ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {

	@NonNull
	private String memberId;
	private String memberName;
	private String memberAddress;

}
