Selenium-Java-POM-TestNG-PageFactory and REST Assured
Automating functional UI and end to end tests for https://www.encoretickets.co.uk/ website and Mobile App. This project uses the page object model (POM) design.

Stack & Libraries
Java
Selenium WebDriver
Appium
TestNG
Maven
Extent Reports and logging
Prerequisites
IDE (Eclipse)
JDK (version 7 or 8)
Maven configuration
Easy way to configure Maven (Mac)
Click to view instructions
How to run tests
In terminal:

git clone [(https://github.com/phaneendhra2980/Selenium-restassured-java.git]
Change directory to the location of cloned project folder and run Maven clean

mvn clean
To run the test

mvn test
Note: For the verifyLogin test case to pass, you must edit the SmokeTestSuite.xml and change the values for parameter "username" and "password" to a registered username/password
Project components
Page objects are in the directory src/main/java/pages
Test classes are in the the directory src/test/java/tests
Listener class is in the directory src/main/java/util


Page Objects Pattern
page object pattern is used to have reusable WebElements/small helper methods separated from actual test classes and give the opportunity to have nice structured and easily readable tests (without the overhead of BDD-Frameworks like Cucumber or JBehave).


Implemented Browsers
Thanks to the awesome webdrivermanager it supports the following browsers:

Chrome
Firefox
Safari


Highlights
This framework supports Chrome browser
This uses WebDriverManager, an open source browser binary manager. Selenium WebDriver requires you to download the binaries for each driver and hardcode the path of the driver. The disadvantage of this is each user must change the code to match their path, and they must manually check when new versions of the binaries are released. WebDriverManager automatically checks the latest version of the browser downloaded on your machine and downloads the required driver binary into the cache, eliminating the need to manually download and store binary files.
Screenshot on test failure: A screenshot of the active browser is captured and stored in the screenshots folder
Extent reporting and logging: After the test finishes, a visual report is generated for all the executed test cases from the suite. This report can be found in the 'report' folder

Introduction
This is a quickstart test automation framework based on Page Object Model design pattern for Selenium WebDriver with Java, maven and TestNG. It also integrates Extent Reports for reporting. Note :

This framework uses PageFactory method to store the WebElements in the page objects. The elements are initialized in the constructors of their respective page objects with the help of PageFactory.initElements

Test Scenario
We have taken a very simple test scenario for quickstart. Search a keyword on google and validate if the keyword appears as the first result on search results page.

Test Steps:
	1. Open google search application: url- www.google.com
	2. Enter a keyword in the search box
	3. On the search results page, validate if the keyword appears as the first result.
Plugins
Eclipse Plugin - If you want to run your tests from Eclipse as TestNG Suite, you need to download TestNG in Eclipse through available software site- TestNG.

Maven Dependencies - This framework has been designed with following maven dependencies as defined further in the pom.xml.

Dependency	Version	Purpose
Selenium WebDriver	3.141	It automates the testing of web application.
TestNG	7.3.0	To run the tests as a suite.
Extent Reports	5.0.6	To genarate Enhanced html reports after test run.
APACHE Commons IO	2.8.0	To perform file opeartions.
webdrivermanager	4.3.1	WebDriverManager is a library which allows to automate the management of the drivers (e.g. chromedriver, geckodriver, etc.) required by Selenium WebDriver. bonigarcia/webdrivermanager: Automated driver management for Selenium WebDriver (github.com)
Apache POI	5.0.0	To read and write .xls excel files (e.g. test data files)
POI-OOXML	5.0.0	To read and write .xlsx excel files (e.g. test data files)
pom.xml

	<dependencies>

		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.3.0</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.0.6</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.8.0</version>
		</dependency>
		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>4.3.1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.0.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.0.0</version>
		</dependency>

	</dependencies>
How to use
The first thing a framework should be able to handle is to launch the browser and navigate a given url.

Download Dependencies
First of all, you need to download your maven depenedencies using any of the maven commands such as Go to- 1. Eclipse> Project Explorer 2. Right click on the project. 3. Maven> Update Project.

Project structure
The automation framework is built to address following 4 major requirements through it's components.

Setup the WebDriver to automate actions on browser.
Read test data from test data file(formats such as .xls, .json, .xml etc.)
Page Classes for each page containing locators of their respective WebElements and methods to operate on them.
Test Classes containing Test cases in the form of methods with annotation @Test.
Execution control- We are executing our tests through testng.xml. It can be other options such as through mvn test or command line.
Create a readable html report after test execution.
Test Classes
We have a class DemoTest.java under src/test/java/quickstart.Tests. Every Test method has annotation @test. This is the place where we have all the checkpoints. This class utilizes TestNG annotations to handle the flow of test execution in the given order.

@BeforeSuite-

Setup the chromedriver binaries using below: WebDriverManager.chromedriver().setup();
Initialize the WebDriver driver
Initialize the Logger logger
loads the test data file and initialize it in testdata
@BeforeMethod-

Create a test in Extent Report before each test.
Navigate a urland maximize the window.
@Test-

Initialize the page objects.
Validation steps by calling the page objects.
@AfterMethod

End the logging for the test.
@AfterSuite

End the test suite in logging
Quit the WebDriver instance
Page classes
We create page classes for each of the pages of our application. src/main/java> quickstart.pages> GoogleSearchPage.java

Each page class contains two components as below.

Locators are written as below
	@FindBy(xpath="//div[@class='g']//h3/span")
	WebElement firstResult;
Page class methods for tests steps
Page class constructor sets the driver and initializes the webelements through
	PageFactory.initElements(driver, this);
Run tests through testng.xml
If you want to run your tests through testng.xml , You can perform following steps.

Eclipse>Project Explorer
Open/Expand the project
Right click on the testng.xml
Run As> TestNG Suite
It will run all the tests as per defined classes in the the file.

Run tests through maven
If you want to run your tests through maven, You can perform following steps.

Eclipse> Project Explorer
Right click on the project.
Run As> Maven test.
It will automatically run all the tests as per below convention.

Classes under src/test/java
Class name with text Test in the beginneing or end
Test methods with annotation @test
