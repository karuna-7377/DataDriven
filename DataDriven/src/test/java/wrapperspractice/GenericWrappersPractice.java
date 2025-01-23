package wrapperspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GenericWrappersPractice  implements  WrappersPractice{
	RemoteWebDriver driver;  /// class RemoteWebDriver 
	
	@Override
	public void invokeApp(String browser,String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver =new InternetExplorerDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println(browser+"Launched successfully.");	
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println(browser + " is not launched due to session not created error.");
		} catch (InvalidArgumentException e) {
			// TODO: handle exception
			System.err.println(browser + "is not launched because urlnot contains https/http.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(browser + "is not launched due to unknown error.");
		}		
	}
	@Override	
   public void enterById(String IdVal, String data) {
	   try {
		   driver.findElement(By.id(IdVal)).sendKeys(data);
		   System.out.println(data+"is entered in Id.."+IdVal);
		 
	   }catch (NoSuchElementException e) {
		   System.err.println(IdVal+"Element is not found .Please correct locator ");
	   }catch (ElementNotInteractableException e) {
		   System.err.println(IdVal+"Elenent is not interactable in the application. ");
	   }catch (StaleElementReferenceException e) {
		   System.err.println(IdVal+"Element is not Stale in the application.");
	   }catch (WebDriverException e) {
		   System.err.println(IdVal+"Element is not entering value because of unknown error.");
	   }   
   }
	@Override
	public void enterByName(String NameVal,String data) {
		try {
			driver.findElement(By.name(NameVal)).sendKeys(data);
			System.out.println(data+"Is the name entered.");
		}catch(NoSuchElementException e) {
			System.err.println(NameVal+"Element is not found.please correct locator.");
		}catch(ElementNotInteractableException e) {
			System.err.println(NameVal+"Element is not Interactable in the application.");
		}catch (StaleElementReferenceException e) {
			System.err.println(NameVal+"Element is not stale in the application.");
		}catch (WebDriverException e) {
			System.err.println(NameVal+"Element is not enetring value bacause of unknown error.");
		}
	}
@Override		
public void enterByXPath(String XPathVal, String data) {
	try {
		driver.findElement(By.xpath(XPathVal)).sendKeys(data);
		System.out.println(data+"Is entered in XPath.");
	}catch(NoSuchElementException e) {
		System.err.println(XPathVal+"Element is not found.Please enter correct locator.");
	}catch (ElementNotInteractableException e) {
		System.err.println(XPathVal+"Element is not Interactable in the application.");
	}catch (StaleElementReferenceException e) {
		System.err.println(XPathVal+"Element is not stale in the application .");
	}catch (WebDriverException e) {
		System.err.println(XPathVal+"Element is not entering value because of unknown error.");
	}
}
@Override	
public void ClickById(String IdVal) {
	try {
		driver.findElement(By.id(IdVal)).click();
		System.out.println("Element is Clickable with ID " +IdVal);
	}catch (NoSuchElementException e) {
		System.err.println(IdVal+"Element is not found.Please enter correct locator.");
	}catch (ElementClickInterceptedException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not click interactable in the application.");
	}catch ( ElementNotInteractableException e) {
		System.err.println(IdVal+"Element is not Interactable in the application.");
	}catch (StaleElementReferenceException e) {
		System.err.println(IdVal+"Element is not Stale in the application.");
	}catch ( WebDriverException e) {
		System.err.println(IdVal+"Element is not entering value because of unknown error.");
	}		
}
public void ClickByName(String NameVal) {
	try { 
		driver.findElement(By.name(NameVal)).click();
		System.out.println("Element is Clickable with name "+NameVal);
	}catch (NoSuchElementException e) {
		System.err.println(NameVal+"Element is not found in the application. Please use other locator. ");
	}catch(ElementClickInterceptedException e) {
		System.err.println(NameVal+"Element is not Click Interactable in the application.");
	}catch (ElementNotInteractableException e) {
		System.err.println(NameVal+"Element is not Interactable in the application.");
	}catch (StaleElementReferenceException e) {
		System.err.println(NameVal+"Element is not Stale in teh application.");
	}catch(WebDriverException e) {
		System.err.println(NameVal+"Element is not entering value because of unknown error.");
	}
}
@Override
public void ClickByXpath(String XPathVal) {
	// TODO Auto-generated method stub
	try {
		driver.findElement(By.xpath(XPathVal)).click();
		System.out.println("Element is Clickable with XPath.."+XPathVal);
	}catch (NoSuchElementException e) {
		System.err.println(XPathVal+"Element is not found in the application.PLease use coreect locator.");
	}catch (ElementClickInterceptedException e) {
		System.err.println(XPathVal+"Element is not click interactable in the application.");
	}catch (ElementNotInteractableException e) {
		System.err.println(XPathVal+"Element is not Interacyable in the application.");
	}catch (StaleElementReferenceException e) {
		System.err.println(XPathVal+"Element is  not Stale in the application.");
	}catch (WebDriverException e) {
		System.err.println(XPathVal+"Element is not entering value because of unknown error. ");
	}
	
}
@Override
public void ClickByCssselVal(String CssselVal) {
	// TODO Auto-generated method stub
	try {
		driver.findElement(By.xpath(CssselVal)).click();
		System.out.println("Element is clickable with XPath"+CssselVal);
	}catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(CssselVal + " Element is not found. Please correct locator.");
	} catch (ElementClickInterceptedException e) {
		// TODO: handle exception
		System.err.println(CssselVal + " Element is not click interactable in the application.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(CssselVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(CssselVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(CssselVal + " Element is not entering value beacuse of  unknown error.");
	}
	
}
@Override
public void SelectVisibleTextById(String IdVal, String data) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.id(IdVal))).selectByVisibleText(data);
//	WebElement selwebelement = driver.findElement(By.id(IdVal));
//	Select selmonth = new Select(selwebelement);
//	selmonth.selectByVisibleText(data);
		System.out.println("Element with" + IdVal + " is selected by VisibleText with "+data);

	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element Select by VisibleText is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectValueById(String IdVal, String data) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.id(IdVal))).selectByValue(data);
		System.out.println("Element with" + IdVal + " is selected using Value of "+data);

	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element Select by Value is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectindexById(String IdVal, int index) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.id(IdVal))).selectByIndex(index);
		System.out.println("Element with" + IdVal + " is selected with index of "+index);
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element Select by Index is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectVisibleTextByName(String NameVal, String data) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.id(NameVal))).selectByVisibleText(data);
		System.out.println("Element with" + NameVal + " is selected by VisibleText with "+data);
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element Select by VisibleText is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectValueByName(String NameVal, String data) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.name(NameVal))).selectByValue(data);
		System.out.println("Element with" + NameVal + " is selected using Value of "+data);
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element Select by Value is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectIndexByName(String NameVal, int index) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.name(NameVal))).selectByIndex(index);
		System.out.println("Element with" + NameVal + " is selected with index of "+index);

	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element Select by Index is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectVisibleTextByXPath(String XPathVal, String data) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.xpath(XPathVal))).selectByVisibleText(data);
		System.out.println("Element with" + XPathVal + " is selected by VisibleText with "+data);

	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element Select by VisibleText is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element is not entering value beacuse of  unknown error.");
	}
}

	

