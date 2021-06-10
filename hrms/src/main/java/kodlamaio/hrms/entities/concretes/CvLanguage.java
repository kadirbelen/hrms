package kodlamaio.hrms.entities.concretes;



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
@Entity
@Table(name="cv_languages")
public class CvLanguage {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name="language_name")
	private String languageName;
	
	@NotBlank
	@NotNull
	@Column(name="language_level")
	private char languageLevel;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
}
