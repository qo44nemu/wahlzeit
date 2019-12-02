package org.wahlzeit.model;

public abstract class AbstractCoordinate implements ICoordinate {

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        CartesianCoordinate coordinate = doAsCartesianCoordinate();
        /*
        Check if result is valid
         */
        assertIsCoordinateValid(coordinate);

        return coordinate;
    }

    @Override
    public double getCartesianDistance(ICoordinate coordinate) {
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
        SphericalCoordinate coordinate = doAsSphericalCoordinate();
        /*
        Check if result is valid
         */
        assertIsCoordinateValid(coordinate);
        return coordinate;
    }

    @Override
    public double getCentralAngle(ICoordinate coordinate) {
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

    @Override
    public void assertClassInvariants() {
        doAssertClassInvariants();
    }

    protected boolean compareDoubles(double firstValue, double secondValue) {
        assert !Double.isNaN(firstValue);
        assert !Double.isNaN(secondValue);

        double precision = 0.000000001;
        return Math.abs(firstValue - secondValue) < precision;
    }

    private void assertIsCoordinateValid(ICoordinate coordinate) {
        assert coordinate != null;
    }

    protected void assertIsDistanceValid(double distance) {
        assert distance >= 0;
        assert !Double.isNaN(distance);
    }

    protected void assertIsCentralAngelValid(double centralAngel) {
        assert centralAngel > 0 ;
        assert centralAngel < (2 * Math.PI) ;
    }


    protected abstract void doAssertClassInvariants();

    protected abstract CartesianCoordinate doAsCartesianCoordinate();

    protected abstract SphericalCoordinate doAsSphericalCoordinate();

    protected abstract double doGetCentralAngle(ICoordinate coordinate);

    protected abstract double doGetCartesianDistance(ICoordinate coordinate);

    protected abstract boolean doIsEqual(ICoordinate coordinate);
}
