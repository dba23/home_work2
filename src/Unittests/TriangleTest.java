import Geometries.Triangle;
import Primitivs.Coordinate;
import Primitivs.Point3D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Point3D p1=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
    Point3D p2=new Point3D(new Coordinate(5),new Coordinate(5),new Coordinate(0));
    Point3D p3=new Point3D(new Coordinate(10),new Coordinate(0),new Coordinate(0));
    Triangle triangle=new Triangle(p1,p2,p3);

    @Test
    void getP1() {
        System.out.println( triangle.getP1());
    }

    @Test
    void setP1() {
    }

    @Test
    void getP2() {
    }

    @Test
    void setP2() {
    }

    @Test
    void getP3() {
    }

    @Test
    void setP3() {
    }

    @Test
    void testToString() {
        System.out.println("printing triangle: \n"+triangle.toString());
    }
}