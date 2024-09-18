package testbase;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.goibibo.flightsbooking.GoibiboHomeFactory;

import extentreports.ExtentReportFactory;

public class TestSuiteBase extends ExtentReportFactory{
	protected static WebDriver driver;
	protected GoibiboHomeFactory homePage;
	
	@Parameters({"platform", "browser", "url"})
	@BeforeClass
	public void setUp(String platform, String browser, String url) throws Exception{
		driver = getRemoteDriverInstance(platform, browser, url);
		ExtentReportFactory.driver = driver;
		test = extent.createTest("Goibibo Flight Tab Test");
		homePage = new GoibiboHomeFactory(driver, test);
	}
	
	public static WebDriver getRemoteDriverInstance(String platform, String browser, String url) throws Exception {
		URL nodeURL = new URI("http://192.168.56.1:4444").toURL();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.fromString(platform));
		caps.setBrowserName(browser);
		driver = new RemoteWebDriver(nodeURL, caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		return driver;
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
