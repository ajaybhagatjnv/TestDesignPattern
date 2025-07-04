package org.ds.pageComponents;

import org.ds.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footernav extends AbstractComponents {

    WebElement sectionElement;
    By flightByCssSelector = By.cssSelector("[title='Flights']");

    public Footernav(WebDriver driver, By sectionElementById) {
        super(driver, sectionElementById);
    }

    public void selectFlight(){
        findElement(flightByCssSelector).click();
    }
    public String getAttribute(String attribute){
        return getAttribute(flightByCssSelector, attribute);
    }
    public String getText(){
        return getText(flightByCssSelector);
    }
}
