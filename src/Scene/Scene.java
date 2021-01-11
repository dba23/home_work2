package Scene;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Geomteries.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Scene {
    private String _name;
    private List<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    private Color _background;
    private AmbientLight ambientLight;
    private List<Light> lightList;

    public Scene(String _name) {
        this._name = _name;
        this._screenDistance = 0;
        this._background = Color.BLACK;
        this._camera = new Camera();
    }

    public Scene(String _name, List<Geometry> _geometries, Camera _camera, double _screenDistance, Color _background, AmbientLight ambientLight, List<Light> lightList) {
        this._name = _name;
        this._geometries = _geometries;
        this._camera = _camera;
        this._screenDistance = _screenDistance;
        this._background = _background;
        this.ambientLight = ambientLight;
        this.lightList = lightList;
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public void setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
    }

    public List<Light> getLightList() {
        return lightList;
    }

    public void setLightList(List<Light> lightList) {
        this.lightList = lightList;
    }

    public Scene() {
        this._name = new String();
        this._screenDistance = 0;
        this._background = Color.BLACK;
        this._camera = new Camera();
    }
    public Scene(String _name, List<Geometry> _geometries, Camera _camera, double _screenDistance, Color _background) {
        this._name = _name;
        this._geometries = _geometries;
        this._camera = _camera;
        this._screenDistance = _screenDistance;
        this._background = _background;
    }

    public Scene(String _name, List<Geometry> _geometries, Camera _camera, double _screenDistance) {
        this._name = _name;
        this._geometries = _geometries;
        this._camera = _camera;
        this._screenDistance = _screenDistance;
        this._background = Color.BLACK;
    }

    public void addGeometry(Geometry _geometry) {
        this._geometries.add(_geometry);
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public List<Geometry> get_geometries() {
        return _geometries;
    }

    public void set_geometries(List<Geometry> _geometries) {
        this._geometries = _geometries;
    }

    public double get_screenDistance() {
        return _screenDistance;
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

    public Camera get_camera() {
        return _camera;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene = (Scene) o;
        return Double.compare(scene._screenDistance, _screenDistance) == 0 &&
                Objects.equals(_name, scene._name) &&
                Objects.equals(_geometries, scene._geometries) &&
                Objects.equals(_camera, scene._camera) &&
                Objects.equals(_background, scene._background);
    }

    @Override
    public String toString() {
        return "Scene{" +
                "_name='" + _name + '\'' +
                ", _geometries=" + _geometries +
                ", _camera=" + _camera +
                ", _screenDistance=" + _screenDistance +
                ", _background=" + _background +
                ", ambientLight=" + ambientLight +
                ", lightList=" + lightList +
                '}';
    }
    public void addLight(Light light){
        this.lightList.add(light);
    }
}
