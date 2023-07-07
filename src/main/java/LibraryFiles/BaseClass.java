package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	public WebDriver driver;
	
	public void initializeBrowser(String browserName) throws IOException
	{
			
		if (browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

}
