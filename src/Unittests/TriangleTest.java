
import geometries.*;
import org.junit.jupiter.api.Test;
import primitivs.Point3D;
import primitivs.Ray;
import primitivs.Vector;
import primitivs.*;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle tr1=new Triangle();
    @Test
    void testToString() {
        System.out.println(tr1);
    }

    @Test
    void testEquals() {
        Triangle tr2 = new Triangle(new Point3D(12, 10, 0), new Point3D(10, 2, 3), new Point3D(1, 6, 5));
        assertNotEquals(tr1, tr2);
    }
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Triangle triangle = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals(new Vector(sqrt3, sqrt3, sqrt3), triangle.getNormal(new Point3D(0, 0, 1)),
                "Bad normal to trinagle");
    }

      @Test
    public void testfindIntersectionsRay() {
        Triangle tr = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
          Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        Ray ray;
        // ============ Equivalence Partitions Tests ==============
        // TC01: Inside triangle
        ray = new Ray(new Point3D(1, 1, 1), new Vector(-1, -1, -1));
        assertEquals(Util.listOf(new Point3D(1d / 3, 1d / 3, 1d / 3)), tr.findIntersections(ray),
                "Bad intersection");

        // TC02: Against edge
        ray = new Ray(new Point3D(0, 0, -1), new Vector(1, 1, 0));
        assertEquals(Util.listOf(new Point3D(1, 1, -1)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray),"Bad intersection");

        // TC03: Against vertex
        ray = new Ray(new Point3D(0, 0, 2), new Vector(-1, -1, 0));
        assertEquals(Util.listOf(new Point3D(-0.5, -0.5, 2)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray),"Bad intersection");

        // =============== Boundary Values Tests ==================
        // TC11: In vertex
        ray = new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0));
        assertEquals(Util.listOf(new Point3D(0, 1, 0)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray),"Bad intersection");

        // TC12: On edge
        ray = new Ray(new Point3D(-1, -1, 0), new Vector(1, 1, 0));
        assertEquals(Util.listOf(new Point3D(0.5, 0.5, 0)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull( tr.findIntersections(ray),"Bad intersection");

        // TC13: On edge continuation
        ray = new Ray(new Point3D(-2, 0, 0), new Vector(1, 1, 0));
        assertEquals(Util.listOf(new Point3D(-0.5, 1.5, 0)), pl.findIntersections(ray),
                "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray),"Bad intersection");
    }

}