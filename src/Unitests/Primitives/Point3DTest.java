package Unitests.Primitives;

import Primitives.Point3D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Point3DTest {

    @Test
    public void testConstructor() {
        Point3D p1 = new Point3D(1,0,0);
        assertEquals("Point3D{_x=Coordinate{_coordinate=1.0}, _y=Coordinate{_coordinate=0.0}, _z=Coordinate{_coordinate=0.0}}", p1.toString());
    }
}