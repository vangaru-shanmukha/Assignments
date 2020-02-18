package edu.duke;

import java.util.*;
/**
 * Write a description of class GladLibExtension here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GladLibExtension
{
    private HashMap<String,Integer> count;
    public GladLibExtension()
    {
        count = new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start,String dna)
    {
        count.clear();
        for(int i=start;i<dna.length()-3;i=i+3)
        {
            String s = dna.substring(i,i+3);
            if(count.containsKey(s))
            {
                count.put(s, count.get(s) + 1);
            }
            else
            {
                count.put(s,1);
            }
        }
        /*for(Map.Entry<String,Integer> map : count.entrySet())
        {
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }*/
    }
    public String getMostCommonCodon()
    {
        String codon = "";
        int max = 0;
        for(Map.Entry<String,Integer> map : count.entrySet())
        {
            int value = map.getValue();
            if(value > max)
            {
                max = value;
                codon = map.getKey();
            }
        }
        return codon;
    }
    public void printCodonCounts(int start,int end)
    {
        for(Map.Entry<String,Integer> map : count.entrySet())
        {
            int value = map.getValue();
            if(value >= start && value <= end)
            {
                System.out.println(map.getKey() + " " + map.getValue());
            }
        }
    }
    public void tester()
    {
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();    
        int start = 1;
        int end = 5;
        for(int readingFrame = 0 ; readingFrame < 3 ;readingFrame ++)
        {
            buildCodonMap(readingFrame,dna);
            System.out.print("Reading frame starting with " + readingFrame + " results in ");
            System.out.print(count.size() + " unique codons\n");
            System.out.print("and most common codon is " + getMostCommonCodon() + " with count " + count.get(getMostCommonCodon()) + "\n");
            System.out.print("Counts of codons between " + start + " and " + end + " inclusive are: \n");
            printCodonCounts(start,end);
        }        
    }
}
