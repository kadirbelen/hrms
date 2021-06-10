package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	
    List<JobAdvertisement> findByIsActiveTrue(); //aktif iş ilanları
	
	List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate(); // aktif iş ilanlarının tarihe göre sıralanması
	
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int employerId); // şirkete ait aktif iş ilanları

	JobAdvertisement findByIdAndEmployer_Id(int id , int employerId);//bir işi aktif pasiflini değiştirme
	
	List<JobAdvertisement> findAllByJobTitle_Id(int id);
	
	List<JobAdvertisement> findAllByCity_Id(int id);
	
	
	
	//List<JobAdvertisementDao> getJobAdvertisementDetails();
	
}
