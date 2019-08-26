package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			String ChromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromePath );
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			String FirefoxPath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FirefoxPath );
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("headless")) 
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					System.getProperty("user.dir")+"\\Drivers\\phantomjs.exe");
			String[] phantomJsArgs = {"--web-security=no","--ignore--ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps);
		}
		else if (browserName.equalsIgnoreCase("chromeheadless")) 
		{
			String ChromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromePath );
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			opt.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(opt);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.nopcommerce.com/");	
	}
	@AfterSuite
	public void StopDriver()
	{
		driver.quit();
	}
}
