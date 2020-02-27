package edu.duke;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of class BatchGrayScale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BatchGrayScale
{
    private void imageSaver()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            ImageResource outImage = new ImageResource(image.getWidth(),image.getHeight());
            for(Pixel pixel : outImage.pixels())
            {
                Pixel inPixel = image.getPixel(pixel.getX(),pixel.getY());
                int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
                pixel.setRed(avg);
                pixel.setBlue(avg);
                pixel.setGreen(avg);             
            }
            outImage.draw();
            outImage.setFileName("gray-" + fname);
            outImage.save();
        }
    }
    public void testImageSaver()
    {
        imageSaver();
    }
}
