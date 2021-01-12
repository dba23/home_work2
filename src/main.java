import Elements.SpotLight;
import Geomteries.Plain;
import Geomteries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Renderer.Renderer;

import java.awt.*;

public class main {
    public static void main(String[] args) {
       Point3D p1 = new Point3D(70.0, -40.0, 1000);
        for (int i = -1000; i <1000 ; i++) {
            for (int j = -1000; j <1000 ; j++) {
                Point3D p2 = new Point3D(i,j,1000);
                if(p2.distance(p1)==300)
                    System.out.println(p2);
            }
        }
    }
}
