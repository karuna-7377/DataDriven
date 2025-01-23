package fbtestcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.DP001;
import wrappers.GenericWrappers;

public class fbregtestcase extends GenericWrappers {

	@Test(dataProvider = "fbreg", dataProviderClass = DP001.class)
	public void fbregistration(String firstname, String lastname, String emailid, String password, String birthmonth,
			String birthyear, String birthday, String gender) {

		invokeApp("chrome", "https://www.facebook.com/");
		clickByXPath("//a[text()='Create new account']");
		waitDriver(3000);
		enterByName("firstname", firstname);
		enterByName("lastname", lastname);
		enterByName("reg_email__", emailid);
		enterByName("reg_passwd__", password);
		selectVisibleTextById("month", birthmonth);
		selectVisibleTextById("day", birthday);
		selectVisibleTextById("year", birthyear);
		
		if (gender.equalsIgnoreCase("Female")) {
			clickByXPath("//label[text()='Female']");// click Gender
		} else if (gender.equalsIgnoreCase("Male")) {
			clickByXPath("//label[text()='Male']");
		}
		waitDriver(3000);
		closeDriver();
	}

}
