package org.ds.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponents {
    public WebElement sectionElement;
    public AbstractComponents(WebDriver driver, By elementPath) {
        this.sectionElement = driver.findElement(elementPath);
    }

    public WebElement findElement(By elementPath){
        return sectionElement.findElement(elementPath);
    }
    public List<WebElement> findElements(By elementPath){
        return sectionElement.findElements(elementPath);
    }

    public String getAttribute(By locators, String attribute){
        return findElement(locators).getAttribute(attribute);
    }
    public String getText(By locators){
        return findElement(locators).getText();
    }
    public int getLinksCount(){
        return findElements(By.tagName("a")).size();
    }
}





