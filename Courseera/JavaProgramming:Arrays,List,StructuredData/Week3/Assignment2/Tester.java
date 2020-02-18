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
}