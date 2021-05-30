package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.abstracts.MailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.mailDemo.MailSendManager;

@Component
public class MailManagerAdapter implements MailService {

	@Override
	public Result sendMail(String mail) {
		MailSendManager mailSendManager = new MailSendManager();
		
		return mailSendManager.sendMail(mail);
	}

}
