package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class AmbientLight extends Light {
    double kA ;

    public AmbientLight(Color intensity,double kA  ) {
        super(intensity);
        this.kA = kA;
    }
    public AmbientLight(Color intensity){
        super(intensity);
        this.kA = 0.1;
    }

    public double getkA() {
        return kA;
    }

    public void setkA(double kA) {
        this.kA = kA;
    }

    @Override
    public Color getIntensity(Point3D point3D) {
        return new Color((int) (this.intensity.getRGB()*this.kA));
    }

    @Override
    public Vector getL(Point3D point3D) {
        return null;
    }


    @Override
    public String toString() {
        return "AmbientLight{" +
                "kA=" + kA +
                ", intensity=" + intensity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmbientLight)) return false;
        if (!super.equals(o)) return false;
        AmbientLight that = (AmbientLight) o;
        return Double.compare(that.getkA(), getkA()) == 0;
    }

}
