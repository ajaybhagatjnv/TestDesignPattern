package org.ds.pageComponents;

import org.ds.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar extends AbstractComponents {

    By flightByCssSelector = By.cssSelector("[title = 'Flights']");

    public NavigationBar(WebDriver driver, By selectionElementById) {
        super(driver, selectionElementById);
    }

    @Override
    public WebElement findElement(By elementPath) {
        return sectionElement.findElement(elementPath);
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
