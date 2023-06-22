package Module1_login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.PBHomePage;
import Module1_Login.PBLoginPage;
import Module1_Login.PBMobNumPage;
import Module1_Login.PBMyAccPage;
import Module1_Login.PBProfilePage;
import Module1_Login.PBPwdPage;

public class PBLoginTest1 extends BaseClass
{
	PBLoginPage login;
	PBMobNumPage mobNum;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myAcc;
	PBProfilePage profile;
	int TCID;

	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String browserName) throws EncryptedDocumentException, IOException
	{
		initializeBrowser(browserName);
		 login=new PBLoginPage(driver);
		 mobNum=new PBMobNumPage(driver);
		 pwd=new PBPwdPage(driver);
		 home=new PBHomePage(driver);
		 myAcc=new PBMyAccPage(driver);
		 profile=new PBProfilePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		login.clickPBLoginPageSignIN();
		mobNum.inpPBMobNumPageMobNum(UtilityClass.getPFData("MobNum"));
		mobNum.clickPBMobNumPageSignInWithPwd();
		pwd.inpPBPwdPagePWD(UtilityClass.getPFData("PWD"));
		pwd.clickPBPwdPageSignIn();
		Thread.sleep(3000);
	}
	
	
	@Test
	public void verifyFullName() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=102;
		home.openDDOptionPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		profile.switchToSwitchChildWindow();
		String actResult=profile.getPBProfilePageFullName();
		String expResult=UtilityClass.getTestData(0, 2);
		Assert.assertEquals(actResult, expResult,"Failed: both results are diff-: ");
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();		
	}

}
