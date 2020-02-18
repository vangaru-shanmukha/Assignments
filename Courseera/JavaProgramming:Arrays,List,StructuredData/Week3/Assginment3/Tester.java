package edu.duke;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Testing/edu/duke/short-test_log.txt");
        logAnalyzer.printAll();
    }
    
    public void testUniqueIP()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Testing/edu/duke/short-test_log.txt");
        System.out.println("There are " + logAnalyzer.countUniqueIPs() + " unique IPs. ");
    }
    
    public void testPrintAllHigherThanNum()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Testing/edu/duke/short-test_log.txt");
        System.out.println("Log entrys having status code greater than 200 :");
        logAnalyzer.printAllHigherThanNum(200);
    }
    
    public void testUniqueIPVisitsOnDay()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/weblog-short_log");
        String someday = "Sep 14";
        System.out.println("Log entrys on:" + someday);
        ArrayList<LogEntry> list = logAnalyzer.uniqueIPVisitsOnDay(someday);
        for(LogEntry le : list)
        {
            System.out.println(le.toString());
        }
    }
    
    public void testCountUniqueIPsInRange()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/short-test_log");
        int low = 300;
        int high = 399;
        System.out.print("Number of unique IPs with status code in range " + low + " and " + high + " : ");
        System.out.println(logAnalyzer.countUniqueIPsInRange(low,high));
    }
    
    public void testMostNumberVisitsByIP()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/weblog3-short_log");
        HashMap<String,Integer> hashMap = logAnalyzer.countVisitsPerIP();
        System.out.println("Maximum number of visits to the website : " + logAnalyzer.mostNumberVisitsByIP(hashMap));
    }
    
    public void testIPsMostVisits()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/weblog3-short_log");
        HashMap<String,Integer> hashMap = logAnalyzer.countVisitsPerIP();
        ArrayList<String> list = logAnalyzer.iPsMostVisits(hashMap);
        System.out.println("Most visits to the website: ");
        for(String s : list)
            System.out.println(s);
    }
    
    public void testiPsForDays()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/weblog3-short_log");
        HashMap<String,ArrayList<String>> hashMap = logAnalyzer.iPsForDays();
        System.out.println("IP Addresses for ");
        for(Map.Entry<String,ArrayList<String>> map : hashMap.entrySet())
            System.out.println(map.getKey() + " : " + map.getValue());
    }
    
    public void testdayWithMostIPVisits()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/weblog3-short_log");
        HashMap<String,ArrayList<String>> hashMap = logAnalyzer.iPsForDays();
        System.out.println("Day with most visits : " + logAnalyzer.dayWithMostIPVisits(hashMap));
    }
    
    public void testiPsWithMostVisitsOnDay()
    {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("/home/vangaru/Downloads/weblog3-short_log");
        HashMap<String,ArrayList<String>> hashMap = logAnalyzer.iPsForDays();
        System.out.println("Most visited IPs for the day Sep 30:" + logAnalyzer.iPsWithMostVisitsOnDay(hashMap,"Sep 30"));
    }
}