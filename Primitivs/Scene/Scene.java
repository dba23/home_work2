package Scene;
import Geometries.*;

import java.util.List;
import java.util.Objects;

public class Scene
{
    String name;
    List<Geometry> geometries;

    public Scene(String name, List<Geometry> geometries) {
        this.name = name;
        this.geometries = geometries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Geometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scene)) return false;
        Scene scene = (Scene) o;
        return Objects.equals(getName(), scene.getName()) &&
                Objects.equals(getGeometries(), scene.getGeometries());
    }


    @Override
    public String toString() {
        return "Scene =" +
                "\nname='" + name + '\'' +
                "\ngeometries=" + geometries ;
    }
    void addGeometry(Geometry geometry)
    {
        this.geometries.add(geometry);
    }

}
