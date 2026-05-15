package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.crypt.temp.AesZipFileZipEntrySource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	WebDriver driver;
	public void saveScreenshot(String testName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")
				+"/screenshots/"
				+"testName"
				+".png");
		FileUtils.copyFile(Source, destination);
		
		
		
		
	}

}
