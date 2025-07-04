package org.ds.pageComponents;

import org.ds.abstractComponents.AbstractComponents;
import org.ds.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class RoundTrip extends AbstractComponents implements SearchFlightAvail {

    private By roundTripRdoByCss = By.cssSelector("input[value='RoundTrip']");
    private By fromById = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By getOriginPathByCssSelector(String source){ return By.cssSelector("a[ value='"+ source +"']");}
    private By getDestinationPathByCssSelector(String destination){ return By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='"+ destination +"']");}
    private By toById = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By studentRdoButtonById = By.id("ctl00_mainContent_chk_StudentDiscount");
    private By submitByCssSelector = By.cssSelector(".btn-find-flight-home input[type='submit']");

    public RoundTrip(WebDriver driver, By flightBookingById) {
        super(driver, flightBookingById);
    }
    @Override
    public void checkAvailability(Map<String, String> travelData) {
        findElement(roundTripRdoByCss).click();
        Assert.assertTrue(findElement(roundTripRdoByCss).isSelected());

        By originByCssSelector = getOriginPathByCssSelector(travelData.get("source"));
        By destinationByCssSelector = getDestinationPathByCssSelector(travelData.get("destination"));

        // Execute around strategy
        executeWaitMethod(setup -> setup.selectSourceCity(fromById, originByCssSelector), originByCssSelector);
        executeWaitMethod(t -> t.selectDestinationCity(toById, destinationByCssSelector), destinationByCssSelector);

        findElement(studentRdoButtonById).click();
        findElement(submitByCssSelector).click();
    }

}
