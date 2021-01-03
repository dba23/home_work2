package Unitests.Primitives;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RayTest {

    @Test
    public void testConstructor() {
        Ray ray = new Ray(new Point3D(1,0,0), new Vector(new Point3D(1,1,0)));
        assertEquals("Ray{_P00=Point3D{_x=Coordinate{_coordinate=1.0}, _y=Coordinate{_coordinate=0.0}, _z=Coordinate{_coordinate=0.0}}, _direction=Vector{_head=Point3D{_x=Coordinate{_coordinate=1.0}, _y=Coordinate{_coordinate=1.0}, _z=Coordinate{_coordinate=0.0}}}}",ray.toString());
    }
}
