package edu.duke;

import edu.duke.*;
import java.io.File;
import java.util.*;
public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numberOfPoints = 0;
        for(Point point : s.getPoints())
        {
            numberOfPoints = numberOfPoints + 1;
        }
        return numberOfPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avgLength = 0.0;
        double perimeter = getPerimeter(s);
        avgLength = perimeter / (getNumPoints(s) * 1.0);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double max = 0.0;
        Point prevPoint = s.getLastPoint();
        for(Point currPoint : s.getPoints())
        {
            double currDist = prevPoint.distance(currPoint);
            if(max < currDist)
            {
                max = currDist;
            }
            else
            {
                continue;
            }
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        for(Point point : s.getPoints())
        {
            if(point.getX() > largestX)
            {
                largestX = point.getX();
            }
            else
            {
                continue;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double maxPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            double perimeter = getPerimeter(shape);
            if(perimeter > maxPerimeter)
            {
                maxPerimeter = perimeter;
            }
        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double maxPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            double perimeter = getPerimeter(shape);
            if(perimeter > maxPerimeter)
            {
                maxPerimeter = perimeter;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberOfPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numberOfPoints);
        System.out.println("average length of the side = " + avgLength);
        System.out.println("largest side = " + largestSide);
        System.out.println("largest X = " + largestX);      
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("File with the largest perimeter = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
