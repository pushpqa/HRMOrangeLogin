package DemoCucumber.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.PFHRMLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTest {
	 WebDriver driver;
	 PFHRMLoginPage loginPF;
	 
	@BeforeTest
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123a");
//		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 1)
	public void login() {
	   loginPF = new PFHRMLoginPage(driver);
		//driver = new ChromeDriver();
		loginPF.enter_username("Admin");
		loginPF.enter_password("admin123");
		loginPF.Click_loginBtn();
	}
	

}
