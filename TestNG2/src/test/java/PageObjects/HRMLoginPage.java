package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRMLoginPage {
public static WebDriver driver;

WebElement user_name = driver.findElement(By.xpath("//input[@placeholder='Username']"));
WebElement user_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
WebElement login_btn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

public HRMLoginPage(WebDriver driver) {
	this.driver = driver;
}

public void enter_username() {
//	driver.findElement(user_name).sendKeys("Admin");
	user_name.sendKeys("Admin");
}

public void enter_password() {
	user_password.sendKeys("admin123");
}

public void click_loginBtn() {
	login_btn.click();
	
}



}
