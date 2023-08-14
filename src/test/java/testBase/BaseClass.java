package testBase;
import java.util.*;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.*;
public class BaseClass {
	
 public static WebDriver driver;
 public Logger logger;   //import from import org.apache.logging.log4j.Logger;
 public ResourceBundle rb;
 
 
	@BeforeClass(groups= {"Sanity","Regression"})
	@Parameters("browser")
	public void setup(String browser) {
	//rb= ResourceBundle.getBundle("config.properties");
	rb= ResourceBundle.getBundle("config");   //loads the config files
	
	logger=LogManager.getLogger(this.getClass()); //this.getClass() returns manam ye test class ni run chesthunnmo
	//a test class ni return chesthundhi. a class yokka logs ni getLogger() method generate chesthundi. Here 
	//Here LogManager is a predefined class and getLogger()is an static method.
 		
	//General ga testcase run chesinapudu chrome is bening automated ani oka message kanipisthundi. Ala
	//a message rakunda vuntadam kosam kindha two lines rasamu.
	   //ChromeOptions options=new ChromeOptions();
	  // options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	
	   if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	   }else if(browser.equalsIgnoreCase("edge")) {
		   driver=new EdgeDriver();
	   }else {
		   driver=new FirefoxDriver();
	   }
	   driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/index.php?route=common/home&language=en-gb");
		driver.get(rb.getString("appURL"));
		//driver.manage().window().maximize();
		
	
	}
	
	
	@AfterClass(groups= {"Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	//to generate emails randomly
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(6, 11);
		return generatedString;
	}
	
	//to generate phone numbers randomly
	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	
	public String captureScreen(String tname) {
		//SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");  //java.text package
		//Date date=new Date();      //java.util pacakage
		//String timestamp=df.format(date);
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshot=ts.getScreenshotAs(OutputType.FILE);
		String tagetLocation= System.getProperty("user.dir")+ "\\screenshots\\" + tname+ "_" + timestamp+ ".png";
		try {
			FileUtils.copyFile(screenshot, new File(tagetLocation));
		}catch(Exception e) {
			e.getMessage();
		}
		return tagetLocation;
	}
}
