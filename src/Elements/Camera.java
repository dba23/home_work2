package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.Objects;

public class Camera {
    private Point3D _P0;
    private Vector _vup;
    private Vector _vright;
    private Vector _vto;

    public Camera() {
        this._P0 = new Point3D();
        this._vup = new Vector(0,-1,0);
        this._vright = new Vector(1,0,0);
        this._vto = new Vector(0,0,1);
    }

    public Camera(Point3D _P0, Vector _vto, Vector _vup) {
        this._P0 = _P0;
        this._vup = _vup;
        this._vto = _vto;
        this._vright = this._vto.crossProduct(this._vup);
    }

    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {
        Point3D Pc = this._P0.add(this._vto.scale(screenDistance));
        double Ry = screenHeight/nY;
        double Rx = screenWidth/nX;
        double Xj = (j -((nX-1)/2.0))*Rx;
        double Yi = (i -((nY-1)/2.0))*Ry;

        Point3D pIJ = new Point3D(Pc);
        if (Xj != 0)
            pIJ = pIJ.add(this.get_vright().scale(Xj));
        if (Yi != 0)
            pIJ = pIJ.add(this.get_vup().scale(-Yi));
        Vector vij = pIJ.subtract(this.get_P0());
        return new Ray(this.get_P0() , vij.normalized());
    }

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

    public Vector get_vto() {
        return _vto;
    }

    public void set_vto(Vector _vto) {
        this._vto = _vto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(_P0, camera._P0) &&
                Objects.equals(_vup, camera._vup) &&
                Objects.equals(_vright, camera._vright) &&
                Objects.equals(_vto, camera._vto);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "_P0=" + _P0 +
                ", _vup=" + _vup +
                ", _vright=" + _vright +
                ", _vto=" + _vto +
                '}';
    }

}