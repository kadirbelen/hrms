package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter, Integer> {

}
