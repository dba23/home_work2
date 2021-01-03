package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public abstract class Light  {

    Color intensity;

    public Light(Color intensity) {
        this.intensity = intensity;
    }
    public abstract Color getIntensity(Point3D point3D);
    public abstract Vector getL(Point3D point3D);
    public Color getIntensity() {
        return intensity;
    }

    public void setIntensity(Color intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "Light{" +
                "intensity=" + intensity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Light)) return false;
        Light light = (Light) o;
        return Objects.equals(getIntensity(), light.getIntensity());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
