package kodlamaio.hrms.core.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface MernisService {
	
	boolean checkMernis(String nationalIdentity);

}
