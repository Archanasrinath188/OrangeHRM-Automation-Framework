package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
	@BeforeClass
	 @Parameters({"browser","os"})
	public void setup(String br,String os) throws IOException {
		
		switch (br.toLowerCase()) {

		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;
			
		case"firefox":
			driver=new FirefoxDriver();
			break;


		default:
			System.out.println("invlaid browser");
			break;
		}
		
		 System.out.println(br);
	      System.out.println(os);
		FileReader file=new FileReader(".//src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		   
	}
	
	public String captureScreen(String tname) throws IOException {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot  takescreenshot= (TakesScreenshot)driver;
		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(sourcefile, targetFile);		
		
		return targetFilePath;
	
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	

}
