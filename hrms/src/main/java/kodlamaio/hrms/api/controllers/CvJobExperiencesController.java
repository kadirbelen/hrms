package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvJobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvJobExperience;


@RestController
@RequestMapping("/api/jobExperiences")
public class CvJobExperiencesController {

	private CvJobExperienceService cvJobExperienceService;

	@Autowired
	public CvJobExperiencesController(CvJobExperienceService cvJobExperienceService) {
		super();
		this.cvJobExperienceService = cvJobExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvJobExperience>> getAll(){
		
		return this.cvJobExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvJobExperience cvJobExperience) {
		return this.cvJobExperienceService.add(cvJobExperience);
	}
}
