package Renderer;

import java.awt.Color;

import org.junit.jupiter.api.Test;
import primitivs.*;
import geometries.*;
import elements.*;
import primitivs.Point3D;
import scene.Scene;

class testRenderer {

    @Test
    public void basicRenderTwoColorTest() {

        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.set_screenDistance(100) ;
        scene.set_background(new Color(0,0,0));;

        scene.addGeometry(new Sphere( new Point3D(0, 0, 100),50,new Color(255,0,0)));

        scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100),new Color(255,255,0)));
        scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100),new Color(0,255,0)));
        scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100),new Color(0,0,255)));
        scene.addGeometry(new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100),new Color(0,255,255)));

        ImageWriter imageWriter = new ImageWriter("two color test", 500, 500, 500, 500);
        Renderer render = new Renderer( scene,imageWriter);

        render.renderImage();
    }

}