package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SphericalCoordinateTest {
    private SphericalCoordinate coordinate;

    @Before
    public void setUp() {
        coordinate = new SphericalCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
    }

    @Test
    public void testEqualsWithEqualCoordinates() {
        SphericalCoordinate equalCoordinate = new SphericalCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
        boolean isEqual = coordinate.equals(equalCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferentCoordinates() {
        SphericalCoordinate differentCoordinate = new SphericalCoordinate(Math.toRadians(46), Math.toRadians(45), 6360);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceSmallerThanDelta() {
        SphericalCoordinate differentCoordinate = new SphericalCoordinate(Math.toRadians(45), Math.toRadians(45), 6360.0000000009);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceEqualsDelta() {
        SphericalCoordinate differentCoordinate = new SphericalCoordinate(Math.toRadians(45), Math.toRadians(45), 6360.000000001);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithFalseObject() {
        boolean isEqual = coordinate.equals(new Object());
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithNull() {
        //noinspection ConstantConditions
        boolean isEqual = coordinate.equals(null);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testHashcodeWithEqualCoordinates() {
        SphericalCoordinate equalCoordinates = new SphericalCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
        Assert.assertEquals(coordinate.hashCode(), equalCoordinates.hashCode());
    }

    @Test
    public void testHashcodeWithDifferentCoordinates() {
        SphericalCoordinate differentCoordinate = new SphericalCoordinate(Math.toRadians(46), Math.toRadians(45), 6360);
        Assert.assertNotEquals(coordinate.hashCode(), differentCoordinate.hashCode());
    }

    @Test
    public void testIsEqualIsSuccessfulWithInterchangeableCoordinateTypes() {
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        boolean isEqual = coordinate.equals(cartesianCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testIsEqualFailedWithInterchangeableCoordinateTypes() {
        SphericalCoordinate sphericalCoordinate = new SphericalCoordinate(Math.toRadians(46), Math.toRadians(45), 6360);
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        boolean isEqual = cartesianCoordinate.equals(sphericalCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void test() {
        SphericalCoordinate sphericalCoordinateBerlin = new SphericalCoordinate(Math.toRadians(52.517), Math.toRadians(13.40), 6360);
        SphericalCoordinate sphericalCoordinateTokio = new SphericalCoordinate(Math.toRadians(35.70), Math.toRadians(139.767), 6360);

        double centralAngle = sphericalCoordinateBerlin.getCentralAngle(sphericalCoordinateTokio);
        Assert.assertEquals(1.40, centralAngle, 0.001);
    }

}