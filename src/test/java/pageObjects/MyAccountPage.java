package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
  @FindBy(xpath="//h2[normalize-space()='My Account']")
  WebElement msgHeading;
  
  @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
  WebElement lnkLogout;
  
  public boolean isMyAccountPageExists() {
	  try{
		  return(msgHeading.isDisplayed());
	  }catch(Exception e) {
		  return false;
	  }
  }
  
  public void clickLogout() {
	  //lnkLogout.click();
	  js.executeScript("arguments[0].click()", lnkLogout);
  }
  
  
  
  
}
