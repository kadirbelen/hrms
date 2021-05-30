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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//genel iş poziyonu
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	//Şehir bilgisi
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	//şirket 
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="create_date")
	private Date createDate;
	
}
