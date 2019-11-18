package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate implements ICoordinate {
    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private boolean compareDoubles(double firstValue, double secondValue) {
        double precision = 0.000000001;
        return Math.abs(firstValue - secondValue) < precision;
    }

    @Override
    public double getCartesianDistance(ICoordinate coordinate) {
        double differenceX = Math.pow(this.getX() - coordinate.asCartesianCoordinate().getX(), 2);
        double differenceY = Math.pow(this.getY() - coordinate.asCartesianCoordinate().getY(), 2);
        double differenceZ = Math.pow(this.getZ() - coordinate.asCartesianCoordinate().getZ(), 2);

        return Math.sqrt(differenceX + differenceY + differenceZ);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        double radius = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        return new SphericalCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(ICoordinate coordinate) {
        return this.asSphericalCoordinate().getCentralAngle(coordinate.asSphericalCoordinate());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ICoordinate)) {
            return false;
        }

        return isEqual((ICoordinate) object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean isEqual(ICoordinate coordinate) {
        return compareDoubles(this.getX(), coordinate.asCartesianCoordinate().getX()) &&
                compareDoubles(this.getY(), coordinate.asCartesianCoordinate().getY()) &&
                compareDoubles(this.getZ(), coordinate.asCartesianCoordinate().getZ());
    }

    private double getX() {
        return x;
    }

    private double getY() {
        return y;
    }

    private double getZ() {
        return z;
    }
}
