package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_schools")
@Entity
public class CvSchool {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Column(name="year_of_entry")
	private Date yearOfEntry;
	

	@Column(name="graduation_year")
	private Date graduationYear;
	
	//private int job_seeker_id
	@ManyToOne()

	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
}
