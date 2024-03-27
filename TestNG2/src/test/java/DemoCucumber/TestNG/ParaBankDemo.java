package DemoCucumber.TestNG;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ParaBankDemo {
	
	WebDriver driver= new ChromeDriver();
	@BeforeTest
	public void browsersetup() {
		
		WebDriverManager.chromedriver().setup();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	
	@Test(priority=1)
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("pushp");
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("Test123a");
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
			
	}
	
//	@Test(priority=2)
	public void Invalid_login() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("pushpw");
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("Test12");
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		WebElement Login_Error = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
		assertTrue(Login_Error.isDisplayed(),"Login is successful");
			
	}
	
//	@Test(priority=3)
	public void verify_login() throws InterruptedException {
		WebElement Logout_btn = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "ParaBank | Open Account");
		assertTrue(Logout_btn.isDisplayed(),"Logout button is not visible");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void open_new_SavingAccount() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"type\"]/option[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input")).click();	}
	
	@Test(priority=3)
	public void verify_Account_Table() {
		
		List<WebElement> accountHeadTitles =driver.findElements(By.xpath("//*[@id=\"accountTable\"]/thead/tr"));
		Assert.assertEquals(accountHeadTitles.size(), 3);
		
		for(WebElement accountHead:accountHeadTitles)
		System.out.println(accountHead);
	}
	
	@AfterTest
	public void tear_down() {
		driver.close();
	}

}
