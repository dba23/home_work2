package Primitivs;

import java.util.Objects;

public class Ray
{
    Point3D headPoint;
    Vector direction;

    public Ray(Point3D headPoint, Vector direction) {
        this.headPoint = headPoint;
        this.direction = direction;
    }

    public Point3D getHeadPoint() {
        return headPoint;
    }

    public void setHeadPoint(Point3D headPoint) {
        this.headPoint = headPoint;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(headPoint, ray.headPoint) &&
                Objects.equals(direction, ray.direction);
    }

    @Override
    public String toString() {
        return "headPoint=" + headPoint +
                "\ndirection=" + direction;
    }
}
