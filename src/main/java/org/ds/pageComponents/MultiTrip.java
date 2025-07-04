package org.ds.pageComponents;

import org.ds.abstractComponents.AbstractComponents;
import org.ds.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MultiTrip extends AbstractComponents implements SearchFlightAvail {

    private By multiTripRdoByCss = By.cssSelector("input[value='TripPlanner']");
    private By fromById = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By fromById2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By toById = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By toById2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");

    private By getOriginPathByCssSelector(String source){ return By.cssSelector("a[ value='"+ source +"']");}
    private By getDestinationPathByCssSelector(String destination){ return By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='"+ destination +"']");}
    private By getOriginPathByCssSelector2(String source2){ return By.cssSelector("#glsctl00_mainContent_ddl_originStation2_CTNR a[value='"+ source2 +"']");}
    private By getDestinationPathByCssSelector2(String destination2){ return By.cssSelector("#glsctl00_mainContent_ddl_destinationStation2_CTNR a[value='"+ destination2 +"']");}
    private By studentRdoButtonById = By.id("ctl00_mainContent_chk_StudentDiscount");
    private By submitByCssSelector = By.cssSelector(".btn-find-flight-home input[type='submit']");
    private By multiCityModelAlertById = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By flightBookingById) {
        super(driver, flightBookingById);
    }

    @Override
    public void checkAvailability(String source, String destination) {
        findElement(multiTripRdoByCss).click();
        findElement(multiCityModelAlertById).click();
        Assert.assertTrue(findElement(multiTripRdoByCss).isSelected());

        findElement(fromById).click();
        findElement(getOriginPathByCssSelector(source)).click();
        findElement(toById).click();
        findElement(getDestinationPathByCssSelector(destination)).click();

        findElement(fromById2).click();
        findElement(getOriginPathByCssSelector2(destination)).click();
        findElement(toById2).click();
        findElement(getDestinationPathByCssSelector2(source)).click();

        findElement(studentRdoButtonById).click();
        findElement(submitByCssSelector).click();
    }
}
