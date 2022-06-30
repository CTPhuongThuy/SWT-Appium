
package src.src;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleTest {

	static WebDriver driver = null;
  @BeforeMethod
public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S10"); // change your device
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("platformVersion", "10.0.0");// change your version
    desiredCapabilities.setCapability("appPackage", "com.example.a10h10");
    desiredCapabilities.setCapability("appActivity", "com.example.a10h10.MainActivity");
    desiredCapabilities.setCapability("udid", "192.168.116.104:5555"); // change your device id

    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
  }

  @Test
  public void sampleTest() {
	WebElement el1 = (WebElement) driver.findElement(By.id("com.example.a10h10:id/num1"));
    el1.sendKeys("5");
    WebElement el2 = (WebElement) driver.findElement(By.id("com.example.a10h10:id/num2"));
    el2.sendKeys("5");
    WebElement el3 = (WebElement) driver.findElement(By.id("com.example.a10h10:id/sum"));
    el3.click();
    WebElement result= driver.findElement(By.id("com.example.a10h10:id/result"));
    
    AssertJUnit.assertEquals("10", result.getText());
  }

  @AfterMethod
public void tearDown() {
    driver.quit();
  }
}