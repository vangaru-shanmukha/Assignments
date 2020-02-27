package edu.duke;

import java.util.*;
/**
 * Write a description of class WordFrequencies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s : fr.words())
        {
            s = s.toLowerCase();
            if(! myWords.contains(s))
            {
                myWords.add(s);
                myFreqs.add(1);
            }
            else
            {
                int value = myWords.indexOf(s);
                myFreqs.set(value,myFreqs.get(value) + 1);
            }
        }
        System.out.println("Number of unique words : " + myWords.size());
        for(int i=0;i<myWords.size();i++)
        {
            System.out.println(myWords.get(i) + " : " + myFreqs.get(i));
        }
    }
    public int findIndexOfMax()
    {
        int max = 0;
        int index = 0;
        for(int i=0;i<myFreqs.size();i++)
        {
            if(max < myFreqs.get(i))
            {
                max = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }
    public void tester()
    {
        findUnique();
        System.out.println("Most occurred word : " + myWords.get(findIndexOfMax()));
        System.out.println("Number of occurrences : " + myFreqs.get(findIndexOfMax()));
    }
}
