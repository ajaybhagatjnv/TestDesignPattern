package org.ds.pageComponents;

import org.ds.abstractComponents.AbstractComponents;
import org.ds.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class OneWay extends AbstractComponents implements SearchFlightAvail {

    private By oneWayRdoByCss = By.cssSelector("input[value='OneWay']");
    private By fromById = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By getOriginPathByCssSelector(String source){ return By.cssSelector("a[ value='"+ source +"']");}
    private By getDestinationPathByCssSelector(String destination){ return By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='"+ destination +"']");}
    private By toById = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By studentRdoButtonById = By.id("ctl00_mainContent_chk_StudentDiscount");
    private By submitByCssSelector = By.cssSelector(".btn-find-flight-home input[type='submit']");

    public OneWay(WebDriver driver, By flightBookingById) {
        super(driver, flightBookingById);
    }

    @Override
    public void checkAvailability(Map<String, String> travelData) {
       Assert.assertTrue(findElement(oneWayRdoByCss).isSelected());
       By originByCssSelector = getOriginPathByCssSelector(travelData.get("source"));
       By destinationByCssSelector = getDestinationPathByCssSelector(travelData.get("destination"));
       executeWaitMethod(setup -> setup.selectSourceCity(fromById, originByCssSelector), originByCssSelector);
       executeWaitMethod(t -> t.selectDestinationCity(toById, destinationByCssSelector), destinationByCssSelector);
       findElement(studentRdoButtonById).click();
       findElement(submitByCssSelector).click();
    }
}
