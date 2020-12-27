package elements;

import primitivs.Point3D;
import primitivs.Ray;
import primitivs.Vector;

import java.util.Objects;

public class Camera {
    Point3D _P0;
    Vector _vup;
    Vector _vright;
    Vector _vtoward;

    //constructors
    public Camera(Point3D _P0, Vector _vup, Vector _vright, Vector _vtoward) {
        this._P0 = _P0;
        this._vup = _vup.normalize();
        this._vright = _vright.normalize();
        this._vtoward = _vtoward.normalize();
    }

    public Camera(Point3D _P0, Vector _vtoward, Vector _vup) {
        this._P0 = _P0;
        this._vup = _vup;
        this._vtoward = _vtoward;
        this._vright=_vtoward.crossProduct(_vup);
    }

    //getters and setters

    public Point3D get_P0() {
        return _P0;
    }

    public void set_P0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector get_vup() {
        return _vup;
    }

    public void set_vup(Vector _vup) {
        this._vup = _vup;
    }

    public Vector get_vright() {
        return _vright;
    }

    public void set_vright(Vector _vright) {
        this._vright = _vright;
    }

    public Vector get_vtoward() {
        return _vtoward;
    }

    public void set_vtoward(Vector _vtoward) {
        this._vtoward = _vtoward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(_P0, camera._P0) &&
                Objects.equals(_vup, camera._vup) &&
                Objects.equals(_vright, camera._vright) &&
                Objects.equals(_vtoward, camera._vtoward);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "_P0=" + _P0 +
                ", _vup=" + _vup +
                ", _vright=" + _vright +
                ", _vtoward=" + _vtoward +
                '}';
    }

    public Ray constructRayThroughPixel(
            int nX,int nY,double j, double i, double screenDist, double screenWidth,double screenHight ){

        Point3D Pc,pixelCenter;
        Vector rayMiddle,newVright,newVup,vRightSubvUp;
        Pc = get_P0().add(_vtoward.scale(screenDist));//image center
        double Rx,Ry, x, y;
        Rx = screenWidth/nX;
        Ry = screenHight/nY;
        //	Ratio of x(width) y(Height)
        y = nY - 1;
        x = nX - 1;
        y = (j - (y/2))*Ry;
        x = (i - (x/2))*Rx;
        newVright =  _vright.scale(y);//vRight*y
        newVup = _vup.scale(x);//vUp*x
        vRightSubvUp = newVright.subtract(newVup);//vRight*y-vUp*x
        pixelCenter = Pc.add(vRightSubvUp);//pixel[i,j]
        rayMiddle = pixelCenter.subtract(get_P0());//V[i,j]
        return new Ray(get_P0(),rayMiddle.normalize());

    }
}

