package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Page class for Register Page of check24.de portal
 */
public class RegisterPage extends BasePage {

    private static By repeatPwdInput = By.id("passwordrepetition");
    private static By homePageHeader = By.cssSelector("div[class$='salutation']");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /***
     * To register a new user
     * @param email the email address of the user
     * @param password the password of the user
     * @return {Boolean} returns true if registration is successful other wise false
     */
    public Boolean registerUser(String email, String password) {
        this.fillRegistrationForm(email, password);
        return getInnerText(homePageHeader).contains(email);
        // TODO : Generally It will return us the UserHomePage object if it successful other wise same page object.
        // Like follows,
        //        return isElementPresent(homePageHeader) ? new UserHomePage(this.driver, this.wait) : this;
    }

    private void fillRegistrationForm(String email, String pwd) {
        fillBasicEmailAndPwdFields(email, pwd);
        inputText(repeatPwdInput, pwd);
        Log.info("Click on Submit button.");
        click(submitBtn, true);
    }
}
