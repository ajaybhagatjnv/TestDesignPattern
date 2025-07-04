package org.ds.constant;

public enum TypeOfJourney {
    RoundTrip("RoundTrip"),
    MultiTrip("MultiTrip"),
    OneWay("OneWay");

    String trip;
    TypeOfJourney(String trip) {
        this.trip = trip;
    }
}
