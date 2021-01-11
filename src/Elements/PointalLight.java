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
    public Color getIntensity(Point3D point) {
        int red = (int) (intensity.getRed());
        int green = (int) (intensity.getGreen());
        int blue = (int) (intensity.getBlue());
        double _d = this.pos.distance(point);
        double kRed = red/(kC + kL*_d + kQ*Math.pow(_d,2));
        double kGreen = green/(kC + kL*_d + kQ*Math.pow(_d,2));
        double kBlue = blue/(kC + kL*_d + kQ*Math.pow(_d,2));
        Color intensity = intensityFix((int) kRed,(int) kGreen,(int) kBlue);// fixing in case the color's rgb is out of limits
        return intensity;
    }

    @Override
    public Vector getL(Point3D point3D) {
        return this.pos.subtract(point3D).normalized();
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
