package ui_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.RegisterPage;

public class RegisterTest extends UITestBase {
    private RegisterPage registerPage;

    @BeforeMethod
    void setUp(){
        Log.info("Navigate to Landing Page");
        LandingPage landingPage = new LandingPage(driver, wait);
        registerPage = (RegisterPage) landingPage.navigateToPage("register");
    }

    @Test
    void verifyUserSuccessfulRegistration(){
        Log.info("Verify user is able to register successfully");
        String randomEmail = "user-" + (int) Math.floor(Math.random()*1000) + "@gmail.com";
        Assert.assertTrue(registerPage.registerUser(randomEmail, "Abcd@1234"));
    }
}
