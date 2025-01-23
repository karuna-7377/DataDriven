package irctctestcase;

import org.testng.annotations.Test;

import utils.DP001;
import wrappers.GenericWrappers;

public class irctctestcase extends GenericWrappers{
	
	@Test(dataProvider = "irctcreg", dataProviderClass = DP001.class)
	public void fbregistration(String username, String password, String preferredlanguage) {

		invokeApp("chrome", "https://www.irctc.co.in/nget/profile/user-registration");
		waitDriver(3000);
		enterById("userName", username);
		enterById("usrPwd", password);
		enterById("cnfUsrPwd", password);
		//selectVisibleTextByXPath("//li[@aria-label='English']",preferredlanguage);//, preferredlanguage);
		waitDriver(3000);
		closeDriver();
	}
	

}
