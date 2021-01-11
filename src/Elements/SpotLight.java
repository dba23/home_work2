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

        int r = (int) (super.getIntensity(point3D).getRed() * Math.max(0,this.dir.dotProduct(getL(point3D).normalized())));
        int g = (int) (super.getIntensity(point3D).getGreen() * Math.max(0,this.dir.dotProduct(getL(point3D).normalized())));
        int b = (int) (super.getIntensity(point3D).getBlue() * Math.max(0,this.dir.dotProduct(getL(point3D).normalized())));
        Color c =  Light.intensityFix(r,g,b);


        return c;
    }

    @Override
    public Vector getL(Point3D point3D) {
        return super.getL(point3D);
    }
}
