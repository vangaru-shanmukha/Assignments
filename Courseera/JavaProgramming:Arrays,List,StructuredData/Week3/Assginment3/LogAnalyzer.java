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
     
     public HashMap<String,Integer> countVisitsPerIP()
     {
         HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
         for(LogEntry le : records)
         {
             String ip = le.getIpAddress();
             if(hashMap.containsKey(ip))
             {
                 hashMap.put(ip,hashMap.get(ip)+1);
             }
             else
             {
                 hashMap.put(ip,1);
             }
         }
         return hashMap;
     }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> hashMap)
     {
         int max = 0;
         for(Map.Entry<String,Integer> map : hashMap.entrySet())
         {
             int value = map.getValue();
             if(max < value)
                max = value;
         }
         return max;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> hashMap)
     {
         int max = mostNumberVisitsByIP(hashMap);
         ArrayList<String> list = new ArrayList<String>();
         for(Map.Entry<String,Integer> map : hashMap.entrySet())
         {
             String key = map.getKey();
             int value = map.getValue();
             if(max == value)
                list.add(key);
         }
         return list;
     }
     
    public HashMap<String,ArrayList<String>> iPsForDays()
    {
        HashMap<String,ArrayList<String>> hashMap = new HashMap<String,ArrayList<String>>();
        for(LogEntry le : records)
        {
            String date = le.getAccessTime().toString().substring(4,10);
            if(!hashMap.containsKey(date))
            {
                ArrayList<String> list = new ArrayList<String>();
                list.add(le.getIpAddress());
                hashMap.put(date,list);
            }
            else
            {
                String ipaddress = le.getIpAddress();
                ArrayList<String> list = hashMap.get(date);
                list.add(ipaddress);
                hashMap.put(date,list);
            }
        }
        return hashMap;
    }
    
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> hashMap)
    {
        int max = 0;
        String date = "";
        for(Map.Entry<String,ArrayList<String>> map : hashMap.entrySet())
        {
            String key = map.getKey();
            int value = map.getValue().size();
            if(max < value)
            {
                max = value;
                date = key;
            }
        }
        return date;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> hashMap,String day)
    {      
        ArrayList<String> list = null;
        int max = 0;
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for(Map.Entry<String,ArrayList<String>> map : hashMap.entrySet())
        {
            String key = map.getKey();
            if(key.equals(day))
                list = map.getValue();
        }
        for(String s : list)
        {
            if(hm.containsKey(s))
            {
                int count = hm.get(s) + 1;
                if(count > max)
                    max = count;
                hm.put(s,count);
            }
            else
            {
                int count = 1;
                if(count > max)
                    max = count;
                hm.put(s,count);
            }
        }
        list.clear();
        for(Map.Entry<String,Integer> map : hm.entrySet())
        {
            if(map.getValue()==max)
                list.add(map.getKey());
        }
        return list;
    }
}