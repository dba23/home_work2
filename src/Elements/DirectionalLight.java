package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public class DirectionalLight extends Light {
    Vector direction;

    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    @Override
    public Color getIntensity(Point3D point3D) {

    }

    @Override
    public Vector getL(Point3D point3D) {
        return null;
    }

    @Override
    public String toString() {
        return "DirectionalLight{" +
                "direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectionalLight)) return false;
        if (!super.equals(o)) return false;
        DirectionalLight that = (DirectionalLight) o;
        return Objects.equals(getDirection(), that.getDirection());
    }
}
