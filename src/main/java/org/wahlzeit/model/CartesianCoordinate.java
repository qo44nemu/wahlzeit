package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {
    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    protected CartesianCoordinate doAsCartesianCoordinate() {
        return this;
    }

    @Override
    protected SphericalCoordinate doAsSphericalCoordinate() {
        double radius = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        return new SphericalCoordinate(phi, theta, radius);
    }

    @Override
    protected double doGetCentralAngle(ICoordinate coordinate) {
        return this.asSphericalCoordinate().getCentralAngle(coordinate.asSphericalCoordinate());
    }

    @Override
    protected double doGetCartesianDistance(ICoordinate coordinate) {
        double differenceX = Math.pow(this.getX() - coordinate.asCartesianCoordinate().getX(), 2);
        double differenceY = Math.pow(this.getY() - coordinate.asCartesianCoordinate().getY(), 2);
        double differenceZ = Math.pow(this.getZ() - coordinate.asCartesianCoordinate().getZ(), 2);

        return Math.sqrt(differenceX + differenceY + differenceZ);
    }

    @Override
    protected boolean doIsEqual(ICoordinate coordinate) {
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
