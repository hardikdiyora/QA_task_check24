package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Base class of all the Page classes, contains basic variables and behaviours.
 */
class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger Log = Logger.getLogger(BasePage.class);

    private static By emailInput = By.id("email");
    private static By pwdInput = By.id("password");
    public static By submitBtn = By.cssSelector("button[type='submit']");

    BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    /****
     * click on the element.  
     ****/
    public void click(By locator) {
        click(locator, false);
    }

    /****
     * click on the element.
     * @param locator locator of web element.
     ****/
    public void click(By locator, boolean scroll) {
        if(scroll){
            scrollDown();
        }
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /***
     * wait until element to be visible.
     * @param locator locator of web element.
     */
    public void waitUntilElementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /***
     * enter the text into text box.
     * @param locator locator of web element.
     * @param text text to be fill in web element like textbox or text area.
     *
     */
    public void inputText(By locator, String text) {
        waitUntilElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    /***
     * Check whether element is present or not.
     *  @param locator locator of web element.
     */
    public boolean isElementPresent(By locator) {
        try {
            waitUntilElementVisible(locator);
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /***
     * Get the inner text from the element.
     * @param locator locator of web element.
     * @return {String} returns text if element is present otherwise null.
     */
    public String getInnerText(By locator) {
        return isElementPresent(locator) ? driver.findElement(locator).getText() : null;
    }

    /***
     * Scroll down to window.
     */
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
    }

    public void fillBasicEmailAndPwdFields(String email, String pwd) {
        Log.info("Enter the email.");
        inputText(emailInput, email);
        Log.info("Enter the Password.");
        inputText(pwdInput, pwd);
        Log.info("Enter the Repeat password.");
    }
}
