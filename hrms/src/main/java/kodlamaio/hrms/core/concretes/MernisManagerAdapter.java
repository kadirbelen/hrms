package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.mernisDemo.CheckMernisDemo;

@Component
public class MernisManagerAdapter implements MernisService {

	@Override
	public boolean checkMernis(String nationalIdentity) {
		CheckMernisDemo checkMernisDemo = new CheckMernisDemo();
		
		return checkMernisDemo.isRealPerson(nationalIdentity);
	}

}
