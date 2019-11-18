package org.wahlzeit.model;

public class Location {
    private ICoordinate coordinate;

    public Location(ICoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ICoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(ICoordinate coordinate) {
        this.coordinate = coordinate;
    }

}
