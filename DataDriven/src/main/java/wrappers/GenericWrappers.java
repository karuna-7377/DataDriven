package wrappers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericWrappers implements wrappers {

	RemoteWebDriver driver;

	@Override
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.get(url);

			driver.manage().window().maximize();

			System.out.println(browser + "launched succesfully");

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
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(IdVal)).sendKeys(data);
			System.out.println(data + "is entered in ID >> "+ IdVal);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not found. Please correct locator.");
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
	public void enterByName(String NameVal, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(NameVal)).sendKeys(data);
			System.out.println(data + "is entered in Name  >> "+ NameVal);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not found. Please correct locator.");
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
	public void enterByXPath(String xpathVal, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathVal)).sendKeys(data);
			System.out.println(data + "is entered in XPath >> "+ xpathVal);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void clickById(String IdVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(IdVal)).click();
			System.out.println("Element is clicakble with ID >> "+ IdVal);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not found. Please correct locator.");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not click interactable in the application.");
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
	public void clickByName(String NameVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(NameVal)).click();
			System.out.println("Element is clicakble with Name >> "+ NameVal);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not found. Please correct locator.");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not click interactable in the application.");
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
	public void clickByXPath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("Element is clicakble with XPath >> "+ xpathVal);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not found. Please correct locator.");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not click interactable in the application.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}
	
	@Override
	public void clickByCssselVal(String cssselVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(cssselVal)).click();
			System.out.println("Element is clicakble with XPath >> "+ cssselVal);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not found. Please correct locator.");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not click interactable in the application.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectVisibleTextById(String IdVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.id(IdVal))).selectByVisibleText(data);
//		WebElement selwebelement = driver.findElement(By.id(IdVal));
//		Select selmonth = new Select(selwebelement);
//		selmonth.selectByVisibleText(data);
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
	public void selectValueById(String IdVal, String data) {
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
	public void selectIndexById(String IdVal, int index) {
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
	public void selectVisibleTextByName(String NameVal, String data) {
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
	public void selectValueByName(String NameVal, String data) {
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
	public void selectIndexByName(String NameVal, int index) {
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
	public void selectVisibleTextByXPath(String xpathVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.xpath(xpathVal))).selectByVisibleText(data);
			System.out.println("Element with" + xpathVal + " is selected by VisibleText with "+data);

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element Select by VisibleText is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectValueByXPath(String xpathVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.xpath(xpathVal))).selectByValue(data);
			System.out.println("Element with" + xpathVal + " is selected using Value of "+data);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element Select by Value is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectIndexByXPath(String xpathVal, int index) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.xpath(xpathVal))).selectByIndex(index);
			System.out.println("Element with" + xpathVal + " is selected with index of "+index);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element Select by Index is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void waitDriver(long time) {
		// TODO Auto-generated method stub

		try {
			 Thread.sleep(time);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
			System.out.println("Diver Wait is performing with "+ time);
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Something went wrong while waitngdriver.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Thread is intreptted.");

		}
	}

	@Override
	public void closeDriver() {
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