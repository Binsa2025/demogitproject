package weblistenerpack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainclass 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","D:\\Selenium files\\geckodriver-v0.30.0-win64\\\\geckodriver.exe");
	    WebDriver driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    EventFiringWebDriver eventhandler= new EventFiringWebDriver(driver);
	    EventCapture ecapture = new  EventCapture();
	    eventhandler.register(ecapture);
	    eventhandler.navigate().to("http://www.amazon.in");
	    js.executeScript("window.scrollBy(0,600)");
	    eventhandler.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div[1]/div[1]/a/div[2]/span")).click();
	    eventhandler.navigate().back();
	    eventhandler.quit();
	    eventhandler.unregister(ecapture);
	    System.out.println("end of listener class");
	    

	}

}
