package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {
    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Coordinate)) {
            return false;
        }

        return isEqual((Coordinate) object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    private boolean isEqual(Coordinate coordinate) {
        if (compareDoubles(this.getX(), coordinate.getX()) &&
                compareDoubles(this.getY(), coordinate.getY()) &&
                compareDoubles(this.getZ(), coordinate.getZ())) {
            return true;
        }
        return false;
    }

    private boolean compareDoubles(double firstValue, double secondValue) {
        double precision = 0.000000001;
        return Math.abs(firstValue - secondValue) < precision;
    }


    public double getDistance(Coordinate coordinate) {
        double differenceX = Math.pow(this.getX() - coordinate.getX(), 2);
        double differenceY = Math.pow(this.getY() - coordinate.getY(), 2);
        double differenceZ = Math.pow(this.getZ() - coordinate.getZ(), 2);

        return Math.sqrt(differenceX + differenceY + differenceZ);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
