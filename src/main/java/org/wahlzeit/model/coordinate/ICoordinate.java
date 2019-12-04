package org.wahlzeit.model.coordinate;

import com.sun.istack.internal.NotNull;

public interface ICoordinate {
    CartesianCoordinate asCartesianCoordinate();

    double getCartesianDistance(@NotNull ICoordinate coordinate);

    SphericalCoordinate asSphericalCoordinate();

    double getCentralAngle(@NotNull ICoordinate coordinate);

    boolean isEqual(ICoordinate coordinate);
}
