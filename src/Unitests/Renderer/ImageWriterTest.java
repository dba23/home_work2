package Unitests.Renderer;

import Renderer.ImageWriter;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ImageWriterTest {

    @Test
    void getNy() {
    }

   /*
    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i) {
            for (int j = 25; j < 275; ++j) {
                imageWriter.writePixel(j, i,new  Color(0,140, 69));
                imageWriter.writePixel(j, i,new  Color(0,140, 69));
            }

        }
        for (int i = 0; i < nY; ++i) {
            for (int j = 275; j < 525; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 0; i < nY; ++i) {
            for (int j = 525; j < 775; ++j) {
                imageWriter.writePixel(j, i,new  Color(205, 33, 42));
                imageWriter.writePixel(j, i,new  Color(205, 33, 42));
            }

        }

        for (int i = 430; i < 490; ++i) {
            for (int j = 25; j < 775; ++j) {
                imageWriter.writePixel(j, i,Color.BLACK);
                imageWriter.writePixel(j, i,Color.BLACK);
            }

        }
        for (int i = 430; i < 497; ++i) { //I
            for (int j = 100; j < 120; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 430; i < 497; ++i) { // T
            for (int j = 160; j < 180; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 430; i < 445; ++i) { //T
            for (int j = 140; j < 200; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }

        for (int i = 440; i < 497; ++i) { // A left leg
            for (int j = 215; j < 230; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }

        for (int i = 430; i < 440; ++i) { // A middle
            for (int j = 230; j < 260; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 440; i < 497; ++i) { // A right leg
            for (int j = 260; j < 275; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 460; i < 470; ++i) { // A middle down
            for (int j = 230; j < 260; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 490; i < 500; ++i) { //L2
            for (int j = 275; j < 300; ++j) {
                imageWriter.writePixel(j, i,Color.BLACK);
                imageWriter.writePixel(j, i,Color.BLACK);
            }

        }
        for (int i = 432; i < 490; ++i) { //L1
            for (int j = 300; j < 315; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 490; i < 490; ++i) { //L2
            for (int j = 320; j < 360; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 497; i < 500; ++i) { //
            for (int j = 380; j < 430; ++j) {
                imageWriter.writePixel(j, i,Color.BLACK);
                imageWriter.writePixel(j, i,Color.BLACK);
            }

        }
        for (int i = 490; i < 500; ++i) { //
            for (int j = 355; j < 380; ++j) {
                imageWriter.writePixel(j, i,Color.BLACK);
                imageWriter.writePixel(j, i,Color.BLACK);
            }

        }
        for (int i = 450; i < 490; ++i) { //Y1
            for (int j = 380; j < 400; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 430; i < 450; ++i) { //Y1
            for (int j = 365; j < 380; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 430; i < 450; ++i) { //Y1
            for (int j = 400; j < 415; ++j) {
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
                imageWriter.writePixel(j, i,new  Color(244, 245, 240));
            }

        }
        for (int i = 497; i < 500; ++i) { //
            for (int j = 380; j < 430; ++j) {
                imageWriter.writePixel(j, i,Color.BLACK);
                imageWriter.writePixel(j, i,Color.BLACK);
            }

        }
        for (int i = 490; i < 500; ++i) { //
            for (int j = 400; j < 430; ++j) {
                imageWriter.writePixel(j, i,Color.BLACK);
                imageWriter.writePixel(j, i,Color.BLACK);
            }

        }




        imageWriter.writeToImage();
    }*/

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest1", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 50; i < 150; ++i) {
            for (int j = 25; j < 200; ++j) {
                imageWriter.writePixel(j, i,Color.BLUE);
                imageWriter.writePixel(j, i,Color.BLUE);
            }
        }
        for (int i = 150; i < 250; ++i) {
            for (int j = 25; j < 375; ++j) {
                imageWriter.writePixel(j, i,Color.BLUE);
                imageWriter.writePixel(j, i,Color.BLUE);
            }

        }
        for (int i = 250; i < 350; ++i) {
            for (int j = 25; j < 550; ++j) {
                imageWriter.writePixel(j, i,Color.BLUE);
                imageWriter.writePixel(j, i,Color.BLUE);
            }

        }
        for (int i = 350; i < 450; ++i) {
            for (int j = 25; j < 725; ++j) {
                imageWriter.writePixel(j, i,Color.BLUE);
                imageWriter.writePixel(j, i,Color.BLUE);
            }

        }
        for (int i = 260; i < 280; ++i) {
            for (int j = 630; j < 660; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }
        for (int i = 260; i < 280; ++i) {
            for (int j = 650; j < 690; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }


        for (int i = 270; i < 290; ++i) {
            for (int j = 650; j < 690; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }
        for (int i = 290; i < 320; ++i) {
            for (int j = 690; j < 710; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }
        for (int i = 320; i < 340; ++i) {
            for (int j = 650; j < 690; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }
        for (int i = 330; i < 350; ++i) {
            for (int j = 620; j < 650; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }
        for (int i = 340; i < 350; ++i) {
            for (int j = 650; j < 690; ++j) {
                imageWriter.writePixel(j, i,Color.YELLOW);
                imageWriter.writePixel(j, i,Color.YELLOW);
            }

        }

        for (int i = 290; i < 315; ++i) {
            for (int j = 590; j < 620; ++j) {
                imageWriter.writePixel(j, i,Color.MAGENTA);
                imageWriter.writePixel(j, i,Color.MAGENTA);
            }

        }

        imageWriter.writeToImage();

    }

}