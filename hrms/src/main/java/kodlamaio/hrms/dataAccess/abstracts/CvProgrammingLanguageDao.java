package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvProgrammingLanguage;

public interface CvProgrammingLanguageDao extends JpaRepository<CvProgrammingLanguage, Integer>{

}
