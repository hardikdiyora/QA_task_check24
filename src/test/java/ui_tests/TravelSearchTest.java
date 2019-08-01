package ui_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.TravelPage;

import java.util.HashMap;

public class TravelSearchTest extends UITestBase {
    TravelPage travelPage;

    @BeforeMethod
    void setUp(){
        Log.info("Navigate to Landing Page");
        LandingPage landingPage = new LandingPage(driver, wait);
        travelPage = (TravelPage) landingPage.navigateToPage("travel");
    }
    @Test
    void verifyUserSearchTravelPlan(){
        Log.info("Preparing the travel search data.");
        HashMap<String, String> travelPlan = new HashMap<String, String>();
        travelPlan.put("destination", "Mallorca");
        travelPlan.put("airport", "München");
        travelPlan.put("days", "7");
        travelPlan.put("departureDate", "05.09.2019");
        travelPlan.put("returnDate", "11.09.2019");
        Log.info("Verify user is able to search travel plan successfully with at least 1 search result.");
        Assert.assertTrue(travelPage.searchTravelPlan(travelPlan) > 1);
    }
}
