package wrappers;

import java.time.Duration;

import org.testng.annotations.Test;

public class MainTest extends GenericWrappers{

	@Test
	public void Test() throws InterruptedException {
		// TODO Auto-generated method stub
		
		invokeApp("chrome", "https://www.facebook.com/reg");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		enterByName("firstname", "Ripal"); // Enter FirstName using name
		enterByName("lastname","Patel");// Enter lastName using name
		enterByName("reg_email__", "ripalpatel2594@gmail.com"); //Enter Email ID.
		enterByName("reg_email_confirmation__", "ripalpatel2594@gmail");
		//enterByName("reg_email__", "9924202662"); //Enter Mobile.
		enterByName("reg_passwd__", "Ripal0908");// Enter Password
		selectIndexById("month", 3);// select month
		selectValueById("day", "25");// select day
		selectVisibleTextById("year", "1994");//select year
		clickByXPath("//label[text()='Female']");//click Gender
		waitDriver(5000);// wait for 5sec.
		closeDriver();//closing browser.
	
	}

}
