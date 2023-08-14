package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(name="firstname")
	WebElement textFirstname;
	
	@FindBy(name="lastname")
	WebElement textLastname;
	
	@FindBy(name="email")
	WebElement textEmail;
	
	@FindBy(name="password")
	WebElement textPassword;

	@FindBy(name="agree")
	WebElement btnPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	//@FindBy(css="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfrimation;
	
	public void setFirstname(String firstName) {
		textFirstname.sendKeys(firstName);
	}
	
	public void setLasttname(String lasttName) {
		textLastname.sendKeys(lasttName);
	}
	
	public void setEmail(String email) {
		textEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		textPassword.sendKeys(password);
	}
	
	
	public void clickPolicy() {
		//btnPolicy.click();
		js.executeScript("arguments[0].click()", btnPolicy);
	}
	
	public void clickContinue() {
	//btnContinue.click();
		js.executeScript("arguments[0].click()", btnContinue);
	}
	
	public String getConfirmationMsg() {
		
		try {
		return(msgConfrimation.getText());
		
		}catch(Exception e){
			 return e.getMessage();
		}
	}
	
}
