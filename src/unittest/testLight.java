package unittest;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointalLight;
import Elements.SpotLight;
import Geomteries.*;
import org.testng.annotations.Test;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

import java.awt.*;

public class testLight{


    @Test
    public void emmissionTest(){

        Scene scene = new Scene("emmissionTest");
        scene.set_background(new Color(0, 0, 0));
        scene.set_camera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.set_screenDistance(100);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

        scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, 149), new Color(255,0,0)));

        Triangle triangle = new Triangle(new Point3D( 100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D( 100, 100, 149),
                new Color(0,255,0));

        Triangle triangle2 = new Triangle(new Point3D( 100, 0, 149),
                new Point3D(  0, -100, 149),
                new Point3D( 100,-100, 149),
                new Color(0,0,255));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, 149),
                new Point3D(  0, 100, 149),
                new Point3D(-100, 100, 149),
                new Color(255,255,0));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, 149),
                new Point3D(  0,  -100, 149),
                new Point3D(-100, -100, 149),
                new Color(255,0,255));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmition test", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();
    }



    @Test
    public void spotLightTest2(){

        Scene scene = new Scene("spotLightTest2");
        scene.set_background(new Color(0, 0, 0));
        scene.set_camera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.set_screenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));


        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 100));
        Material m=new Material(1,1,20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, 225, 260),
                new Point3D(-225, 125, 260),
                new Point3D(-225, 225, 270),
                new Color (0, 0, 100));

        Material m1=new Material(1,1,4);
        triangle.setMaterial(m1);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, 150), 0.1, 0.00001, 0.000005,new Vector(2, 2, 3)));

        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void spotLightTest(){

        Scene scene = new Scene("spotLightTest");
        scene.set_background(new Color(0, 0, 0));
        scene.set_camera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.set_screenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));


        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 100));
        Material m=new Material(1,1,20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, 100),
                 0, 0.00001, 0.000005,new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void pointLightTest(){

        Scene scene = new Scene("pointLightTest");
        scene.set_background(new Color(0, 0, 0));
        scene.set_camera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.set_screenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
        Sphere sphere = new Sphere (500, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 100));
        Material m=new Material(1,1,20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);
        scene.addLight(new PointalLight(new Color(255, 100, 100), new Point3D(-200, 200, 100),
                0, 0.00001, 0.000005) {
        });

        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();


    }

    @Test
    public void spotLightTest3(){

        Scene scene = new Scene("spotLightTest3");
        scene.set_background(new Color(0, 0, 0));
        scene.set_camera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.set_screenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
        Material m=new Material(1,1,1);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, 2000),
                new Point3D( -3500, -3500, 1000),
                new Point3D(  3500, -3500, 2000),
                new Color(0,0,0));

        triangle1.setMaterial(m);
        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, 2000),
                new Point3D( -3500,  3500, 1000),
                new Point3D( -3500, -3500, 1000),
                new Color(0,0,0));

        triangle2.setMaterial(m);

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, -200, -100), 0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void pointLightTest2(){

        Scene scene = new Scene("pointLightTest2");
        scene.set_background(new Color(0, 0, 0));
        scene.set_camera(new Camera( new Point3D(0, 0, 0),new Vector(0.0, 0.0, 1.0),new Vector(0,-1, 0.0)));
        scene.set_screenDistance(200);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

        Material m1=new Material(1,1,1);
        Material m2=new Material(1,1,20);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, 1000),new Color(0, 0, 100));
        sphere.setMaterial(m2);

        Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, 2000),
                new Point3D( -3500, -3500, 1000),
                new Point3D(  3500, -3500, 2000),
                new Color(0,0,0));

        triangle1.setMaterial(m1);
        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, 2000),
                new Point3D( -3500,  3500, 1000),
                new Point3D( -3500, -3500, 1000),
                new Color(0,0,0));

        triangle2.setMaterial(m1);

        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);

        scene.addLight(new PointalLight(new Color(255, 100, 100), new Point3D(200, -200, 100), 0, 0.000001, 0.0000005) {
        });


        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

        Renderer render = new Renderer(imageWriter, scene);

        render.renderImage();

    }


}