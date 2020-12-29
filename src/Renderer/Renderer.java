package Renderer;

import geometries.GeoPoint;
import geometries.Geometry;
import primitivs.Point3D;
import primitivs.Ray;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    private Scene scene;
    private ImageWriter imageWriter;

    public Renderer(Scene scene, ImageWriter imageWriter) {
        this.scene = scene;
        this.imageWriter = imageWriter;
    }
    public Renderer(ImageWriter imageWriter, Scene scene) {
        this.scene = scene;
        this.imageWriter = imageWriter;
    }

    public void renderImage() {
        for(int i=0;i < imageWriter.getNx();i++) {
            for(int j=0;j < imageWriter.getNy();j++) {
                Ray ray = scene.getCamera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i, scene.get_screenDistance(), imageWriter.getWidth(), imageWriter.getHeight());
                List<GeoPoint> intersectionPoints = getSceneRayIntersections(ray);
                if(intersectionPoints.isEmpty()) {
                    imageWriter.writePixel(j, i, scene.get_background());
                } else {
                    GeoPoint closestPoint = getClosestPoint(intersectionPoints);
                    imageWriter.writePixel(j, i, calcColor(closestPoint));
                }
            }
        }
        imageWriter.writeToImage();
    }

    private List<GeoPoint> getSceneRayIntersections(Ray ray) {
        List<GeoPoint> intersectionPoints = new ArrayList<GeoPoint>();

        for(Geometry geometry:scene.getGeometries()) {
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);

            if(geometryIntersectionPoints != null) {
                for(Point3D intersection:geometryIntersectionPoints) {
                    intersectionPoints.add(new GeoPoint(geometry, intersection));
                }
            }
        }
        return intersectionPoints;
    }

    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = scene.getCamera().get_P0();
        GeoPoint minDistancePoint = null;
        for (GeoPoint point: intersectionPoints) {
            if (P0.distant(point.getPoint()) < distance) {
                minDistancePoint = new GeoPoint(point.getGeometry(), point.getPoint());
                distance = P0.distant(point.getPoint());
            }
        }
        return minDistancePoint;
    }

    private Color calcColor(GeoPoint gp) {
        return gp.getGeometry().get_emission();
    }

    public Scene getScene() {
        return this.scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public ImageWriter getImageWriter() {
        return this.imageWriter;
    }
    public void setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
    }

}