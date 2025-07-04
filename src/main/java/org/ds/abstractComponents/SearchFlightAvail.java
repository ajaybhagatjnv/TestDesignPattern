package org.ds.abstractComponents;

import org.openqa.selenium.By;

import java.util.Map;

public interface SearchFlightAvail {
    void checkAvailability(Map<String, String> travelData);
}
