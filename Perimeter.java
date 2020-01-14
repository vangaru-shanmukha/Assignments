/*
    Problem Statement:
    1. What is the perimeter of the shape made from the file datatest.txt whose contents are shown below (just give to two decimal places)?
    2. What is the average length of a side in the shape made from the file datatest.txt whose contents are shown below (just give to two decimal places)?
    3. What is the longest side in the shape made from the file datatest.txt whose contents are shown below (just give to two decimal places)?
*/
import java.util.*;
import java.io.*;
class Point
{
    private int a;
    private int b;
    Point()
    {
        a=0;
        b=0;
    }
    Point(int a,int b)
    {
        this.a = a;
        this.b = b;
    }
    public Point getPoint(String point)
    {
        String s[]=point.split(",");
        return new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
    }
    public int getA()
    {
        return this.a;
    }
    public int getB()
    {
        return this.b;
    }
}
public class Perimeter
{
    public static double distance(Point prevPoint,Point currPoint)
    {
        double distance = Math.sqrt(Math.pow(prevPoint.getA()-currPoint.getA(),2)+Math.pow(prevPoint.getB()-currPoint.getB(),2));
        return distance;
    }
    public static double averageLengthOfASide(ArrayList<Double> distances)
    {
        double average = 0.0;
        for(int i=0;i<distances.size();i++)
        {
            average = average + distances.get(i);
        }
        return (average/2);
    }
    public static double longestSide(ArrayList<Double> distances)
    {
        Collections.sort(distances);
        return distances.get(distances.size()-1);
    }
    public static void main(String args[]) throws Exception
    {
        File file = new File("/home/vangaru/Documents/JAVA/dataset1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        ArrayList<Point> points = new ArrayList<Point>();
        ArrayList<Double> distances = new ArrayList<Double>();
        while((line=br.readLine())!=null)
        {
            points.add(new Point().getPoint(line));
        }
        Point prevPoint = points.get(points.size()-1);
        double perimeter = 0.0;
        for(int i=0;i<points.size();i++)
        {
            Point currPoint = points.get(i);
            double currDist = distance(prevPoint,currPoint);
            distances.add(currDist);
            perimeter = perimeter + currDist;
            prevPoint = currPoint;
        }
        System.out.println("Perimeter of the shape: " + perimeter);
        System.out.println("Average length of a side: " + averageLengthOfASide(distances));
        System.out.println("Longest side: " + longestSide(distances));
    }
}

