package org.ds.pageObjects;

import org.ds.abstractComponents.SearchFlightAvail;
import org.ds.constant.TypeOfJourney;
import org.ds.pageComponents.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {

    String URL =  "https://rahulshettyacademy.com/dropdownsPractise/";
    WebDriver driver;
    By sectionElementById = By.id("traveller-home");
    By navigationbarByCssSelector = By.cssSelector(".search-buttons-heading");
    By flightBookingById = By.id("flightSearchContainer");

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        driver.get(URL);
    }

    public Footernav getFooterNav(){
        return new Footernav(driver, sectionElementById);
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, navigationbarByCssSelector);
    }

    public SearchFlightAvail setJourneyType(TypeOfJourney typeOfJourney){
        switch (typeOfJourney){
            case TypeOfJourney.RoundTrip:
                return new RoundTrip(driver, flightBookingById);
            case TypeOfJourney.MultiTrip:
                return new MultiTrip(driver, flightBookingById);
            case TypeOfJourney.OneWay:
                return new OneWay(driver, flightBookingById);
            default:
                return null;
        }
    }


}
