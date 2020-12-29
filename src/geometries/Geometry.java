package geometries;

import primitivs.*;
import primitivs.Point3D;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public abstract class Geometry
{

        Color _emission;

        public Geometry(Color _emission) {
                this._emission = _emission;
        }

        public Color get_emission() {
                return _emission;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Geometry geometry = (Geometry) o;
                return Objects.equals(_emission, geometry._emission);
        }

        @Override
        public String toString() {
                return "Geometry{" +
                        "_emission=" + _emission +
                        '}';
        }

        public void set_emission(Color _emission) {
                this._emission = _emission;
        }

        public abstract List<Point3D> findIntersections(Ray ray);

        public abstract Vector getNormal(Point3D point);

}
