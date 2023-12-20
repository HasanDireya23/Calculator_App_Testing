package appiuam;

import java.io.File;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCases {
	
	
	DesiredCapabilities caps = new DesiredCapabilities();
	
	AndroidDriver driver ;

	@BeforeTest
	public void BeforeTesting() {
		
		
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "PSUT");

				
			
				  
				 
				// for mobile application we use the below two lines
				File myApplicationCalculator = new File("src/MyApplication/calculator.apk");
				caps.setCapability(MobileCapabilityType.APP, myApplicationCalculator.getAbsolutePath());

	}
	
	

	@Test(priority = 1)
	public void ClickOnAllDigits() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		List<WebElement> allButtons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allButtons.size(); i++) {

			if (allButtons.get(i).getAttribute("resource-id").contains("digit")) {
				allButtons.get(i).click();
			} else {
				continue;
			}
		}

	
	}
	
	@Test(priority = 2)
	public void clickonevenNumbers() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		List<WebElement> allButtons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allButtons.size(); i++) {


			if (allButtons.get(i).getAttribute("resource-id").contains("digit")) {

				int number = Integer.parseInt(allButtons.get(i).getAttribute("content-desc"));

				if (number % 2 == 0) {
					System.out.println(number);
					allButtons.get(i).click(); 
				}
			}

		}

	}
	
	@Test(priority = 3)
	public void clickonoddNumbers() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		List<WebElement> allButtons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allButtons.size(); i++) {


			if (allButtons.get(i).getAttribute("resource-id").contains("digit")) {

				int number = Integer.parseInt(allButtons.get(i).getAttribute("content-desc"));

				if (number % 2 == 1) {
					System.out.println(number);
					allButtons.get(i).click(); 
				}
			}

		}

	}
	
}

