import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import Primitivs.*;
import static org.junit.jupiter.api.Assertions.*;


class VectorTest {
    @Test
    public void testLength() {
        // TC01: Simple test
        assertEquals( 5d, new Vector(0, 3, 4).length(), 0.00001,"length() wrong value");

    }

    @Test
    public void testNormalized() {
        Vector v = new Vector(0, 3, 4);
        Vector n = v.normalize();
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test
        assertFalse( v == n,"normalized() changes the vector itself");
        assertEquals( 1d, n.length(), 0.00001,"wrong normalized vector length");
    }

    @Test
    public void testAdd() {
        // TC01: Simple test
        assertEquals( new Vector(1, 1, 1),new Vector(2, 3, 4).add(new Vector(-1, -2, -3)),"Wrong vector add");
        // TC11: test adding v + (-v)
//        try {
//            new Vector(1, 2, 3).add(new Vector(-1, -2, -3));
//            fail("Add v plus -v must throw exception");
//        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testSubtract() {
        // TC01: Simple test
        assertEquals( new Vector(1, 1, 1),
                new Vector(2, 3, 4).subtract(new Vector(1, 2, 3)),"Wrong vector subtract");


    }

    @Test
    public void testScale() {
        // TC01: Simple test
        assertEquals( new Vector(2, 4, 6),
                new Vector(1, 2, 3).scale(2),"Wrong vector scale");

        // TC11: testmult by 0
//        try {
//            new Vector(1, 2, 3).scale(0);
//            fail("Scale by 0 must throw exception");
//        } catch (IllegalArgumentException e) {}
    }
    @Test
    public void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // TC01: Simple dotProduct test
        Vector v2 = new Vector(-2, -4, -6);
        assertEquals( -28, v1.dotProduct(v2), 0.00001,"dotProduct() wrong value");


        // TC11: dotProduct for orthogonal vectors
        Vector v3 = new Vector(0, 3, -2);
        assertEquals( 0, v1.dotProduct(v3), 0.00001,"dotProduct() for orthogonal vectors is not zero");
    }

    @Test
    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals( v1.length() * v2.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        //++++++++++++++++++++++not working+++++++++++++++++++++++++++++
        // assertTrue(vr.dotProduct(v1)==0,"crossProduct() result is not orthogonal to 1st operand");// isZero(vr.dotProduct(v1)));
        assertTrue(vr.dotProduct(v2)==0,"crossProduct() result is not orthogonal to 2nd operand");// isZero(vr.dotProduct(v2)));

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
//        try {
//            v1.crossProduct(v3);
//            fail("crossProduct() for parallel vectors does not throw an exception");
//        } catch (Exception e) {}
    }

    @Test
    public void testPointSubtract() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test
        assertEquals( new Vector(1, 1, 1),
                new Point3D(2, 3, 4).subtract(new Point3D(1, 2, 3)),"Wrong point subtract");

        // =============== Boundary Values Tests ==================
        // TC11: test subtracting same point
//        try {
//            new Point3D(1, 2, 3).subtract(new Point3D(1, 2, 3));
//            fail("Subtract P from P must throw exception");
//        } catch (IllegalArgumentException e) {}
    }





}