package org.wahlzeit.model;

import org.wahlzeit.model.coordinate.ICoordinate;

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
