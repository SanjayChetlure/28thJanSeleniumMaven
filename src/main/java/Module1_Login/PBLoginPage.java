package Module1_Login;
//pom class 1

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginPage 
{
	//step1: declaration
	@FindBy(xpath="//a[text()='Sign in']") private WebElement signIN;  //private WebElement signIN=driver.findElement(By.xpath(""))
	WebDriver driver1;
	
	//step2: initialization
	public PBLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);     //diffClassName.methodname(webDriver_Object, this_Keyword);
		driver1=driver;
	}
	
	
	//step3: usage
	public void clickPBLoginPageSignIN()
	{
		signIN.click();
	}
	
	public void m1()
	{
		List<WebElement> allLinks = driver1.findElements(By.xpath(""));
	}
	
	
}
