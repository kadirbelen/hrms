package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllSortedActiveByDate")
	public DataResult<List<JobAdvertisement>> getAllSortedActiveByDate(){
		
		return this.jobAdvertisementService.getAllSortedActiveByDate();
	}
	
	@GetMapping("/getAllIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getAllIsActiveTrue(){
		return this.jobAdvertisementService.getAllIsActiveTrue();
	}
	
	@GetMapping("/getAllIsActiveTrueAndEmployer")
	public DataResult<List<JobAdvertisement>> getAllIsActiveTrueAndEmployer(@RequestParam int employerId){
		return this.jobAdvertisementService.getAllIsActiveTrueAndEmployer(employerId);
	}
	
	@GetMapping("/findAllByJobTitleId")
	public DataResult<List<JobAdvertisement>> findAllByJobTitle_Id(@RequestParam int id){
		return this.jobAdvertisementService.findAllByJobTitle_Id(id);
	}
	
	@GetMapping("/findAllByCityId")
	public DataResult<List<JobAdvertisement>> findAllByCity_Id(@RequestParam int id){
		
		return this.jobAdvertisementService.findAllByCity_Id(id);
	}
	@PutMapping("/changeStatus")
	public Result chengeStatus(int jobAdvertisementId, int employerId) {
		
		return this.jobAdvertisementService.chengeStatus(jobAdvertisementId, employerId);
	}
}
