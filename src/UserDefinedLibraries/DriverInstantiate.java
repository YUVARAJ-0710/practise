package UserDefinedLibraries;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class DriverInstantiate {
	public static String exepath;
	public static WebDriver driver;
	public static String url="https://www.phptravels.net/public/amadeus/";
	public static String browsertype;
	
	public static WebDriver driverinstant(String browser)
	{
		browsertype=browser;
		if(browser.equalsIgnoreCase("chrome"))
		{
			exepath="C:\\Selenium Assessment jars\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",exepath);
			driver= new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("ie"))
		{
			exepath="C:\\Selenium Assessment jars\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",exepath);
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
         driver.manage().deleteAllCookies();
		return driver;
		
	}
	   public static void driverClose()
       {
                     DriverInstantiate.driver.close();              
       }


}
