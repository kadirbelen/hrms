package kodlamaio.hrms.core.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;

@Service
public interface MailService {

	 Result sendMail(String mail);
}
