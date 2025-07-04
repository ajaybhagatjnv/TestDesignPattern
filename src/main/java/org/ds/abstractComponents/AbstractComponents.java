package org.ds.abstractComponents;

import org.ds.pageComponents.MultiTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractComponents {
    public WebElement sectionElement;
    public WebDriverWait wait;
    public AbstractComponents(WebDriver driver, By elementPath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    public Boolean waitForInvisibilityOfElement(By elementId){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(elementId));
    }

    public void selectSourceCity(By sourceTableHeader, By sourceCityPath) {
        System.out.println("execution in source city starts ...");

        findElement(sourceTableHeader).click();
        findElement(sourceCityPath).click();

        System.out.println(" in source city completed");
    }

    public void selectDestinationCity(By destinationHeaderTable, By destinationCityPath) {
        System.out.println("execution in destination city ....");

        findElement(destinationHeaderTable).click();
        findElement(destinationCityPath).click();

        System.out.println(" execution in destination city completed ....");

    }
    // Execute around strategy
    public void executeWaitMethod(Consumer<AbstractComponents> consumer, By element){
        System.out.println("executeWaitMethod starts ....");
        consumer.accept(AbstractComponents.this);
        waitForInvisibilityOfElement(element);
        System.out.println("executeWaitMethod is completed ....");
    }
}





