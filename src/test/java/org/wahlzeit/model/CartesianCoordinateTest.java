package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinate.CartesianCoordinate;
import org.wahlzeit.model.coordinate.SphericalCoordinate;

public class CartesianCoordinateTest {
    private CartesianCoordinate coordinate;

    @Before
    public void setUp() {
        coordinate = CartesianCoordinate.getCoordinate(1, 2, 3);
    }

    @Test
    public void testGetDistanceWithPositiveCoordinates() {
        CartesianCoordinate newCoordinate = CartesianCoordinate.getCoordinate(1, 2, 5);
        double distance = coordinate.getCartesianDistance(newCoordinate);

        Assert.assertEquals(2, distance, 0.0);
    }

    @Test
    public void testGetDistanceWithNegativeCoordinates() {
        CartesianCoordinate newCoordinate = CartesianCoordinate.getCoordinate(-1, -2, -1);
        double distance = coordinate.getCartesianDistance(newCoordinate);

        Assert.assertEquals(6, distance, 0.0);
    }

    @Test
    public void testGetDistanceWithEqualCoordinates() {
        CartesianCoordinate newCoordinate = CartesianCoordinate.getCoordinate(1, 2, 3);
        double distance = coordinate.getCartesianDistance(newCoordinate);

        Assert.assertEquals(0, distance, 0.0);
    }

    @Test
    public void testEqualsWithEqualCoordinates() {
        CartesianCoordinate equalCoordinate = CartesianCoordinate.getCoordinate(1, 2, 3);
        boolean isEqual = coordinate.equals(equalCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferentCoordinates() {
        CartesianCoordinate differentCoordinate = CartesianCoordinate.getCoordinate(1, 2, 4);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceSmallerThanDelta() {
        CartesianCoordinate differentCoordinate = CartesianCoordinate.getCoordinate(1, 2, 3.0000000009);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceEqualsDelta() {
        CartesianCoordinate differentCoordinate = CartesianCoordinate.getCoordinate(1, 2, 3.000000001);
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
        CartesianCoordinate differentCoordinate = CartesianCoordinate.getCoordinate(1, 2, 3);
        Assert.assertEquals(coordinate.hashCode(), differentCoordinate.hashCode());
    }

    @Test
    public void testHashcodeWithDifferentCoordinates() {
        CartesianCoordinate differentCoordinate = CartesianCoordinate.getCoordinate(1, 2, 4);
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
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getCoordinate(2, 3, 4);
        SphericalCoordinate sphericalCoordinate = coordinate.asSphericalCoordinate();
        boolean isEqual = cartesianCoordinate.equals(sphericalCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCartesianCoordinatesWithXIsNaN() {
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getCoordinate(Double.NaN, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCartesianCoordinatesWithXYIsNaN() {
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getCoordinate(0, Double.NaN, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCartesianCoordinatesWithZIsNaN() {
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getCoordinate(0, 0, Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceWithNull() {
        coordinate.getCartesianDistance(null);
    }
}
