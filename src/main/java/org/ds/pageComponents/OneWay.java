package org.ds.pageComponents;

import org.ds.abstractComponents.AbstractComponents;
import org.ds.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
    public void checkAvailability(String source, String destination) {
       Assert.assertTrue(findElement(oneWayRdoByCss).isSelected());
       findElement(fromById).click();
       findElement(getOriginPathByCssSelector(source)).click();
       findElement(toById).click();
       findElement(getDestinationPathByCssSelector(destination)).click();
       findElement(studentRdoButtonById).click();
       findElement(submitByCssSelector).click();
    }
}
