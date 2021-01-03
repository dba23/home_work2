package Primitives;

import java.util.Objects;

public class Ray extends Vector  implements Cloneable {
    private Point3D _P00;
    private Vector _direction;


    public Ray() {
        super();
        this._P00 = new Point3D();
    }

    public Ray(Point3D p00, Vector direction) {
        this._direction = direction.normalized();
        this._P00 = p00;
    }

    public Ray(Ray ray) {
        super(ray.get_direction());
        this._P00 = ray.get_P00();
    }

    public Point3D get_P00() {
        return _P00;
    }

    public void set_P00(Point3D _P00) {
        this._P00 = _P00;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(_P00, ray._P00) &&
                Objects.equals(_direction, ray._direction);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_P00=" + _P00 +
                ", _direction=" + _direction +
                '}';
    }


}
