package DemoCucumber.TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_OrangeHRM {
	WebDriver driver;
	
	@BeforeTest
	public void loginPageVerification() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		if(actualTitle.equals(expectedTitle)){
		System.out.println("Test is passed");	
		}
		else {
			System.out.println("Test is failed");
		}
	}
	
	@Test(priority=1)
	public void logIn() {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String pageSource = driver.getPageSource();
		String ExpectedText = "Dashboard";
		Assert.assertTrue(pageSource.contains(ExpectedText), "Page title assertion failed");
	}
		
		@AfterTest
		public void closeBrowswe() {
		driver.close();	
	}
		
		@Test(priority=2)
		public void changePassword() throws InterruptedException {
			
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
//			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[normalize-space()='Change Password']")).click();
			
			String ForgetPWPageSource = driver.getPageSource();
			String ExpectedStringPW = "Update Password";
//			Assert.assertEquals(ForgetPWPageSource, ExpectedStringPW);
			
//			Assert.assertTrue(ForgetPWPageSource.contains(ExpectedStringPW), "Password Text is not visibile");
			
			driver.findElement(By.cssSelector("div[class='oxd-form-row'] div[class='oxd-grid-2 orangehrm-full-width-grid'] div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']")).sendKeys("admin123");
			driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("admin1234");
			driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys("admin1234");
			driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();		
			}
		
		@Test(priority=3)
		public void logOut() {
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			
			WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
			
			Assert.assertNotNull(logo, "Logo Element not found");
			
		}

}
