package kodlamaio.hrms.entities.concretes;





import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvSchools"})
public class JobSeeker extends User{

	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<CvSchool> cvSchools; 
	

	@OneToMany(mappedBy = "jobSeeker")
	private List<CvJobExperience> cvJobExperiences; 
	
	
	
	

}
