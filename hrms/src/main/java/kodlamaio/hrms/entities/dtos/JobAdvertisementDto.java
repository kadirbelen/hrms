package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private String employerName;
	private String jobTitle;
	private int numberOfOpenPositions;
	private Date createDate;
	private Date applicationDeadline;
}
