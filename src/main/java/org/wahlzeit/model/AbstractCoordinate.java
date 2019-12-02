package org.wahlzeit.model;

public abstract class AbstractCoordinate implements ICoordinate {

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    @Override
    public double getCartesianDistance(ICoordinate coordinate) throws IllegalArgumentException, IllegalStateException {
        /*
        Check if parameter coordinate is valid
         */
        assertIsCoordinateValid(coordinate);
        double distance = doGetCartesianDistance(coordinate);
        /*
        Check if distance is valid
         */
        assertIsDistanceValid(distance);
        return distance;
    }

    @Override
    public SphericalCoordinate asSphericalCoordinate() {
        return doAsSphericalCoordinate();
    }

    @Override
    public double getCentralAngle(ICoordinate coordinate) throws IllegalArgumentException, IllegalStateException {
       /*
        Check if parameter coordinate is valid
         */
        assertIsCoordinateValid(coordinate);
        double centralAngel = doGetCentralAngle(coordinate);
        /*
        Check if returned central angel is valid
         */
        assertIsCentralAngelValid(centralAngel);
        return centralAngel;
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
        if (Double.isNaN(firstValue) || Double.isNaN(secondValue)) {
            throw new IllegalArgumentException("Value can not be NaN!");
        }

        double precision = 0.000000001;
        return Math.abs(firstValue - secondValue) < precision;
    }

    private void assertIsCoordinateValid(ICoordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("Coordinate can not be null!");
        }
    }

    protected void assertIsDistanceValid(double distance) throws IllegalStateException {
        if (distance < 0 || Double.isNaN(distance)) {
            throw new IllegalStateException("Invalid distance!");
        }
    }

    protected void assertIsCentralAngelValid(double centralAngel) throws IllegalStateException {
        if (centralAngel < 0 || centralAngel > (2 * Math.PI) || Double.isNaN(centralAngel)) {
            throw new IllegalStateException("Invalid distance!");
        }
    }

    protected abstract CartesianCoordinate doAsCartesianCoordinate();

    protected abstract SphericalCoordinate doAsSphericalCoordinate();

    protected abstract double doGetCentralAngle(ICoordinate coordinate);

    protected abstract double doGetCartesianDistance(ICoordinate coordinate);

    protected abstract boolean doIsEqual(ICoordinate coordinate);
}
