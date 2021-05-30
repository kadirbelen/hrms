package kodlamaio.hrms.mailDemo;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class MailSendManager {
	
	
		public Result sendMail(String mail) {
			
			return new SuccessResult("Doğrulama maili gönderildi");
		}
	

}
