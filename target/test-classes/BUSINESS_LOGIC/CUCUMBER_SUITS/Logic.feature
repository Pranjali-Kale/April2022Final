Feature: Login Functionality

Background: User is successfully openApplication
Given user opens "Chrome" browser with exe as "D:\\April2022Final\\Flipkart\\src\\test\\resources\\DRIVERS\\chromedriver.exe"
Given user opens URL as "https://www.flipkart.com/"

@SmokeTest
Scenario: Login functionality with valid valid username and valid password
When user click on cancle login window
When user moveto Login
When user click on Myprofile
When user enter "7719924108" as username
When user enter "Anushree" as password
When user click on login button
Then Application shows Login successfully