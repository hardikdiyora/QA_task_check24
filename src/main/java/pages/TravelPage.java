package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

/***
 * Page class for Travel Page of check24.de portal
 */
public class TravelPage extends BasePage {

    private static By fieldsetForm = By.cssSelector("fieldset[class*='travel-searchform']");
    private static By destinationInput = By.cssSelector("input[name='destination']");
    private static By dropdownSelect = By.cssSelector("a[href='#']");
    private static By airportInput = By.cssSelector("input[name='airport-element']");
    private static By durationOpen = By.cssSelector("div[class*='duration-overlay']");
    private static By customDuration = By.id("c24-travel-custom-duration-input");
    private static By customBtn = By.cssSelector("span[class$='btn-use-duration-value']");
    private static By deptDateInput = By.cssSelector("input[name='departureDate']");
    private static By returnDateInput = By.cssSelector("input[name='returnDate']");
    private static By miniSearchBox = By.cssSelector(".search-box-cnt ");
    private static By offerPanel = By.cssSelector(".offer-cnt");

    TravelPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        waitUntilElementVisible(fieldsetForm);
    }

    /***
     * To search the travel plan
     * @param travelPlan the detail of travel plan in Key-Value pair.
     * @return {Integer} returns number of search result
     */
    public Integer searchTravelPlan(HashMap<String, String> travelPlan) {
        this.setDestination(travelPlan.get("destination"));
        this.setAirport(travelPlan.get("airport"));
        this.setDaysDuration(travelPlan.get("days"));
        this.setDepAndReturnDates(travelPlan.get("departureDate"), travelPlan.get("returnDate"));
        Log.info("Click on submit button.");
        click(submitBtn);
        waitUntilElementVisible(miniSearchBox);
        waitUntilElementVisible(offerPanel);
        List<WebElement> searchResult = driver.findElements(offerPanel);
        return searchResult.size();
    }

    private void setDestination(String destination) {
        Log.info("Enter the destination");
        inputText(destinationInput, destination);
        click(dropdownSelect);
    }

    private void setAirport(String airport) {
        Log.info("Enter the airport name");
        inputText(airportInput, airport);
        By locator = By.cssSelector("a[title='"+ airport +"']");
        click(locator);
    }

    private void setDaysDuration(String days) {
        Log.info("Enter the duration detail");
        click(durationOpen);
        inputText(customDuration, days);
        click(customBtn);
    }

    private void setDepAndReturnDates(String depDate, String reDate) {
        Log.info("Enter the departure date");
        inputText(deptDateInput, depDate);
        Log.info("Enter the return date");
        inputText(returnDateInput, reDate);
    }
}
