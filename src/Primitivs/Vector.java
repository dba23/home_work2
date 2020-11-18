package Primitivs;

import java.util.Objects;

public class Vector
{
    private Point3D head;

    public Vector(Point3D head) {
        this.setHead(head);//vrc
    }

    public Vector(double _X,double _Y,double _Z)
    {
        this.head=new Point3D(new Coordinate(_X),new Coordinate(_Y),new Coordinate(_Z));
    }

    public Point3D getHead() {
        return head;
    }

    public void setHead(Point3D head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(getHead(), vector.getHead());
    }

    @Override
    public String toString() {
        return "head =" + getHead();
    }
    public double length()
    {
        return Math.sqrt((Math.pow(this.head._x.coordinate,2)+Math.pow(this.head._y.coordinate,2)+Math.pow(this.head._z.coordinate,2)));
    }
    public Vector add(Vector other)
    {
        return new Vector(new Point3D(new Coordinate(this.getHead().get_x().getCoordinate()+other.getHead().get_x().getCoordinate()),
        new Coordinate(this.getHead().get_y().getCoordinate()+other.getHead().get_y().getCoordinate()),
                new Coordinate(this.getHead().get_z().getCoordinate()+other.getHead().get_z().getCoordinate())));
    }
    public Vector subtract(Vector other)
    {
        return new Vector(new Point3D(new Coordinate(this.getHead().get_x().getCoordinate()-other.getHead().get_x().getCoordinate()),
                new Coordinate(this.getHead().get_y().getCoordinate()-other.getHead().get_y().getCoordinate()),
                new Coordinate(this.getHead().get_z().getCoordinate()-other.getHead().get_z().getCoordinate())));

    }
    public Vector scale(double scalar){
        return new Vector(
                scalar*this.head._x.coordinate,
                scalar*this.head._y.coordinate,
                scalar*this.head._z.coordinate);

    }
    public Vector crossProduct(Vector other)
    {
        Coordinate c1,c2,c3;
        c1 = new Coordinate(this.getHead().get_y().getCoordinate()*other.getHead().get_z().getCoordinate()-this.getHead().get_z().getCoordinate()*other.getHead().get_y().getCoordinate());
        c2 = new Coordinate(this.getHead().get_x().getCoordinate()*other.getHead().get_z().getCoordinate()-this.getHead().get_z().getCoordinate()*other.getHead().get_x().getCoordinate());
        c3 = new Coordinate(this.getHead().get_y().getCoordinate()*other.getHead().get_x().getCoordinate()-this.getHead().get_x().getCoordinate()*other.getHead().get_y().getCoordinate());
        return new Vector(new Point3D(c1,c2,c3));
    }

    public double dotProduct(Vector other)
    {
        return this.getHead().get_x().getCoordinate()*other.getHead().get_x().getCoordinate()+
                this.getHead().get_y().getCoordinate()*other.getHead().get_y().getCoordinate()+
                this.getHead().get_z().getCoordinate()*other.getHead().get_z().getCoordinate();
    }
    public Vector normalize()
    {
        return new Vector(new Point3D(new Coordinate(this.getHead().get_x().getCoordinate()/this.length()),
                new Coordinate(this.getHead().get_y().getCoordinate()/this.length()),
                new Coordinate(this.getHead().get_z().getCoordinate()/this.length())));
    }



}
