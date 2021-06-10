package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer>{

	//List<CvSchool> getByJobSeekerIdOrderByGraduationYearDesc(int id);
}
