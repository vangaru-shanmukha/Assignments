package edu.duke;
import edu.duke.*;
import java.io.*;
import java.util.*;

/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    private boolean isVowel(char ch)
    {
        boolean result = false;
        ch = Character.toLowerCase(ch);
        if(ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u')
            result = true;
        return result;
    }
    private String replaceVowels(String phrase,char ch)
    {
        String result = "";
        for(int i=0;i<phrase.length();i++)
        {
            char c = phrase.charAt(i);
            if(isVowel(c))
                result = result + ch;
            else
                result = result + c;
        }
        return result;
    }
    private String emphasize(String phrase,char ch)
    {
        String result = "";
        for(int i=0;i<phrase.length();i++)
        {
            if(Character.toLowerCase(phrase.charAt(i)) == Character.toLowerCase(ch))
            {
                if(i%2!=0)
                {
                    result = result + "+";
                }
                else
                {
                    result = result + "*";
                }
            }
            else
                result = result + phrase.charAt(i);
        }
        return result;
    }
    public void testEmphasize()
    {
        String test1 = "dna ctgaaactga";
        String test2 = "Mary Bella Abracadabra";
        char replaceChar = 'a';
        System.out.println("Original string : " + test1);
        System.out.println("Replacing char : " + replaceChar);
        System.out.println("Modified string : " + emphasize(test1,replaceChar));
        System.out.println("Original string : " + test2);
        System.out.println("Replacing char : " + replaceChar);
        System.out.println("Modified string : " + emphasize(test2,replaceChar));
    }
    public void testReplaceVowels()
    {
        String test1 = "Hello World";
        System.out.println("Original string : " + test1);
        System.out.println("Modified string : " + replaceVowels(test1,'*'));        
    }
    public void testIsVowel()
    {
        char test1 = 'F';
        char test2 = 'A';
        System.out.println("Is " + test1 + " vowel? - " + isVowel(test1));
        System.out.println("Is " + test2 + " vowel? - " + isVowel(test2));
    }
}
