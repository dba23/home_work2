package scene;
import elements.Camera;
import geometries.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene
{
    String name;
    List<Geometry> geometries;
    private double _screenDistance;
    private Color _background;
    private Camera camera;

    public Scene(String name, List<Geometry> geometries, double _screenDistance, Color _background, Camera camera) {
        this.name = name;
        this.geometries = geometries;
        this._screenDistance = _screenDistance;
        this._background = _background;
        this.camera = camera;
    }

    public Scene(String test_scene) {
        this.name = test_scene;
        this.geometries = new ArrayList<Geometry>();
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public double get_screenDistance() {
        return _screenDistance;
    }


    @Override
    public String toString() {
        return "Scene{" +
                "name='" + name + '\'' +
                ", geometries=" + geometries +
                ", _screenDistance=" + _screenDistance +
                ", _background=" + _background +
                ", camera=" + camera +
                '}';
    }



    public void set_screenDistance(double _screenDistance) {
        this._screenDistance = _screenDistance;
    }

    public Color get_background() {
        return _background;
    }

    public void set_background(Color _background) {
        this._background = _background;
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


    public void addGeometry(Geometry geometry)
    {
        this.geometries.add(geometry);
    }

}
