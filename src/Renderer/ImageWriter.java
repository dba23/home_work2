package Renderer;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriter {
    private double _imageWidth, _imageHeight;
    private int _nX, _nY;

    private final String PROJECT_PATH = System.getProperty("user.dir") + "/src/images";

    private String _imageName;

    private BufferedImage _image;


    public ImageWriter(String imageName, double width, double height, int nX, int nY)
    {
        this._imageName = imageName;
        this._imageWidth = width;
        this._imageHeight = height;
        this._nX = nX;
        this._nY = nY;

        this._image = new BufferedImage(this._nX, this._nY, BufferedImage.TYPE_INT_RGB);

    }
    public ImageWriter(ImageWriter imageWriter)
    {
        this._imageName = imageWriter._imageName;
        this._imageWidth = imageWriter._imageWidth;
        this._imageHeight = imageWriter._imageHeight;
        this._nX = imageWriter._nX;
        this._nY = imageWriter._nY;

        this._image = new BufferedImage(this._nX, this._nY, BufferedImage.TYPE_INT_RGB);

    }
    public double getWidth()  { return _imageWidth;  }
    public double getHeight() { return _imageHeight; }

    public int getNy() { return _nY; }
    public int getNx() { return _nX; }

    public void writePixel(int xIndex, int yIndex, Color color){
        _image.setRGB(xIndex, yIndex, color.getRGB());
    }
    public void writePixel(int xIndex, int yIndex, int r, int g, int b){
        int rgb = new Color(r, g, b).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);
    }

    public void writeToImage(){
        File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");
        try {
            javax.imageio.ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
            ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
            jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            ((ImageWriteParam) jpgWriteParam).setCompressionQuality(1f);
            jpgWriter.setOutput(new FileImageOutputStream(ouFile));
            jpgWriter.write(null,new IIOImage(_image, null, null), jpgWriteParam);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }





}
