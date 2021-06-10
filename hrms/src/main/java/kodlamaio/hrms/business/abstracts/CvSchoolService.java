package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSchool;

public interface CvSchoolService {
	
	DataResult<List<CvSchool>> getAll();
	Result add(CvSchool cvSchool);
	//DataResult<List<CvSchool>> getByJobSeekerIdOrderByGraduationYearDesc(int id);

}
