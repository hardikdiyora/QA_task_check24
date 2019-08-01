package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Page class for Login Page of check24.de portal
 */
public class LoginPage extends BasePage {

    private static By oAuthContainer = By.className("oauth-btn-container");
    private static By homePageHeader = By.cssSelector("div[class$='salutation']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        waitUntilElementVisible(oAuthContainer);
    }

    /***
     * To login into user account
     * @param email the email address of the user
     * @param password the password of the user
     * @return {Boolean} returns true if successful logged in otherwise false
     */
    public Boolean loginToAccount(String email, String password) {
        fillBasicEmailAndPwdFields(email, password);
        Log.info("Click on submit button.");
        click(submitBtn, true);
        return getInnerText(homePageHeader).contains(email);
        // TODO : Generally It will return us the UserHomePage object if it successful other wise same page object.
        // Like follows,
        //        return isElementPresent(homePageHeader) ? new UserHomePage(this.driver, this.wait) : this;
    }
}
