package edu.duke;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class CSVPart_2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSVPart_2
{
    private CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord smallestSoFar = null;
        for(CSVRecord record : parser)
        {        
            smallestSoFar = getTheSmallest(record,smallestSoFar,"TemperatureF");
        }
        return smallestSoFar;       
    }
    private String fileWithColdestTemperature()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord smallestSoFar = null;
        String fileName = null;
        for(File f : dr.selectedFiles())
        {
            FileResource file = new FileResource(f);
            CSVRecord current = coldestHourInFile(file.getCSVParser());
            smallestSoFar = getTheSmallest(current,smallestSoFar,"TemperatureF");
            fileName = getTheSmallestFile(current,smallestSoFar,fileName,f.getName(),"TemperatureF");
        }
        System.out.println("Coldest day was in file " + fileName);
        System.out.println("Coldest temperature on that day was " + smallestSoFar);
        System.out.println("All the Temperatures on that coldest day were: ");
        return fileName;
    }
    private CSVRecord lowestHumidityInManyFiles()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord smallestSoFar = null;
        for(File f : dr.selectedFiles())
        {
            FileResource file = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(file.getCSVParser());
            smallestSoFar = getTheSmallest(current,smallestSoFar,"Humidity");
        }
        return smallestSoFar;
    }
    private String getTheSmallestFile(CSVRecord current,CSVRecord smallestSoFar,String fileName,String currFileName,String columnName)
    {
            if(smallestSoFar == null)
            {
                smallestSoFar = current;
            }
            else
            {
                double currTemp = Double.parseDouble(current.get(columnName));
                double smallestTemp = Double.parseDouble(smallestSoFar.get(columnName));
                if(currTemp <= smallestTemp)
                {
                    smallestSoFar = current;
                    fileName = currFileName;
                }
            }
            return fileName;
    }
    private CSVRecord getTheSmallest(CSVRecord current,CSVRecord smallestSoFar,String columnName)
    {
            if(smallestSoFar == null)
            {
                smallestSoFar = current;
            }
            else
            {
                double currTemp = Double.parseDouble(current.get(columnName));
                double smallestTemp = Double.parseDouble(smallestSoFar.get(columnName));
                if(currTemp < smallestTemp)
                {
                    smallestSoFar = current;
                }            
            }
            return smallestSoFar;
    }
    public void testFileWithColdestTemperature()
    {
        String fileName = fileWithColdestTemperature();
        FileResource fr = new FileResource("/home/vangaru/Downloads/nc_weather/2014/"+fileName);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser)
        {
            System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
        }
    }
    private CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord smallestSoFar = null;
        for(CSVRecord record : parser)
        {
            String curr = record.get("Humidity");
            if(curr.equals("N/A"))
            {
                continue;
            }
            else
            {
                double currHumidity = Double.parseDouble(curr);
                smallestSoFar = getTheSmallest(record,smallestSoFar,"Humidity");
            }
        }
        return smallestSoFar;
    }
    private double averageTemperatureInFile(CSVParser parser)
    {
        double averageTemp = 0.0;
        int count = 0;
        for(CSVRecord record : parser)
        {
            averageTemp = averageTemp + Double.parseDouble(record.get("TemperatureF"));
            count = count + 1;
        }
        return averageTemp/(count*1.0);
    }
    private double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value)
    {
        double avgTemp = 0.0;
        int count = 0;
        for(CSVRecord record : parser)
        {
            if(record.get("Humidity").equals("N/A") == false)
            {                
                if(Double.parseDouble(record.get("Humidity")) >= value)
                {
                    avgTemp = avgTemp + Double.parseDouble(record.get("TemperatureF"));                    
                    count = count + 1;
                }
            }
        }
        if(count == 0)
            return 0;
        return avgTemp/(count*1.0);
    }
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource file = new FileResource();
        CSVParser parser = file.getCSVParser();
        double averageTemperature = averageTemperatureWithHighHumidityInFile(parser,80);
        if(averageTemperature == 0)
            System.out.println("No temperature with that humidity");
        else
            System.out.println("Average temperature in file is " + averageTemperature);
    }
    public void testAverageTemperatureInFile()
    {
        FileResource file = new FileResource();
        CSVParser parser = file.getCSVParser();
        double averageTemperature = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + averageTemperature);
    }
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " +  csv.get("DateUTC"));
    }
    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(coldestHourInFile(parser).get("TemperatureF"));
    }
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
}
