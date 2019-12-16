package org.wahlzeit.model;

import net.bytebuddy.build.ToStringPlugin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinate.CartesianCoordinate;
import org.wahlzeit.model.coordinate.ICoordinate;
import org.wahlzeit.model.coordinate.SphericalCoordinate;

public class SphericalCoordinateTest {
    private SphericalCoordinate coordinate;

    @Before
    public void setUp() {
        coordinate = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
    }

    @Test
    public void testEqualsWithEqualCoordinates() {
        SphericalCoordinate equalCoordinate = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
        boolean isEqual = coordinate.equals(equalCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferentCoordinates() {
        SphericalCoordinate differentCoordinate = SphericalCoordinate.getCoordinate(Math.toRadians(46), Math.toRadians(45), 6360);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceSmallerThanDelta() {
        SphericalCoordinate differentCoordinate = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360.0000000009);
        boolean isEqual = coordinate.equals(differentCoordinate);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testEqualsWithDifferenceEqualsDelta() {
        SphericalCoordinate differentCoordinate = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360.000000001);
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
        SphericalCoordinate equalCoordinates = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
        Assert.assertEquals(coordinate.hashCode(), equalCoordinates.hashCode());
    }

    @Test
    public void testHashcodeWithDifferentCoordinates() {
        SphericalCoordinate differentCoordinate = SphericalCoordinate.getCoordinate(Math.toRadians(46), Math.toRadians(45), 6360);
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
        SphericalCoordinate sphericalCoordinate = SphericalCoordinate.getCoordinate(Math.toRadians(46), Math.toRadians(45), 6360);
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        boolean isEqual = cartesianCoordinate.equals(sphericalCoordinate);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void testGetCentralAngle() {
        SphericalCoordinate sphericalCoordinateBerlin = SphericalCoordinate.getCoordinate(Math.toRadians(52.517), Math.toRadians(13.40), 6360);
        SphericalCoordinate sphericalCoordinateTokyo = SphericalCoordinate.getCoordinate(Math.toRadians(35.70), Math.toRadians(139.767), 6360);

        double centralAngle = sphericalCoordinateBerlin.getCentralAngle(sphericalCoordinateTokyo);
        Assert.assertEquals(1.40, centralAngle, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSphericalCoordinateWithInvalidRadius() {
        SphericalCoordinate sphericalCoordinateBerlin = SphericalCoordinate.getCoordinate(Math.toRadians(52.517), Math.toRadians(13.40), -1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSphericalCoordinateWithInvalidPhi() {
        SphericalCoordinate sphericalCoordinateBerlin = SphericalCoordinate.getCoordinate(Math.PI * 3, Math.toRadians(13.40), 6360);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSphericalCoordinateWithInvalidTheta() {
        SphericalCoordinate sphericalCoordinateBerlin = SphericalCoordinate.getCoordinate(Math.toRadians(52.517), Math.PI * 2, 6360);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCentralAngelWithNull() {
        coordinate.getCentralAngle(null);
    }

    @Test
    public void testInterchangeabilityWithValueObjectPattern(){
        ICoordinate coordinate = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);
        ICoordinate coordinate2 = SphericalCoordinate.getCoordinate(Math.toRadians(45), Math.toRadians(45), 6360);

        // Konvertieren zwischen den Koordinatenimplementationen erzeugt keine unnötigen Objekte
        coordinate = coordinate.asCartesianCoordinate();
        coordinate = coordinate.asSphericalCoordinate();
        coordinate = coordinate.asCartesianCoordinate();
        coordinate = coordinate.asSphericalCoordinate();
        coordinate = coordinate.asCartesianCoordinate();
        Assert.assertEquals(coordinate, coordinate2.asCartesianCoordinate());
    }
}