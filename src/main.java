import Elements.SpotLight;
import Geomteries.Plain;
import Geomteries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        SpotLight spotLight = new SpotLight(new Color(255, 0, 2), new Point3D(-200, 200, -250),  1, 0.00001, 0.000005,new Vector(3,-1,2));
        spotLight.getIntensity(new Point3D(1,2,3));

    }
}
