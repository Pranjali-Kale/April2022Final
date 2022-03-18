package cucumbermap;

import java.util.Hashtable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import methods.HTMLReportGenerator;
import methods.SeleniumOperations;

public class Login 
{
	@Given("^user opens \"(.*)\" browser with exe as \"(.*)\"$")
	public void launchBrowser(String bname, String exe)
	{
		Object[]input=new Object[2];
		input[0]=bname;
		input[1]=exe;
		SeleniumOperations.browserLaunch(input); 
	}

	@Given("^user opens URL as \"(.*)\"$")
	public void openApp(String url) 
	{
		Object[]input1=new Object[1];
		input1[0]=url;
		SeleniumOperations.openApplication(input1);
	}

	@When("^user click on cancle login window$")
	public void cancleWindow() 
	{
		Object[]input2=new Object[1];
		input2[0]="//*[@class='_2KpZ6l _2doB4z']";
		Hashtable<String,Object>input2op=SeleniumOperations.clickOnElement(input2);
		HTMLReportGenerator.StepDetails(input2op.get("STATUS").toString(),"user click on cancle login window", input2op.get("MESSAGE").toString());
	}

	@When("^user moveto Login$")
	public void movetoLogin() 
	{
		Object[]input3=new Object[1];
		input3[0]="//*[@class='_1_3w1N']";
		Hashtable<String,Object>input3op=SeleniumOperations.login(input3);
		HTMLReportGenerator.StepDetails(input3op.get("STATUS").toString(),"user moveto Login", input3op.get("MESSAGE").toString());
	}

	@When("^user click on Myprofile$")
	public void myProfile() 
	{
		Object[]input4=new Object[1];
		input4[0]="//*[@class='_3vhnxf']";
		Hashtable<String,Object>input4op=SeleniumOperations.clickOnElement(input4);
		HTMLReportGenerator.StepDetails(input4op.get("STATUS").toString(),"user click on Myprofile", input4op.get("MESSAGE").toString());

	
	}

	@When("^user enter \"(.*)\" as username$")
	public void username(String uname)
	{
		Object[]input5=new Object[2];
		input5[0]="//*[@class='_2IX_2- VJZDxU']";
		input5[1]=uname;
		Hashtable<String,Object>input5op=SeleniumOperations.sendText(input5);
		HTMLReportGenerator.StepDetails(input5op.get("STATUS").toString(),"user enter \\\"(.*)\\\" as username", input5op.get("MESSAGE").toString());

	}

	@When("^user enter \"(.*)\" as password$")
	public void password(String pname) 
	{
		Object[]input6=new Object[2];
		input6[0]="//input[@type='password']";
		input6[1]=pname;
		Hashtable<String,Object>input6op=SeleniumOperations.sendText(input6); 
		HTMLReportGenerator.StepDetails(input6op.get("STATUS").toString(),"user enter \\\"(.*)\\\" as password", input6op.get("MESSAGE").toString());

	}

	@When("^user click on login button$")
	public void login() 
	{
		Object[]input7=new Object[1];
		input7[0]="(//button[@type='submit'])[2]";
		Hashtable<String,Object>input7op=SeleniumOperations.clickOnElement(input7); 
		HTMLReportGenerator.StepDetails(input7op.get("STATUS").toString(),"user click on login button", input7op.get("MESSAGE").toString());

		
	}
	@Then("^Application shows Login successfully$")
	public void vlidationforlogin() throws InterruptedException 
	{
		Thread.sleep(3000);
		Object[]input8=new Object[2];
		input8[0]="Pranjali Kale";
		input8[1]="//*[text()='Pranjali  Kale']";
		Hashtable<String,Object>input8op=SeleniumOperations.validationLogin(input8);
		HTMLReportGenerator.StepDetails(input8op.get("STATUS").toString(),"Application shows Login successfully", input8op.get("MESSAGE").toString());

	}
	


}
