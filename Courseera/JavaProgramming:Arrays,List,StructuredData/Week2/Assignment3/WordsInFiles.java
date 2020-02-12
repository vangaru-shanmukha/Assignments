package edu.duke;

import java.util.*;
import java.io.*;
/**
 * Write a description of class WordsInFiles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordsInFiles
{
    private HashMap<String,ArrayList<String>> words;
    public WordsInFiles()
    {
        words = new HashMap<String,ArrayList<String>>();
    }
    private void addWordsFromFile(File f)
    {
        FileResource fr = new FileResource(f);
        String s = fr.asString();
        String word[] = s.split(" ");      
        for(int i=0;i<word.length;i++)
        {
            if(words.containsKey(word[i]))
            {
                ArrayList<String> files = words.get(word[i]);
                files.add(f.getName());
                words.put(word[i],files);
            }
            else
            {
                ArrayList<String> files = new ArrayList<String>();
                files.add(f.getName());
                words.put(word[i],files);
            }
        }
    }
    public void buildWordFileMap()
    {
        words.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles())
        {
            addWordsFromFile(file);
        }
    }
    public int maxNumber()
    {
        int maxOccurrences = 0;
        for(Map.Entry<String,ArrayList<String>> map : words.entrySet())
        {
            String key = map.getKey();
            int value = map.getValue().size();
            if(maxOccurrences < value)
                maxOccurrences = value;
        }
        return maxOccurrences;
    }
    public ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> word = new ArrayList<String>();
        for(Map.Entry<String,ArrayList<String>> map : words.entrySet())
        {
            String key = map.getKey();
            int value = map.getValue().size();
            if(value == number)
                word.add(key);
        }
        return word;
    }
    public void printFileIn(String word)
    {
        for(Map.Entry<String,ArrayList<String>> map : words.entrySet())
        {
            String key = map.getKey();
            ArrayList<String> files = map.getValue();
            if(key.equals(word))
            {
                for(String s : files)
                    System.out.println(s);
            }
        }
    }
    public void tester()
    {
        buildWordFileMap();
        System.out.println("Maximum number of files any word is in : " + maxNumber());
        ArrayList<String> word = wordsInNumFiles(2);
        for(String s : word)
        {
            System.out.println(s + " : ");
            printFileIn(s);
        }   
    }
}
