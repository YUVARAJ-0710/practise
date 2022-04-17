package UserDefinedLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void screenShotTC(WebDriver ldriver)throws IOException{
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);       
		try
		{  // now copy the  screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File("C:\\Users\\825627\\eclipse-workspace\\Phptravels\\TCScreenshot\\"+System.currentTimeMillis()+".png"));
        }catch (IOException e)      
			{
        		System.out.println(e.getMessage());      
			}
	  }
}



