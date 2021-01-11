package Renderer;

import Elements.Light;
import Geomteries.GeoPoint;
import Geomteries.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;

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
                Ray ray = scene.get_camera().constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(), j, i, scene.get_screenDistance(), imageWriter.getWidth(), imageWriter.getHeight());
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

        for(Geometry geometry:scene.get_geometries()) {
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
        Point3D P0 = scene.get_camera().get_P0();
        GeoPoint minDistancePoint = null;
        for (GeoPoint point: intersectionPoints) {
            if (P0.distance(point.getPoint()) < distance) {
                minDistancePoint = new GeoPoint(point.getGeometry(), point.getPoint());
                distance = P0.distance(point.getPoint());
            }
        }
        return minDistancePoint;
    }

    private Color calcColor(GeoPoint gp) {
        Color ambientLight = this.scene.getAmbientLight().getIntensity(gp.getPoint());
        Color emissionLight = gp.getGeometry().get_emission();
        Color diffuseLight = new Color(0,0,0);
        Color specularLight = new Color(0,0,0);

        for (Light l: this.scene.getLightList()) {
            Color c = calcDiffusive(gp.getGeometry().getMaterial().getKd(),gp.getGeometry().getNormal(gp.getPoint())
                    ,l.getL(gp.getPoint()),
                    l.getIntensity(gp.getPoint()));

              diffuseLight = addColor(diffuseLight,c);

              Color c1 = calcSpecular(gp.getGeometry().getMaterial().getKs(),this.scene.get_camera().get_P0().subtract(gp.getPoint()), gp.getGeometry().getNormal(gp.getPoint()),
                      l.getL(gp.getPoint()),gp.getGeometry().getMaterial().getShininess(),l.getIntensity(gp.getPoint()));
              specularLight = addColor(specularLight,c1);
        }
        Color am_em = addColor(ambientLight,emissionLight);
        Color dif_spe = addColor(diffuseLight,specularLight);

        return addColor(am_em,dif_spe);



    }
//    private Color calcColor(GeoPoint gp){
//        return gp.getGeometry().get_emission();
//    }


    private Color calcSpecular(double ks, Vector subtract, Vector normal, Vector l, int shininess, Color intensity) {
        double r,g,b;
        double scale;
//        l = l.scale(-1);
        r = intensity.getRed();
        g = intensity.getGreen();
        b = intensity.getBlue();
        Vector R ;
        R = l.normalized().subtract(normal.scale(2*l.normalized().dotProduct(normal))).normalized();
        scale =  (ks*(Math.pow(subtract.normalized().dotProduct(R),shininess)));
        return Light.intensityFix((int)(r*scale),
                (int)(g*scale),
                (int)(b*scale));

    }

    public static Color addColor(Color c1, Color c2 ){
            double r,g,b,half =0.5;
            r = c1.getRed() + c2.getRed();
            g = c1.getGreen() + c2.getGreen();
            b = c1.getBlue() + c2.getBlue();
            Color color = Light.intensityFix((int)r,(int) g,(int)b);

        return color;
    }

    private Color calcDiffusive(double kd, Vector normal, Vector l, Color intensity) {
        double scale = (kd) * (normal.normalized().dotProduct(l.normalized().scale(-1)));
        double r,g,b;
        r = intensity.getRed();
        g = intensity.getGreen();
        b = intensity.getBlue();

        Color color =  Light.intensityFix((int)(r*scale),
                (int)(g*scale),
                (int)(b*scale));

        return color ;
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
