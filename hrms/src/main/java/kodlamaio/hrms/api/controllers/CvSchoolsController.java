package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("/api/cvSchools")
public class CvSchoolsController {
	
	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolsController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvSchool>> getAll(){
		
		return this.cvSchoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSchool cvSchool) {
		return cvSchoolService.add(cvSchool);
	}
	
//	@PostMapping("/graduationYearDesc")
//	public DataResult<List<CvSchool>> getByJobSeekerIdOrderByGraduationYearDesc(@RequestParam int id){
//		return this.cvSchoolService.getByJobSeekerIdOrderByGraduationYearDesc(id);
//	}

}
