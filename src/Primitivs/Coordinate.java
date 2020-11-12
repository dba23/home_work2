package Primitivs;

public class Coordinate
{
    double coordinate;

    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.coordinate, coordinate) == 0;
    }

    @Override
    public String toString() {
        return "coordinate =" + coordinate ;
    }
}
