package org.wahlzeit.model;

public abstract class AbstractCoordinate implements ICoordinate {

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    @Override
    public double getCartesianDistance(ICoordinate coordinate) {
        return doGetCartesianDistance(coordinate);
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        return doAsSphericalCoordinate();
    }

    @Override
    public double getCentralAngle(ICoordinate coordinate) {
        return doGetCentralAngle(coordinate);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ICoordinate)) {
            return false;
        }

        return isEqual((ICoordinate) object);
    }

    @Override
    public boolean isEqual(ICoordinate coordinate) {
        return doIsEqual(coordinate);
    }

    protected boolean compareDoubles(double firstValue, double secondValue) {
        double precision = 0.000000001;
        return Math.abs(firstValue - secondValue) < precision;
    }

    protected abstract CartesianCoordinate doAsCartesianCoordinate();

    protected abstract SphericalCoordinate doAsSphericalCoordinate();

    protected abstract double doGetCentralAngle(ICoordinate coordinate);

    protected abstract double doGetCartesianDistance(ICoordinate coordinate);

    protected abstract boolean doIsEqual(ICoordinate coordinate);
}
