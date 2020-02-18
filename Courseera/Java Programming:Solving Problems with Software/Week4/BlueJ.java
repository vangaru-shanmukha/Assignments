package edu.duke;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of class BlueJ here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueJ
{
    private ImageResource BatchInversions(ImageResource image)
    {
            ImageResource outImage = new ImageResource(image.getWidth(),image.getHeight());
            for(Pixel pixel : outImage.pixels())
            {
                Pixel inPixel = image.getPixel(pixel.getX(),pixel.getY());
                pixel.setRed(255 - inPixel.getRed());
                pixel.setBlue(255 - inPixel.getBlue());
                pixel.setGreen(255 - inPixel.getGreen());             
            }
            return outImage;
    }
    private void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource image = new ImageResource(f);
            String fileName = image.getFileName();
            ImageResource outImage = BatchInversions(image);
            outImage.setFileName("inverted-" + fileName);
            outImage.save();
        }
    }
    public void testSelectAndConvert()
    {
        selectAndConvert();
    }
}
