package ui_tests;

import logger.TALogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/***
 * Base class for all Test classes, contains basic initialization and teardown behaviours.
 */
public class UITestBase {
    protected Logger Log;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initializeLogger(){
        //Load the Logger class configuration using spring framework.
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TALogger.class);
        TALogger taLogger = context.getBean(TALogger.class);

        // Get Logger object which is used by sub classes.
        Log = taLogger.getLogger(getClass());
    }

    @Parameters({"browser"})
    @BeforeClass
    public void openBrowser(String browser){
        Log.info("Opening the " + browser +" Browser.");
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if( browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else {
            Log.info("Browser is not specified.");
        }

        //Create a wait. All the TestClasses & PageClasses have to use this wait object.
        wait = new WebDriverWait(driver,15);

        //Maximize Browser Window
        driver.manage().window().fullscreen();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Log.info("Quiting the Browser.");
        driver.quit();
    }

    @BeforeMethod
    public void openWebApp(){
        Log.info("Opening the Check24 Web Application Landing Page.");
        driver.get("https://www.check24.de");
    }
}