@Override
public void SelectValueByXPath(String XPathval, String data) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.xpath(XPathval))).selectByValue(data);
		System.out.println("Element with" + XPathval + " is selected using Value of "+data);
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(XPathval + " Element Select by Value is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(XPathval + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(XPathval + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(XPathval + " Element is not entering value beacuse of  unknown error.");
	}
}
	

@Override
public void SelectIndexByXPath(String XPathVal, int index) {
	// TODO Auto-generated method stub
	try {
		new Select(driver.findElement(By.xpath(XPathVal))).selectByIndex(index);
		System.out.println("Element with" + XPathVal + " is selected with index of "+index);
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element Select by Index is not found. Please correct locator.");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element is not interactable in the application.");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element is not stale in the application.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println(XPathVal + " Element is not entering value beacuse of  unknown error.");
	}
}
	

@Override
public void WaitDriver(Long time) {
	// TODO Auto-generated method stub
	try {
		Thread.sleep(time);
		///driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time)));
		System.out.println("Driver wait is performing with .." + time);	
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("Something went wrong while waitngdriver.");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println("Thread is intreptted.");
	
	}
}

@Override
public void CloseDriver() {
	// TODO Auto-generated method stub
	try {
		driver.quit();
		System.out.println("Driver Quit Succefully.");
	} catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("Unknow error while quit driver.");
	}
	
}

}
