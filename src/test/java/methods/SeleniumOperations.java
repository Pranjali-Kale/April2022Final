package methods;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumOperations
{
	public static WebDriver obj=null;
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
	//browser launch
	public static Hashtable<String,Object> browserLaunch(Object[]inputParameters)
	{
		try
		{
		String browserName=(String)inputParameters[0];
		String exe=(String)inputParameters[1];
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", exe);
			obj=new ChromeDriver();
			obj.manage().window().maximize();
			obj.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("fireFox"))
		{
			
			System.setProperty("webdriver.gecko.driver", exe);
			obj=new FirefoxDriver();
			obj.manage().window().maximize();
			obj.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE","Action:Browser Launch,Input Given:"+inputParameters[0].toString());
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE","Action:Browser Launch,Input Given:"+inputParameters[0].toString());
		
		}
		return outputParameters;

	}
	
	//openApplication
	public static Hashtable<String,Object> openApplication(Object[]inputParameters)
	{ 
		try
		{
		
		String url=(String)inputParameters[0];
		obj.get(url);
		obj.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE","Action:Application Launch,Input Given:"+inputParameters[0].toString());
	
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE","Action:Application Launch,Input Given:"+inputParameters[0].toString());
		
		}
		return outputParameters;

		
	}
	//click on element
	public static Hashtable<String,Object> clickOnElement(Object[]inputParameters)
	{
		try
		{
	    obj.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		String xpath=(String)inputParameters[0];
		obj.findElement(By.xpath(xpath)).click();
		
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE","Action:Click On Element,Input Given:"+inputParameters[0].toString());
	
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE","Action:Click On Element,Input Given:"+inputParameters[0].toString());
		
		}
		return outputParameters;

	}
	//move to login
	public static Hashtable<String,Object> login(Object[]inputParameters)
	{
		try 
	    {
	    obj.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    String xpath=(String)inputParameters[0];
		Actions act=new Actions(obj);
		WebElement abc=obj.findElement(By.xpath(xpath));
		act.moveToElement(abc).build().perform();
		
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE","Action:Login,Input Given:"+inputParameters[0].toString());
	
	    }
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE","Action:Login,Input Given:"+inputParameters[0].toString());
		
		}
		return outputParameters;

	}
	//enter username and password
	public static Hashtable<String,Object> sendText(Object[]inputParameters)
	{
		try
		{
		obj.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String xpath=(String)inputParameters[0];
		String abc=(String)inputParameters[1];
		obj.findElement(By.xpath(xpath)).sendKeys(abc);
		
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE","Action:Click On Element,Input Given:"+inputParameters[1].toString());
	
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE","Action:Click On Element,Input Given:"+inputParameters[1].toString());
		
		}
		return outputParameters;

	}
	//validation step
	public static Hashtable<String,Object> validationLogin(Object[]inputParameters)
	{
		try
		{
		obj.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String givenText=(String)inputParameters[0];
		String xpath=(String)inputParameters[1];
		
		String actualText=obj.findElement(By.xpath(xpath)).getText();
		
		if(givenText.equalsIgnoreCase(actualText))
		  {
	       System.out.println("Test case pass");
		  }
	     else
	      {
	    	 System.out.println("Test case fail");
	      }
		outputParameters.put("STATUS", "PASS");
		outputParameters.put("MESSAGE","Action:Click On Element,Input Given:"+inputParameters[0].toString());
	
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("MESSAGE","Action:Click On Element,Input Given:"+inputParameters[0].toString());
		
		}
		return outputParameters;

   }
	
	public static void main(String[]args)
	{
		//calling method launchBrawser
		Object[]input=new Object[2];
		input[0]="Chrome";
		input[1]="D:\\April2022Final\\Flipkart\\src\\test\\resources\\DRIVERS\\chromedriver.exe";
		SeleniumOperations.browserLaunch(input);
		
		Object[]input1=new Object[1];
		input1[0]="https://www.flipkart.com/";
		SeleniumOperations.openApplication(input1);
		
		Object[]input2=new Object[1];
		input2[0]="//*[@class='_2KpZ6l _2doB4z']";
		SeleniumOperations.clickOnElement(input2);
		
		Object[]input3=new Object[1];
		input3[0]="//*[@class='_1_3w1N']";
		SeleniumOperations.login(input3);
		
		Object[]input4=new Object[1];
		input4[0]="//*[@class='_3vhnxf']";
		SeleniumOperations.clickOnElement(input4);
		
		Object[]input5=new Object[2];
		input5[0]="//*[@class='_2IX_2- VJZDxU']";
		input5[1]="7719924108";
		SeleniumOperations.sendText(input5);
		
		Object[]input6=new Object[2];
		input6[0]="//input[@type='password']";
		input6[1]="Anushree";
		SeleniumOperations.sendText(input6);
		
		Object[]input7=new Object[1];
		input7[0]="(//button[@type='submit'])[2]";
		SeleniumOperations.clickOnElement(input7);
		
		Object[]input8=new Object[2];
		input8[0]="Pranjali Kale";
		input8[1]="//*[text()='Pranjali  Kale']";
		SeleniumOperations.validationLogin(input8);
		
		
	}

	

		
	}




