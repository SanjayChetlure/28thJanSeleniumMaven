package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	
	//@AuthorName: Sanjay
	//This method is use to get Test data from excel.
	//need to pass 2 inputs: 1-rowIndex, 2-colIndex
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\workspaceFor28thJan23\\28thJanSeleniumMaven\\TestData\\28thJan.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
		return value;
	}
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\workspaceFor28thJan23\\28thJanSeleniumMaven\\FailedTCesSS\\TestCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	public static String getPFData(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\workspaceFor28thJan23\\28thJanSeleniumMaven\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	
	
	public static void openDDOption(WebDriver driver, WebElement ele) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();		
	}
	
	public static void clicOnDDOption(WebDriver driver, WebElement ele) 
	{
		Actions act=new Actions(driver);
		act.click(ele).perform();	
	}
	

}
