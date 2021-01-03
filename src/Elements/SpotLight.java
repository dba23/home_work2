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
}
