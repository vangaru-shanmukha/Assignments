package edu.duke;

import edu.duke.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class WordLengths here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordLengths
{
    private int getLength(String s)
    {
        int length = 0;
        if(Character.isLetter(s.charAt(0)) == true)
        {
            length = length + 1;
        }
        if(Character.isLetter(s.charAt(s.length()-1)) == true)
        {
            length = length + 1;
        }
        length = length + (s.length()-2);
        return length;
    }
    private void countWordLengths(FileResource resource,int[] counts)
    {
        String content = resource.asString();
        String words[] = content.split(" ");
        for(int i=0;i<words.length;i++)
        {
            int length = getLength(words[i]);
            if(length >= counts.length)
                length = counts.length - 1;
            counts[length] = counts[length] + 1;
        }
        for(int i=0;i<counts.length;i++)
            System.out.println(counts[i] + " words of length " + i);
    }
    private int indexOfMax(int[] values)
    {
        int max = 0;
        int index = 0;
        for(int i=0;i<values.length;i++)
        {
            if(values[i] > max)
            {
                max = values[i];
                index = i;
            }
        }
        return index;
    }
    public void testCountWordLengths()
    {
        FileResource resource = new FileResource();
        int counts[] = new int[31];
        countWordLengths(resource,counts);
        int index = indexOfMax(counts);
        System.out.println(index);
    }
}
