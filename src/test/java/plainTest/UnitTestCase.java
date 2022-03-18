package plainTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UnitTestCase 
{
	public static void main(String[]args)
	{
		//launch browser
		System.setProperty("webdriver.chrome.driver", "D:\\April2022Final\\Flipkart\\src\\test\\resources\\DRIVERS\\chromedriver.exe");
		ChromeDriver obj=new ChromeDriver();
		obj.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		//open app
		obj.get("https://www.flipkart.com/");
		//cancle login window
		obj.findElementByXPath("//*[@class='_2KpZ6l _2doB4z']").click();
		//move to login
		Actions act=new Actions(obj);
		WebElement abc=obj.findElementByXPath("//*[@class='_1_3w1N']");
		act.moveToElement(abc).build().perform();
		//click on My Profile
		obj.findElementByXPath("//*[@class='_3vhnxf']").click();
		//Enter username
	    obj.findElementByXPath("(//input[@type='text'])[2]").sendKeys("7719924108");
	    obj.findElementByXPath("//input[@type='password']").sendKeys("Anushree");
	    obj.findElementByXPath("(//button[@type='submit'])[2]").click();
		
		//obj.findElementByXPath("//*[@class='_2IX_2- _3mctLh VJZDxU']").sendKeys("Anushree");
		//obj.findElementByXPath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']").click();
		
		//click on my profile
		//obj.findElementByXPath("//*[@class='_3vhnxf']").click();
	    //adding command to check github
	}

}

