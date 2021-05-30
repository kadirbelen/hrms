package kodlamaio.hrms.mernisDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMernisDemo {

	public boolean isRealPerson(String nationalIdentity) {
		
		 String regex = "^[0-9]+$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(nationalIdentity);
	     
		if(nationalIdentity.length() == 11 && matcher.matches()) {
			return true;
		}
		
		return false;
		
	}
}
