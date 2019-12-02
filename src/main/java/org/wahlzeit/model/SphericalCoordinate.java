package org.wahlzeit.model;

import java.util.Objects;

public class SphericalCoordinate extends AbstractCoordinate {
    private double phi;
    private double theta;
    private double radius;

    public SphericalCoordinate(double phi, double theta, double radius) throws IllegalArgumentException {
        assertPhiIsValid(phi);
        assertThetaIsValid(theta);
        assertRadiusIsValid(radius);
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    @Override
    protected CartesianCoordinate doAsCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    protected SphericalCoordinate doAsSphericalCoordinate() {
        return this;
    }

    @Override
    protected double doGetCartesianDistance(ICoordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    protected double doGetCentralAngle(ICoordinate coordinate) {
        return Math.acos((Math.sin(phi) *
                Math.sin(coordinate.asSphericalCoordinate().getPhi()) + Math.cos(phi) *
                Math.cos(coordinate.asSphericalCoordinate().getPhi()) *
                Math.cos(coordinate.asSphericalCoordinate().getTheta() - (theta))));
    }

    @Override
    protected boolean doIsEqual(ICoordinate coordinate) {
        return compareDoubles(this.getPhi(), coordinate.asSphericalCoordinate().getPhi()) &&
                compareDoubles(this.getTheta(), coordinate.asSphericalCoordinate().getTheta()) &&
                compareDoubles(this.getRadius(), coordinate.asSphericalCoordinate().getRadius());
    }

    /*
      Wertebereiche für Sphärische Koordinaten https://universaldenker.de/formeln/650
   */
    private void assertPhiIsValid(double phi) throws IllegalArgumentException {
        if (phi < 0 || phi > (2 * Math.PI)) {
            throw new IllegalArgumentException("Illegal value for phi");
        }
    }

    private void assertThetaIsValid(double theta) throws IllegalArgumentException {
        if (theta < 0 || theta > Math.PI) {
            throw new IllegalArgumentException("Illegal value for theta");
        }
    }

    private void assertRadiusIsValid(double radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("Illegal value for radius");
        }
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
