package edu.duke;
import org.apache.commons.csv.*;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSVPart_1
{
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser,"Germany"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999");
    }
    private String countryInfo(CSVParser parser,String country)
    {
        String result = "NOT FOUND";
        for(CSVRecord record : parser)
        {
            if(record.get("Country").equals(country))
            {
                result = country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        return result;
    }
    private void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    {
        for(CSVRecord record : parser)
        {
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    private int numberOfExporters(CSVParser parser,String exportItem)
    {
        int count = 0;
        for(CSVRecord record : parser)
        {
            if(record.get("Exports").contains(exportItem))
            {
                count = count + 1;
            }
        }
        return count;
    }
    private void bigExporters(CSVParser parser,String amount)
    {
        for(CSVRecord record : parser)
        {
            if(record.get("Value (dollars)").length() > amount.length())
            {
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }
}
