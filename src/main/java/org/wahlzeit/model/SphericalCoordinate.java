package org.wahlzeit.model;

import java.util.Objects;

public class SphericalCoordinate implements ICoordinate {
    private double phi;
    private double theta;
    private double radius;

    public SphericalCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
      /*  double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return new CartesianCoordinate(x, y, z);*/
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(ICoordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(ICoordinate coordinate) {
        return Math.acos((Math.sin(phi) *
                Math.sin(coordinate.asSphericalCoordinate().getPhi()) + Math.cos(phi) *
                Math.cos(coordinate.asSphericalCoordinate().getPhi()) *
                Math.cos(coordinate.asSphericalCoordinate().getTheta() - (theta))));
    }

    @Override
    public boolean isEqual(ICoordinate coordinate) {
        return compareDoubles(this.getPhi(), coordinate.asSphericalCoordinate().getPhi()) &&
                compareDoubles(this.getTheta(), coordinate.asSphericalCoordinate().getTheta()) &&
                compareDoubles(this.getRadius(), coordinate.asSphericalCoordinate().getRadius());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ICoordinate)) {
            return false;
        }

        return isEqual((ICoordinate) object);
    }

    private boolean compareDoubles(double firstValue, double secondValue) {
        double precision = 0.000000001;
        return Math.abs(firstValue - secondValue) < precision;
    }

    private double getPhi() {
        return phi;
    }

    private double getTheta() {
        return theta;
    }

    private double getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phi, theta, radius);
    }
}
