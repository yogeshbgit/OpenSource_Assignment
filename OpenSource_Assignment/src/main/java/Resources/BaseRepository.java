package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseRepository {
	public WebDriver driver;
	Properties prop;
	public String browser;
	public String url;
	
	public WebDriver initialize() throws IOException
	{
		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(file);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		
		driver.manage().window().maximize();
		return driver;
		
	}
	

}
