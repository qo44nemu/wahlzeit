package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {
    private CartesianCoordinate coordinate;

    @Before
    public void setUp() {
        coordinate = new CartesianCoordinate(1, 2, 3);
    }

    @Test
    public void testGetDistanceWithPositiveCoordinates() {
        CartesianCoordinate newCoordinate = new CartesianCoordinate(1, 2, 5);
        double distance = coordinate.getCartesianDistance(newCoordinate);

        Assert.assertEquals(2, distance, 0.0);
    }

    @Test
    public void testGetDistanceWithNegativeCoordinates() {
        CartesianCoordinate newCoordinate = new CartesianCoordinate(-1, -2, -1);
        double distance = coordinate.getCartesianDistance(newCoordinate);

        Assert.assertEquals(6, distance, 0.0);
    }

    @Test
    public void testGetDistanceWithEqualCoordinates() {
        CartesianCoordinate newCoordinate = new CartesianCoordinate(1, 2, 3);
        double distance = coordinate.getCartesianDistance(newCoordinate);

        Assert.assertEquals(0, distance, 0.0);
    }

    @Test
    public void testEqualsWithEqualCoordinates() {
        CartesianCoordinate equalCoordinate = new CartesianCoordinate(1, 2, 3);
        boolean isEqual = coordinate.equals(equalCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferentCoordinates() {
        CartesianCoordinate differentCoordinate = new CartesianCoordinate(1, 2, 4);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceSmallerThanDelta() {
        CartesianCoordinate differentCoordinate = new CartesianCoordinate(1, 2, 3.0000000009);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceEqualsDelta() {
        CartesianCoordinate differentCoordinate = new CartesianCoordinate(1, 2, 3.000000001);
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
        CartesianCoordinate differentCoordinate = new CartesianCoordinate(1, 2, 3);
        Assert.assertEquals(coordinate.hashCode(), differentCoordinate.hashCode());
    }

    @Test
    public void testHashcodeWithDifferentCoordinates() {
        CartesianCoordinate differentCoordinate = new CartesianCoordinate(1, 2, 4);
        Assert.assertNotEquals(coordinate.hashCode(), differentCoordinate.hashCode());
    }

    @Test
    public void testIsEqualWithDifferentCoordinateTypesSuccessfully() {
        SphericalCoordinate sphericalCoordinate = coordinate.asSphericalCoordinate();
        boolean isEqual = coordinate.equals(sphericalCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testIsEqualWithDifferentCoordinateTypesFailed() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(2, 3, 4);
        SphericalCoordinate sphericalCoordinate = coordinate.asSphericalCoordinate();
        boolean isEqual = cartesianCoordinate.equals(sphericalCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test(expected = AssertionError.class)
    public void testCartesianCoordinatesWithXIsNaN() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(Double.NaN, 0, 0);
    }

    @Test(expected = AssertionError.class)
    public void testCartesianCoordinatesWithXYIsNaN() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(0, Double.NaN, 0);
    }

    @Test(expected = AssertionError.class)
    public void testCartesianCoordinatesWithZIsNaN() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(0, 0, Double.NaN);
    }

    @Test(expected = AssertionError.class)
    public void testGetDistanceWithNull() {
        coordinate.getCartesianDistance(null);
    }
}
