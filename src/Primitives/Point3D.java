package Primitives;

import java.util.Objects;

public class Point3D implements Cloneable {

        private Coordinate _x;
        private Coordinate _y;
        private Coordinate _z;
        public static Point3D ZERO = new Point3D();


        public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
            this._x = _x;
            this._y = _y;
            this._z = _z;
        }
        public Point3D(double _x, double _y, double _z) {
            this._x = new Coordinate(_x);
            this._y = new Coordinate(_y);
            this._z = new Coordinate(_z);
        }
        public Point3D(Point3D anotherPoint3D) {
            this._x = anotherPoint3D.get_x();
            this._y = anotherPoint3D.get_y();
            this._z = anotherPoint3D.get_z();
        }

        public Point3D() {
            this._x = new Coordinate();
            this._y = new Coordinate();
            this._z = new Coordinate();
        }

        public Point3D add(Vector v) {
            if (this.equals(v.scale(-1))) {
                throw new IllegalArgumentException("you can not do add vector + (-vector)");
            }
            Point3D tempPoint3D = new Point3D();
            tempPoint3D.set_x(new Coordinate(this.get_x().get_coordinate() + v.get_head().get_x().get_coordinate()));
            tempPoint3D.set_y(new Coordinate(this.get_y().get_coordinate() + v.get_head().get_y().get_coordinate()));
            tempPoint3D.set_z(new Coordinate(this.get_z().get_coordinate() + v.get_head().get_z().get_coordinate()));
            return tempPoint3D;
        }

        public Vector subtract(Point3D other) {
            if (this.equals(other)) {
                throw new IllegalArgumentException("you can not Substract the same vector)");
            }
            Vector tempVector = new Vector();
            tempVector.get_head().set_x(new Coordinate(this.get_x().get_coordinate() - other.get_x().get_coordinate()));
            tempVector.get_head().set_y(new Coordinate(this.get_y().get_coordinate() - other.get_y().get_coordinate()));
            tempVector.get_head().set_z(new Coordinate(this.get_z().get_coordinate() - other.get_z().get_coordinate()));

            return tempVector;
        }

        public double distance(Point3D other) {
            return Math.sqrt(Math.pow(this.get_x().get_coordinate() - other.get_x().get_coordinate(), 2) +
                    Math.pow(this.get_y().get_coordinate() - other.get_y().get_coordinate(), 2) + Math.pow(this.get_y().get_coordinate() - other.get_z().get_coordinate(), 2));
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point3D point3D = (Point3D) o;
            return Objects.equals(_x, point3D._x) &&
                    Objects.equals(_y, point3D._y) &&
                    Objects.equals(_z, point3D._z);
        }

        @Override
        public String toString() {
            return "Point3D{" +
                    "_x=" + _x +
                    ", _y=" + _y +
                    ", _z=" + _z +
                    '}';
        }

    }
