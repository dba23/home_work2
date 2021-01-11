package Primitives;

import java.util.Objects;

public class Vector extends Point3D implements Cloneable {
    private Point3D _head;

    public Vector(Point3D _head) {
        this._head = _head;
    }
    public Vector(int x, int y, int z){
        this._head = new Point3D(x,y,z);
    }
    public Vector(double x, double y, double z){
        this._head = new Point3D(x,y,z);
    }

    public Vector() { this._head = new Point3D(); }


    public Point3D get_head() {
        return _head;
    }

    public void set_head(Point3D _head) {
        this._head = _head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }

    public double length() {
        return Math.sqrt(
                Math.pow(this.get_head().get_x().get_coordinate(), 2) +
                        Math.pow(this.get_head().get_y().get_coordinate(), 2) +
                        Math.pow(this.get_head().get_z().get_coordinate(), 2)
        );
    }

    public Vector normalized() {

        Vector tempVector = new Vector();

        tempVector.get_head().set_x(new Coordinate(this.get_head().get_x().get_coordinate()/this.length()));
        tempVector.get_head().set_y(new Coordinate(this.get_head().get_y().get_coordinate()/this.length()));
        tempVector.get_head().set_z(new Coordinate(this.get_head().get_z().get_coordinate()/this.length()));

        return tempVector;

    }

    public Vector add(Vector other) {
        if (this.equals(other.scale(-1))) {
            throw new IllegalArgumentException("you can not do add vector + (-vector)");
        }
        Vector tempVector = new Vector();
        tempVector.get_head().set_x(new Coordinate(this.get_head().get_x().get_coordinate() + other.get_head().get_x().get_coordinate()));
        tempVector.get_head().set_y(new Coordinate(this.get_head().get_y().get_coordinate() + other.get_head().get_y().get_coordinate()));
        tempVector.get_head().set_z(new Coordinate(this.get_head().get_z().get_coordinate() + other.get_head().get_z().get_coordinate()));

        return tempVector;
    }

    public Vector subtract(Vector other) {
        if (this.equals(other)) {
            throw new IllegalArgumentException("you can not Substract the same vector)");
        }
        this.get_head().set_x(new Coordinate(this.get_head().get_x().get_coordinate() - other.get_head().get_x().get_coordinate()));
        this.get_head().set_y(new Coordinate(this.get_head().get_y().get_coordinate() - other.get_head().get_y().get_coordinate()));
        this.get_head().set_z(new Coordinate(this.get_head().get_z().get_coordinate() - other.get_head().get_z().get_coordinate()));

        return this;
    }

    public Vector scale(double scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("The scalar cannot be equal to zero");
        }

        Vector tempVector = new Vector();
        tempVector.get_head().set_x(new Coordinate(this.get_head().get_x().get_coordinate() * scalar));
        tempVector.get_head().set_y(new Coordinate(this.get_head().get_y().get_coordinate() * scalar));
        tempVector.get_head().set_z(new Coordinate(this.get_head().get_z().get_coordinate() * scalar));
        return tempVector;
    }

    public Vector crossProduct(Vector other) {
        Vector tempVector = new Vector();

        tempVector.get_head().set_x(new Coordinate((this.get_head().get_y().get_coordinate() * other.get_head().get_z().get_coordinate()) - (this.get_head().get_z().get_coordinate() * other.get_head().get_y().get_coordinate())));
        tempVector.get_head().set_y(new Coordinate((this.get_head().get_z().get_coordinate() * other.get_head().get_x().get_coordinate()) - (this.get_head().get_x().get_coordinate() * other.get_head().get_z().get_coordinate())));
        tempVector.get_head().set_z(new Coordinate((this.get_head().get_x().get_coordinate() * other.get_head().get_y().get_coordinate()) - (this.get_head().get_y().get_coordinate() * other.get_head().get_x().get_coordinate())));

        if (tempVector.get_head().get_x().get_coordinate() == 0 && tempVector.get_head().get_y().get_coordinate() == 0 && tempVector.get_head().get_z().get_coordinate() == 0) {
            throw new IllegalArgumentException("result equal to zero!");
        }
        return tempVector;
    }

    public double dotProduct(Vector other) {
        return this.get_head().get_x().get_coordinate()*other.get_head().get_x().get_coordinate() + this.get_head().get_y().get_coordinate()*other.get_head().get_y().get_coordinate() + this.get_head().get_z().get_coordinate()*other.get_head().get_z().get_coordinate();
    }

}
