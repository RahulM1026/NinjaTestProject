package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ninja.utils.Utilities;

public class Basic {

	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Basic() {
		
		prop = new Properties();
		File PropFile = new File(System.getProperty("user.dir")+"//src//main//java//com//ninja//qa//config//config.properties");
		try {
			FileInputStream fis= new FileInputStream(PropFile);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataprop = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"//src//main//java//com//ninja//qa//testdata//testdata.properties");
		try {
			FileInputStream fis1= new FileInputStream(dataPropFile);
			dataprop.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver Launch(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implict_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.Load_Time));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
