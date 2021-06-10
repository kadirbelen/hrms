package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.MailService;
import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private MernisService mernisService;
	private MailService mailService;

	
   @Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisService mernisService,MailService mailService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisService=mernisService;
		this.mailService=mailService;
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(!jobSeekerIsNull(jobSeeker).isSuccess()) {
			return jobSeekerIsNull(jobSeeker);
		}
		else if(!isMailExist(jobSeeker).isSuccess()) {
			return isMailExist(jobSeeker);
		}
		else if(!isNIdentityExist(jobSeeker).isSuccess()) {
			return isNIdentityExist(jobSeeker);
		}
		else if(!mernisService.checkMernis(jobSeeker.getNationalIdentity())) {
			return new ErrorResult("Mernisde Doğrulanamadı");
		}
		
//		if(mailService.sendMail(jobSeeker.getMail()).isSuccess()) {
//			return mailService.sendMail(jobSeeker.getMail());
//		}
		
		
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kayıt başarıyla gerçekleşti");
	}
	
	private Result isMailExist(JobSeeker jobSeeker) {
		if(this.jobSeekerDao.findAllByMail(jobSeeker.getMail()).stream().count()>0) {
			return new ErrorResult("Bu mail zaten kayıtlı");
		}
		return new SuccessResult();
	}
	
	private Result isNIdentityExist(JobSeeker jobSeeker) {
		if(this.jobSeekerDao.findAllByNationalIdentity(jobSeeker.getNationalIdentity()).stream().count()>0) {
			return new ErrorResult("Bu kimlik numarası zaten kayıtlı");
		}
		return new SuccessResult();
	}
	
	public Result jobSeekerIsNull(JobSeeker jobSeeker){
		if(jobSeeker.getFirstName().equals(null) || jobSeeker.getFirstName().isBlank() ||
		   jobSeeker.getLastName().equals(null) || jobSeeker.getLastName().isBlank() ||
		   jobSeeker.getNationalIdentity().equals(null) || jobSeeker.getNationalIdentity().isBlank() ||
		   jobSeeker.getDateOfBirth().equals(null) ||
		   jobSeeker.getMail().equals(null) || jobSeeker.getMail().isBlank() ||
		   jobSeeker.getPassword().equals(null) || jobSeeker.getMail().isBlank()) {
			
			return new ErrorResult("Lütfen boş alan bırakmayınız");
		}
		return new SuccessResult();
	}

     

}
