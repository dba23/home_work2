package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class SpotLight extends PointalLight {
    Vector dir;

    public SpotLight(Color intensity, Point3D pos, double kC, double kL, double kQ, Vector dir) {
        super(intensity, pos, kC, kL, kQ);
        this.dir = dir;
    }

    public Vector getDir() {
        return dir;
    }

    public void setDir(Vector dir) {
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpotLight)) return false;
        if (!super.equals(o)) return false;
        SpotLight spotLight = (SpotLight) o;
        return Objects.equals(getDir(), spotLight.getDir());
    }

    @Override
    public String toString() {
        return "SpotLight{" +
                "dir=" + dir +
                '}';
    }

    @Override
    public Color getIntensity(Point3D point3D) {

        int r = Math.min(255,Math.max((int) (super.getIntensity(point3D).getRed() * Math.max(0,this.dir.dotProduct(point3D.subtract(this.pos).normalized()))),0));
        int g = Math.min(255,Math.max((int) (super.getIntensity(point3D).getGreen() * Math.max(0,this.dir.dotProduct(point3D.subtract(this.pos).normalized()))),0));
        int b = Math.min(255,Math.max((int) (super.getIntensity(point3D).getBlue() * Math.max(0,this.dir.dotProduct(point3D.subtract(this.pos).normalized()))),0));
        Color c =  new Color(r,g,b);

        System.out.println(c);



        System.out.println((point3D.subtract(this.pos)));
        return c;
    }

    @Override
    public Vector getL(Point3D point3D) {
        return super.getL(point3D);
    }
}
