import Geomteries.Plain;
import Geomteries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class main {
    public static void main(String[] args) {
        Triangle tr = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));

        Plain pl = new Plain(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        System.out.println(pl);
        Ray ray;
        // ============ Equivalence Partitions Tests ==============
        // TC01: Inside triangle
        ray = new Ray(new Point3D(1, 1, 1), new Vector(-1, -1, -1));
        //System.out.println(tr.findIntersections(ray));
    }
}
