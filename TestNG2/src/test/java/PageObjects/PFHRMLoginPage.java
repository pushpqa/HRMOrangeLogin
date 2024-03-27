package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PFHRMLoginPage {
	
	WebDriver driver;
	public PFHRMLoginPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@placeholder='Username']") public WebElement user_name;
	@FindBy(xpath = "//input[@placeholder='Password']") public WebElement user_pswd;
	@FindBy(xpath = "//button[normalize-space()='Login']")public WebElement login_btn;
	
	public void enter_username(String username) {
		try {
			user_name.sendKeys(username);
		} catch (Exception e) {
			System.out.println("Exception caught"+ e.getMessage());
		}
		
	}

	public void enter_password(String password) {
		try {
			user_pswd.sendKeys(password);
			
		} catch (Exception e) {
			System.out.println("Exception Caughth"+ e.getMessage());
		}
		
	}
	
	public void Click_loginBtn() {
		try {
			user_name.click();
		} catch (Exception e) {
			System.out.println("Exception caught"+ e.getMessage());
		}
		user_name.click();
	}
}
