package projectgithub;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class priority_githublogin 
{
WebDriver driver;
	
	@BeforeMethod(description="Open the chrome browser and goto github login page")
	public void openGitHub() throws Exception {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		Thread.sleep(2000);
	}
	
	@Test(description="Login github with correct username and incorrect passward",priority=1)
	public void FirstUnsuccessfulgithubLogin() throws Exception {
		
		driver.findElement(By.id("login_field")).sendKeys("nomaansharif03@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.name("commit")).click();
		Assert.assertEquals(driver.getTitle(), "GitHub");
		Thread.sleep(2000);
		

	}

	@Test(description="Login github with incorrect username and icorrect passward",priority=2)
	public void SeconedUnsuccesfulGitHubLogin() throws InterruptedException {
		
		
		driver.findElement(By.id("login_field")).sendKeys("sharif03@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pakistan@347");
		driver.findElement(By.name("commit")).click();
		Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
		Thread.sleep(2000);

	}
	@Test(description="Login github with empty username and empty passward",priority=3)
	public void ThirdUnsuccesfulGitHubLogin() throws Exception {
		
		
		driver.findElement(By.id("login_field")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.name("commit")).click();
		Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
		Thread.sleep(2000);
	    
	    

	}
	@Test(description="Login with Correct Username and Password ",priority=4)
	public void SuccesfulGitHubLogin() throws Exception {
		
		
		driver.findElement(By.id("login_field")).sendKeys("nomansharif03@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pakistan@3479870501");
		driver.findElement(By.name("commit")).click();
		Assert.assertEquals(driver.getTitle(), "Sign in to GitHub · GitHub");
		Thread.sleep(2000);
	}
	@Test(description="In the search field search for something",priority=5)
	public void searchTheElementinSearchField() throws Exception {
		
		
		driver.findElement(By.id("login_field")).sendKeys("nomansharif03@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pakistan@3479870501");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Hello" + Keys.ENTER);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Search Hello");
		Thread.sleep(2000);
	}
	@AfterMethod(description="close all the windows after task performed")
	public void closetab() {
		driver.close();
}
}
