package Appium;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
//@Listeners({ ScreenshotUtility.class })
public class Calculator {
  static AndroidDriver driver;
  String destDir;
  DateFormat dateFormat;
  @BeforeClass
  @Parameters("myURL1")
  public void setUp(String myURL1)throws InterruptedException, IOException {
	  System.out.println("Do this stuff");
		executeBat1();
		try 
		{ 
			Thread.currentThread().sleep(20000); 
		}
		catch ( Exception e ) { }
		System.out.println("Now do everything after this");

	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  capabilities.setCapability(CapabilityType.BROWSER_NAME,"Android");
	  capabilities.setCapability(CapabilityType.VERSION,"6.0.1");
	  capabilities.setCapability("deviceName","38140065");
	  capabilities.setCapability("platformName","Android");
	  capabilities.setCapability("appPackage", "com.miui.calculator"); // This is package name of your app (you can get it from apk info app)
      capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity"); // This is Launcher activity of your app (you can get it from apk info app)
      Thread.sleep(5000);
      driver = new AndroidDriver(new URL(myURL1), capabilities);	
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }
  @Test
  public void testCal1() throws InterruptedException{
    //locate the Text on the calculator by using By.name()
    WebElement two=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.miui.calculator:id/btn_2']"));
    two.click();
    WebElement plus=driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.miui.calculator:id/btn_plus']"));
    plus.click();
    WebElement four=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.miui.calculator:id/btn_4']"));
    four.click();
    WebElement equalTo=driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[810,1720][1080,1920]']"));
    equalTo.click();
    System.out.println("Click successful");
    //locate the edit box of the calculator by using By.tagName()
    Thread.sleep(2000);
    WebElement results=driver.findElement(By.xpath("//android.widget.TextView[@bounds='[912,665][1002,873]']"));
           //Check the calculated value on the edit box
    System.out.println(results.getText());
           assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
           takeScreenShot();
           driver.closeApp();
 }


@AfterClass
public void teardown(){
    //close the app
    driver.quit();
} 

public void takeScreenShot() {
	  // Set folder name to store screenshots.
	  destDir = "screenshots";
	  // Capture screenshot.
	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  // Set date format to set It as screenshot file name.
	  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	  // Create folder under project with name "screenshots" provided to destDir.
	  new File(destDir).mkdirs();
	  // Set file name using current date time.
	  String destFile = dateFormat.format(new Date()) + ".png";

	  try {
	   // Copy paste file at destination folder location
	   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }

public static void executeBat1() throws IOException 
{ 
	String cmd1="cmd /c \"cd C:\\Program Files\\Appium\\node_modules && start C:samplenote1.bat\"";
	Runtime r1=Runtime.getRuntime(); 
	Process pr1=r1.exec(cmd1); 
} 
}