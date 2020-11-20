package Elements;

import Primitivs.Point3D;
import Primitivs.Ray;
import Primitivs.Vector;

import java.util.Objects;

public class Camera {
    Point3D _P0;
    Vector _vup;
    Vector _vright;
    Vector _vtoward;

    //constructors
    public Camera(Point3D _P0, Vector _vup, Vector _vright, Vector _vtoward) {
        this._P0 = _P0;
        this._vup = _vup;
        this._vright = _vright;
        this._vtoward = _vtoward;
    }

    public Camera(Point3D _P0, Vector _vup, Vector _vtoward) {
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
        Point3D Pc=get_P0().add(_vtoward.scale(screenDist));
        double Ry=screenHight/nY;
        double Rx=screenWidth/nX;
        double Yi=(i-nY/2)*Ry+Ry/2;
        double Xj=(j-nX/2)*Rx+Rx/2;
        //Point3D Pij=Pc.add((_vright.scale(Xj)).subtract((_vup.scale(Yi))));
        Point3D Pij=Pc.add((_vright.scale((j-(nX-1)/2)*Rx)).subtract(_vup.scale((i-(nY-1)/2)*Ry)));
        Vector Vij=Pij.subtract(_P0);

        return new Ray(_P0,Vij.normalize());
    }
}

