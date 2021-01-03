package Primitives;

public class Coordinate implements Cloneable {

    protected double  _coordinate;

    public Coordinate() {
        this._coordinate = 0;
    }

    public Coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }

    public double get_coordinate() {
        return _coordinate;
    }

    public void set_coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that._coordinate, _coordinate) == 0;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "_coordinate=" + _coordinate +
                '}';
    }


}
