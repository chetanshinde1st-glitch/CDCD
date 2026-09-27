package testComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulShettyEcomerce.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage LandingPage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resorces\\GlobalData.properties");

		prop.load(file);
		
		String BrowserName=	System.getProperty("browser")!=null ?System.getProperty("browser") : prop.getProperty("browser");
		//String BrowserName = prop.getProperty("browser");

		if (BrowserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if(BrowserName.equals("Edge"))  {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String getScreenShot(String TestName, WebDriver driver) throws IOException {

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File Source = ts.getScreenshotAs(OutputType.FILE);

	    String path = System.getProperty("user.dir") + File.separator + "reports";

	    File reportFolder = new File(path);

	    if (!reportFolder.exists()) {
	        reportFolder.mkdirs();
	    }

	    File destination = new File(reportFolder, TestName + ".png");

	    FileUtils.copyFile(Source, destination);

	    return destination.getAbsolutePath();
	}


	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException {
		driver = initializeDriver();
		LandingPage = new LandingPage(driver);
		LandingPage.Goto();
		return LandingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void CloseDriver() {
		driver.quit();
	}
}
