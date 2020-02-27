package edu.duke;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class MiniProjectPart_1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniProjectPart_1
{
    private void totalBirths(CSVParser parser)
    {
        int totalGirls = 0;
        int totalBoys = 0;
        StorageResource sr = new StorageResource();
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals("M"))
                totalBoys = totalBoys + 1;
            else
                totalGirls = totalGirls + 1;
            sr.add(record.get(0));
        }
        System.out.println("Total number of girls: " + totalGirls);
        System.out.println("Total number of boys: " + totalBoys);
        for(String s : sr.data())
        {
            System.out.println(s);
        }
    }
    private CSVParser getFile(int year)
    {
        FileResource fr = new FileResource("/home/vangaru/Testing/edu/duke/testing/yob" + year + "short.csv");
        CSVParser parser = fr.getCSVParser(false);
        return parser;
    }
    private int getRank(CSVParser parser,String name,String gender)
    {
        int rank = 0;     
        boolean flag = false;
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals(gender))
            {
                rank = rank + 1;
            }
            if(record.get(0).equals(name) && record.get(1).equals(gender))
            {                
                flag = true;
                break;
            }
        }
        if(flag == false)
            rank = -1;
        return rank;
    }
    private int getRank(int year,String name,String gender)
    {
        int rank = 0;     
        boolean flag = false;
        CSVParser parser = getFile(year);
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals(gender))
            {
                rank = rank + 1;
            }
            if(record.get(0).equals(name) && record.get(1).equals(gender))
            {                
                flag = true;
                break;
            }
        }
        if(flag == false)
            rank = -1;
        return rank;
    }
    private String getName(int year,int rank,String gender)
    {
        String name = "NO NAME";
        CSVParser parser = getFile(year);
        for(CSVRecord record : parser)
        {
            if(rank == 1)
            {
                name = record.get(0);
                break;
            }            
            else if(record.get(1).equals(gender))
            {
                rank = rank - 1;
            }            
        }
        return name;
    }
    private void whatIsNameInYear(String name,int year,int newYear,String gender)
    {
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear + ".");
    }
    private double getAverageRank(String name,String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        double rank = 0.0;
        int count = 0;
        for(File f : dr.selectedFiles())
        {
            FileResource file = new FileResource(f);
            CSVParser parser = file.getCSVParser(false);
            rank = rank + (getRank(parser,name,gender)*1.0);
            count = count + 1;
        }
        return rank/(count*1.0);
    }
    private int getTotalBirthsRankedHigher(int year,String name,String gender)
    {
        int totalBirths = 0;
        int rank = getRank(year,name,gender);
        CSVParser parser = getFile(year);
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals(gender))
            {
                rank = rank - 1;
                totalBirths = totalBirths + Integer.parseInt(record.get(2));
            }
            if(rank == 1)
                break;
        }
        return totalBirths;
    }
    public void testGetTotalBirthsRankedHigher()
    {
        int totalBirths = getTotalBirthsRankedHigher(2012,"Ethan","M");
        System.out.println(totalBirths);
    }
    public void testGetAverageRank()
    {
        double avgRank = getAverageRank("Jacob","M");
        System.out.println(avgRank);
    }
    public void testWhatIsNameInYear()
    {
        whatIsNameInYear("Isabella",2012,2014,"F");
    }
    public void testGetName()
    {
        String name = getName(2012,3,"M");
        System.out.println(name);
    }
    public void testGetRank()
    {
        int rank = getRank(2012,"Mason","M");
        System.out.println(rank);
    }
    public void testTotalBirths()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        totalBirths(parser);
    }
}
