package org.wahlzeit.model.coordinate;

import java.util.HashMap;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private static final HashMap<Integer, CartesianCoordinate> coordinates = new HashMap<>();

    private double x;
    private double y;
    private double z;

    private CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
        assertIsNotNaN(x);
        assertIsNotNaN(y);
        assertIsNotNaN(z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static CartesianCoordinate getCoordinate(double x, double y, double z) {
        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
        Integer hashCode = coordinate.hashCode();
            CartesianCoordinate existingCoordinate = coordinates.get(hashCode);
            if (existingCoordinate == null) {
                coordinates.put(coordinate.hashCode(), coordinate);
                return coordinate;
            } else {
                return existingCoordinate;
            }
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
        return SphericalCoordinate.getCoordinate(phi, theta, radius);
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

    private void assertIsNotNaN(double value) throws IllegalArgumentException {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value can not be Not a Number!");
        }
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

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

}
