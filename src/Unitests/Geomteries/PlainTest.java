package Unitests.Geomteries;

import Geomteries.Plain;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlainTest {
    @Test
    public void testGetNormalPoint3D() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plain pl = new Plain(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
//        assertEquals( new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)),"Bad normal to plane");
    }

    @Test
    public void testfindIntersectionsRay() {
        Plain pl = new Plain(new Point3D(0, 0, 1), new Vector(1, 1, 1));

        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray into plane
        assertEquals( Util.listOf(new Point3D(1, 0, 0)),
                pl.findIntersections(new Ray(new Point3D(0.5, 0, 0), new Vector(1, 0, 0))),"Bad plane intersection");

        // TC02: Ray out of plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(1, 0, 0))),"Must not be plane intersection");

        // =============== Boundary Values Tests ==================
        // TC11: Ray parallel to plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(0, 1, -1))),"Must not be plane intersection");

        // TC12: Ray in plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(0, 0.5, .5), new Vector(0, 1, -1))),"Must not be plane intersection");


        // TC13: Orthogonal ray into plane
//        assertEquals( Util.listOf( new Point3D(1d / 3, 1d / 3, 1d / 3)),
//                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(-1, -1, -1))),"Bad plane intersection");

        // TC14: Orthogonal ray out of plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(1, 1, 1))),"Must not be plane intersection");

        // TC15: Orthogonal ray out of plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(1, 1, 1))),"Must not be plane intersection");

        // TC16: Orthogonal ray from plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(1, 1, 1))),"Must not be plane intersection");

        // TC17: Ray from plane
        assertNull(
                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(1, 1, 0))),"Must not be plane intersection");

        // TC18: Ray from plane's Q point
//        assertNull(
//                pl.findIntersections(new Ray(new Point3D(0, 0, 1), new Vector(1, 1, 0))),"Must not be plane intersection");

    }


}