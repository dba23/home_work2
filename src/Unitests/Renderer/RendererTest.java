package Unitests.Renderer;

import Elements.Camera;
import Geomteries.Sphere;
import Geomteries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Renderer;
import Scene.Scene;
import org.testng.annotations.Test;

import java.awt.*;


public class RendererTest {

    @Test
    public void basicRenderTwoColorTest() {

        Scene scene = new Scene("Test scene");
        scene.set_camera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.set_screenDistance(100) ;
        scene.set_background(new Color(255, 255, 255));;
        scene.addGeometry(new Sphere(70, new Point3D(0, 30, 90),new Color(255,255,0)));
        scene.addGeometry(new Sphere(60, new Point3D(0, -30, 80),new Color(255,255,0)));
        scene.addGeometry(new Triangle(new Point3D(10,0,10),new Point3D(-10,0,10),new Point3D(0,20,10),new Color(0,128,255)));
        scene.addGeometry(new Triangle(new Point3D(10,20,10),new Point3D(-10,20,10),new Point3D(0,0,10),new Color(0,128,255)));
        scene.addGeometry(new Triangle(new Point3D(10,0,10),new Point3D(15,0,10),new Point3D(0,20,10),new Color(0,128,255)));
        scene.addGeometry(new Triangle(new Point3D(10,2,10),new Point3D(16,2,10),new Point3D(17,15,10),new Color(255, 255, 0)));//right hand
        scene.addGeometry(new Triangle(new Point3D(-11,6,10),new Point3D(-15,0,10),new Point3D(-17,15,10),new Color(255, 255, 0)));//left hand
        scene.addGeometry(new Triangle(new Point3D(-10,0,10),new Point3D(-15,0,10),new Point3D(0,20,10),new Color(0,128,255)));
        scene.addGeometry(new Triangle(new Point3D(-9,25,10),new Point3D(-1,25,10),new Point3D(-5,15,10),new Color(92, 108, 123)));
        scene.addGeometry(new Triangle(new Point3D(1,25,10),new Point3D(9,25,10),new Point3D(5,15,10),new Color(92, 108, 123)));
        scene.addGeometry(new Sphere(12,new Point3D(5,-25,30),new Color(255,255,255)));
        scene.addGeometry(new Sphere(12,new Point3D(-5,-25,30),new Color(255,255,255)));
        scene.addGeometry(new Sphere(8.2,new Point3D(-5,-24,26),new Color(255,153,51)));
        scene.addGeometry(new Sphere(8.2,new Point3D(5,-24,26),new Color(255,153,51)));
        scene.addGeometry(new Sphere(4.3,new Point3D(5,-23,22),new Color(0,0,0)));
        scene.addGeometry(new Sphere(4.3,new Point3D(-5,-23,22),new Color(0,0,0)));
        scene.addGeometry(new Triangle(new Point3D(5,-25,40),new Point3D(10,-25,40),new Point3D(15,-23,5),new Color(255, 255, 255)));
        scene.addGeometry(new Triangle(new Point3D(-5,-25,40),new Point3D(-10,-25,40),new Point3D(-15,-23,5),new Color(255, 255, 255)));
        scene.addGeometry(new Triangle(new Point3D(-15,-18,40),new Point3D(15,-18,40),new Point3D(0,-1,5),new Color(255, 0, 0)));


        ImageWriter imageWriter = new ImageWriter("minion1", 500, 500, 500, 500);
        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();


    }

}