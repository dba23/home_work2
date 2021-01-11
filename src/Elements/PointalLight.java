package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.Objects;

public abstract class PointalLight extends Light {
    Point3D pos;
    double kC,kL,kQ;

    public PointalLight(Color intensity, Point3D pos, double kC, double kL, double kQ) {
        super(intensity);
        this.pos = pos;
        this.kC = kC;
        this.kL = kL;
        this.kQ = kQ;
    }

    public Point3D getPos() {
        return pos;
    }

    public void setPos(Point3D pos) {
        this.pos = pos;
    }

    public double getkC() {
        return kC;
    }

    public void setkC(double kC) {
        this.kC = kC;
    }

    public double getkL() {
        return kL;
    }

    public void setkL(double kL) {
        this.kL = kL;
    }

    public double getkQ() {
        return kQ;
    }

    public void setkQ(double kQ) {
        this.kQ = kQ;
    }

    @Override
    public Color getIntensity(Point3D point3D) {

        System.out.println(this.intensity.getRGB()/(this.kC+(this.kL*point3D.distance(this.pos))+(this.kQ*Math.pow(point3D.distance(this.pos),2))));
        System.out.println(this.intensity.getBlue());
        return new Color((int)(this.intensity.getRed()/(this.kC+(this.kL*point3D.distance(this.pos))+(this.kQ*Math.pow(point3D.distance(this.pos),2)))),(int)(this.intensity.getGreen()/(this.kC+(this.kL*point3D.distance(this.pos))+(this.kQ*Math.pow(point3D.distance(this.pos),2)))),(int)(this.intensity.getBlue()/(this.kC+(this.kL*point3D.distance(this.pos))+(this.kQ*Math.pow(point3D.distance(this.pos),2)))));
    }

    @Override
    public Vector getL(Point3D point3D) {
        return point3D.subtract(this.pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointalLight)) return false;
        if (!super.equals(o)) return false;
        PointalLight that = (PointalLight) o;
        return Double.compare(that.getkC(), getkC()) == 0 &&
                Double.compare(that.getkL(), getkL()) == 0 &&
                Double.compare(that.getkQ(), getkQ()) == 0 &&
                Objects.equals(getPos(), that.getPos());
    }
}
