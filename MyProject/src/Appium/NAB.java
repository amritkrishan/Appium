package Appium;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
//import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
	
	public class NAB {
	  String destDir;
	  DateFormat dateFormat;
	  org.openqa.selenium.Dimension size;
	  AndroidDriver driver;
	  @BeforeClass
	  @Parameters("myURL2")
	  public void setUp(String myURL2)throws InterruptedException, IOException {
		  System.out.println("Do this stuff");
			executeBat2();
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
		  capabilities.setCapability("appPackage", "au.com.nab.mobile"); // This is package name of your app (you can get it from apk info app)
	      //capabilities.setCapability("appActivity", "au.com.nab.mobile.common.activity.initialization.WelcomeDispatchActivity_"); // This is Launcher activity of your app (you can get it from apk info app)
	      capabilities.setCapability("appActivity", "au.com.nab.mobile.activity.LauncherActivity"); // This is Launcher activity of your app (you can get it from apk info app)
	      Thread.sleep(5000);
	      driver = new AndroidDriver(new URL(myURL2), capabilities);	
	      driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  }
	  @Test
	  public void testCal2() throws InterruptedException{
		  //driver.launchApp();
		  driver.findElement(By .xpath("//android.widget.RelativeLayout[@bounds='[360,1740][720,1920]']")).click();
		  System.out.println("Clicked $");
		  Thread.sleep(5000);
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		  int startx = (int) (size.width * 0.90);
		  int endx = (int) (size.width * 0.05);
		  int starty = 1500;
		  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
		  //Thread.sleep(2000);
		  driver.swipe(startx, starty, endx, starty, 5000);
		  WebElement webElement=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/btn_welcome_login']"));
		  TouchAction action = new TouchAction(driver);
		  action.longPress(webElement).release().perform();
		  Thread.sleep(3000);
		  driver.pressKeyCode(AndroidKeyCode.BACK);
		  driver.pressKeyCode(AndroidKeyCode.BACK);		 
		  /*WebElement headerNab=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/nab_header_title']"));
		  assert headerNab.getText().equals("NAB Internet Banking");
		  System.out.println("Header present");
		  WebElement rememberNabId=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/reg_nab_or_enter_nab_id_password_remember_nab_id']"));
		  assert rememberNabId.getAttribute("checked").equals("true");
		  System.out.println("Remember NAB Id checked");
		  WebElement Flik=driver.findElement(By .xpath("//*[@content-desc='NAB Flik button. Item 2 of 11']"));
		  Flik.click();
		  System.out.println("Clicked on Flik button");
		  WebElement headerFlik=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/nab_header_title']"));
		  WebElement Callus=driver.findElement(By .xpath("//*[@content-desc='Call us button. Item 4 of 11']"));
		  assert headerFlik.getText().equals("NAB Flik");
		  System.out.println("Header present");
		  Thread.sleep(2000);
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		  int startx = (int) (size.width * 0.70);
		  int endx = (int) (size.width * 0.20);
		  int starty = 1608;
		  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
		  //Thread.sleep(2000);
		  driver.swipe(startx, starty, endx, starty, 3000);
		  Thread.sleep(2000);
		  System.out.println(Callus.isDisplayed());
		  driver.swipe(endx, starty, startx, starty, 3000);
		  WebElement NabFlikId=driver.findElement(By .xpath("//*[@content-desc='NAB ID']"));
		  String selector=Callus.getText();
		  String selectorString = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ selector +")");
		  driver.findElement(MobileBy.AndroidUIAutomator(selectorString));
		  scrollTo(selector);
		  selector=NabFlikId.getText();
		  scrollTo(selector);
		  NabFlikId.click();
		  NabFlikId.sendKeys("12037447");
		  WebElement NabFlikPassword=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/reg_nab_or_enter_nab_id_password_password_edittext']"));
		  NabFlikPassword.sendKeys("aaa111");
		  WebElement LoginFlikButton=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/button_login']"));
		  LoginFlikButton.click();
		  WebElement NabFlikLoginError=driver.findElement(By .xpath("//*[@resource-id='au.com.nab.mobile:id/inline_error_text_id']"));
		  System.out.println(NabFlikLoginError.getText());
		  driver.hideKeyboard();*/
		  Thread.sleep(10000);
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
	  public static void executeBat2() throws IOException 
	  { 
	  	String cmd="cmd /c \"cd C:\\Program Files\\Appium\\node_modules && start C:samplenote2.bat\"";
	  	Runtime r=Runtime.getRuntime(); 
	  	Process pr=r.exec(cmd); 
	  } 
	  /*public void scrollTo(String selector) {
		    String selectorString = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ selector +")");

		 driver.findElement(MobileBy.AndroidUIAutomator(selectorString));
		}
	  public void swipe()
	    {  
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    HashMap<String, Double> swipeObject = new HashMap<String, Double>();
	    swipeObject.put("startX", 0.95);
	    swipeObject.put("startY", 0.5);
	    swipeObject.put("endX", 0.05);
	    swipeObject.put("endY", 0.5);
	    swipeObject.put("duration", 1.8);
	    js.executeScript("mobile: swipe", swipeObject);
	     }*/
}
