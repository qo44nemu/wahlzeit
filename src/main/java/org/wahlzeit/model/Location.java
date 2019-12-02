package org.wahlzeit.model;

public class Location {
    private ICoordinate coordinate;

    public Location(ICoordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("Coordinate can not be null!");
        }
        this.coordinate = coordinate;
    }

    public ICoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(ICoordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("Coordinate can not be null!");
        }
        this.coordinate = coordinate;
    }

}
