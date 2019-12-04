package org.wahlzeit.model;

public interface ICoordinate {
    public CartesianCoordinate asCartesianCoordinate();

    public double getCartesianDistance(ICoordinate coordinate)throws IllegalArgumentException, IllegalStateException;

    public SphericalCoordinate asSphericalCoordinate();

    public double getCentralAngle(ICoordinate coordinate)throws IllegalArgumentException, IllegalStateException;

    public boolean isEqual(ICoordinate coordinate);
}
