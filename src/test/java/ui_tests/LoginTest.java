package ui_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends UITestBase {
    private LoginPage loginPage;

    @BeforeMethod
    void setUp(){
        Log.info("Navigate to Landing Page");
        LandingPage landingPage = new LandingPage(driver, wait);
        loginPage = (LoginPage) landingPage.navigateToPage("login");
    }

    @Test
    void verifyLoginSuccessfulWithValidCredentials(){
        Log.info("Verify user is able to login successfully with valid credentials.");
        Assert.assertTrue(loginPage.loginToAccount("aut1234@gmail.com","Abc@123"));
    }
}
