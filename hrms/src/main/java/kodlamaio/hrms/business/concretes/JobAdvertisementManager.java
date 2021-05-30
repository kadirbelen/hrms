package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.var;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedActiveByDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByCreateDate(),"Aktif iş ilanları tarihe göre sıralandı");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),"Aktif iş ilanları listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllIsActiveTrueAndEmployer(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_Id(employerId),"Firmaya ait aktif iş ilanları listelendi");
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		if(!checkEmployerIsNull(jobAdvertisement).isSuccess()) {
			return checkEmployerIsNull(jobAdvertisement);
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı eklendi");
		
	}

	
	 public Result checkEmployerIsNull(JobAdvertisement jobAdvertisement) {
	        if(jobAdvertisement.getCity()==null || jobAdvertisement.getDescription()==null|| jobAdvertisement.getCreateDate()==null
	                || jobAdvertisement.getEmployer()==null || jobAdvertisement.getJobTitle()==null || jobAdvertisement.getNumberOfOpenPositions() == 0
	                || jobAdvertisement.getApplicationDeadline()==null) {
	            return new ErrorResult("Lütfen boş alan bırakmayınız");
	        }
	        return new SuccessResult();
	        }

	@Override
	public Result chengeStatus(int jobAdvertisementId, int employerId) {
		
		 var result = jobAdvertisementDao.findByIdAndEmployer_Id(jobAdvertisementId, employerId);
		 
		 if(!result.isActive()) {
			 return new ErrorResult("Böyle bir iş ilanı bulunamadı veya bu iş ilanı zaten pasif");
		 }
		 
		 result.setActive(!result.isActive());
			
		 jobAdvertisementDao.save(result) ;
			
		String message = result.isActive() ? "İş ilanı aktif." : "İş ilanı pasif.";
			
		return new SuccessResult(message);
		
	}
	
}
