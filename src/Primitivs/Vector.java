package Primitivs;

import java.util.Objects;

public class Vector
{
    Point3D head;

    public Vector(Point3D head) {
        this.head = head;
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
        return Objects.equals(head, vector.head);
    }

    @Override
    public String toString() {
        return "head =" + head;
    }
}
