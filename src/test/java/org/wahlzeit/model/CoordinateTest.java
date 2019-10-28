package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
    private Coordinate coordinate;

    @Before
    public void setUp() {
        coordinate = new Coordinate(1, 2, 3);
    }

    @Test
    public void testGetDistanceWithPositiveCoordinates() {
        Coordinate newCoordinate = new Coordinate(1, 2, 5);
        double distance = coordinate.getDistance(newCoordinate);

        Assert.assertEquals(2, distance, 0.0);
    }

    @Test
    public void testGetDistanceWithNegativeCoordinates() {
        Coordinate newCoordinate = new Coordinate(-1, -2, -1);
        double distance = coordinate.getDistance(newCoordinate);

        Assert.assertEquals(6, distance, 0.0);
    }

    @Test
    public void testGetDistanceWithEqualCoordinates() {
        Coordinate newCoordinate = new Coordinate(1, 2, 3);
        double distance = coordinate.getDistance(newCoordinate);

        Assert.assertEquals(0, distance, 0.0);
    }

    @Test
    public void testEqualsWithEqualCoordinates() {
        Coordinate equalCoordinate = new Coordinate(1, 2, 3);
        boolean isEqual = coordinate.equals(equalCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferentCoordinates() {
        Coordinate differentCoordinate = new Coordinate(1, 2, 4);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceSmallerThanDelta() {
        Coordinate differentCoordinate = new Coordinate(1, 2, 3.0000000009);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceEqualsDelta() {
        Coordinate differentCoordinate = new Coordinate(1, 2, 3.000000001);
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
        Coordinate differentCoordinate = new Coordinate(1, 2, 3);
        Assert.assertEquals(coordinate.hashCode(), differentCoordinate.hashCode());
    }

    @Test
    public void testHashcodeWithDifferentCoordinates() {
        Coordinate differentCoordinate = new Coordinate(1, 2, 4);
        Assert.assertNotEquals(coordinate.hashCode(), differentCoordinate.hashCode());
    }
}
