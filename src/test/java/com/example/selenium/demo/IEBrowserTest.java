package com.example.selenium.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IEBrowserTest {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@Test
	public void testHtml() {
		String site = "http://localhost:8085/mygarageappdemo/";
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\JuanPaoloAndrada\\Desktop\\IEDriverServer.exe");
		InternetExplorerOptions options = new InternetExplorerOptions();  
        options.addCommandSwitches("test-type");
        options.addCommandSwitches("--disable-extensions");
		driver = new InternetExplorerDriver(options);
		wait = new WebDriverWait(driver, 20);
		
		driver.get(site);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("date")));
			
			String type = element.getAttribute("type");
			assertEquals("date", type);
			
			element = driver.findElement(By.name("time"));
			type = element.getAttribute("type");
			assertEquals("time", type);
			
		} catch (NoSuchElementException nse) {
			fail("element type does not exist!");
		} finally {
			driver.quit();
		}
		
	}
}
