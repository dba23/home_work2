package Primitivs;

import java.util.Objects;

public class Point3D
{
    Coordinate _x,_y,_z;

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    public Coordinate get_x() {
        return _x;
    }

    public void set_x(Coordinate _x) {
        this._x = _x;
    }

    public Coordinate get_y() {
        return _y;
    }

    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    public Coordinate get_z() {
        return _z;
    }

    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    @Override
    public String toString() {
        return "x =" + _x +"\n_y=" + _y + "\n_z=" + _z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Objects.equals(_x, point3D._x) &&
                Objects.equals(_y, point3D._y) &&
                Objects.equals(_z, point3D._z);
    }
    public Point3D add(Vector vector)
    {
        Point3D newPoint;
        newPoint = new Point3D(new Coordinate(this.get_x().getCoordinate()+vector.getHead().get_x().getCoordinate()),
              new Coordinate(this.get_y().getCoordinate()+vector.getHead().get_y().getCoordinate()),
                new Coordinate( this.get_z().getCoordinate()+vector.getHead().get_z().getCoordinate()));
        return newPoint;
    }
    public Vector subtract(Point3D other)
    {
        return new Vector(new Point3D(new Coordinate(this.get_x().getCoordinate()-other.get_x().getCoordinate()),
                new Coordinate(this.get_y().getCoordinate()-other.get_y().getCoordinate()),
                new Coordinate(this.get_z().getCoordinate()-other.get_z().getCoordinate())));

    }
    public double distant(Point3D other)
    {
        return Math.sqrt(Math.pow(this.get_x().getCoordinate()-other.get_x().getCoordinate(),2)+
                Math.pow(this.get_y().getCoordinate()-other.get_y().getCoordinate(),2)+
                Math.pow(this.get_z().getCoordinate()-other.get_z().getCoordinate(),2));
    }

}
