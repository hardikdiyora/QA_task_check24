package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Page class for Landing Page of check24.de portal
 */
public class LandingPage extends BasePage {

    private static By logo = By.className("c24-logo");
    private static By signIn = By.cssSelector("#c24-customer-salutation > a");
    private static By registerLink = By.cssSelector("a[href$='register.html']");
    private static By hoverMenu = By.className("c24-customer-hover-corner");
    private static By travelLink = By.cssSelector("div[class$='-nav-travel'] > a");

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        waitUntilElementVisible(logo);
    }

    /***
     * Use for navigation
     * @param pageName the name of the page
     * @return {BasePage} returns Base page object if its valid page name otherwise exception.
     */
    public BasePage navigateToPage(String pageName) {
        BasePage page;
        if ("register".equalsIgnoreCase(pageName)) {
            Log.info("Navigate to Register Page.");
            click(hoverMenu);
            click(registerLink);
            page = new RegisterPage(this.driver, this.wait);
        } else if ("login".equalsIgnoreCase(pageName)) {
            Log.info("Navigate to Login Page.");
            click(signIn);
            page = new LoginPage(this.driver, this.wait);
        } else if ("travel".equalsIgnoreCase(pageName)) {
            Log.info("Navigate to Travel Page.");
            click(travelLink);
            page = new TravelPage(this.driver, this.wait);
        }
        else {
            throw new IllegalArgumentException("Invalid page name: " + pageName);
        }
        return page;
    }
}
