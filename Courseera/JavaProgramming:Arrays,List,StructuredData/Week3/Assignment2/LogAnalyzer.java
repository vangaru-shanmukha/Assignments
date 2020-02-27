package edu.duke;

/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String s : fr.lines())
         {
             WebLogParser webLogParser = new WebLogParser();
             LogEntry logEntry = webLogParser.parseEntry(s);
             records.add(logEntry);
         }
     }
        
     public int countUniqueIPs()
     {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry logEntry : records)
         {
             String IPAddress = logEntry.getIpAddress();
             if(!uniqueIPs.contains(IPAddress))
                uniqueIPs.add(IPAddress);
         }
         return uniqueIPs.size();
     }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public void printAllHigherThanNum(int num)
     {
         for(LogEntry le : records)
         {
             int status_code = le.getStatusCode();
             if(status_code > num)
             {
                 System.out.println(le.toString());
             }
         }
     }
     
     public ArrayList<LogEntry> uniqueIPVisitsOnDay(String someday)
     {
         ArrayList<LogEntry> IPsOnDay = new ArrayList<LogEntry>();
         for(LogEntry le : records)
         {
             Date date = le.getAccessTime();
             String sdate = date.toString();
             if(sdate.contains(someday))
             {
                 IPsOnDay.add(le);
             }
         }
         ArrayList<LogEntry> uniqueIPs = uniqueIP(IPsOnDay);
         return uniqueIPs;
     }
     
     public ArrayList<LogEntry> uniqueIP(ArrayList<LogEntry> list)
     {
         ArrayList<String> list1 = new ArrayList<String>();
         ArrayList<LogEntry> list2 = new ArrayList<LogEntry>();
         for(LogEntry le : list)
         {
             String ip = le.getIpAddress();
             if(!list1.contains(ip))
             {
                 list1.add(ip);
                 list2.add(le);
             }
         }
         return list2;
     }
     
     public int countUniqueIPsInRange(int low,int high)
     {
         ArrayList<LogEntry> list = new ArrayList<LogEntry>();
         for(LogEntry le : records)
         {
             int statusCode = le.getStatusCode();
             if(statusCode >= low && statusCode <= high)
                list.add(le);
         }
         list = uniqueIP(list);
         return list.size();
     }
}