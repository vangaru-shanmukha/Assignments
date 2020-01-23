package edu.duke;

import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of class CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1,int key2)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    public String encrypt(String input)
    {
        String result = "";
        String test1 = "";
        String test2 = "";
        for(int i=0;i<input.length();i++)
        {
            if(i%2==0)
            {
                test1 = test1 + input.charAt(i);
            }
            else
            {
                test2 = test2 + input.charAt(i);
            }
        }
        test1 = encrypt(test1,shiftedAlphabet1);
        test2 = encrypt(test2,shiftedAlphabet2);      
        result = merge(test1,test2);
        return result;
    }
    private String merge(String test1,String test2)
    {
        int n1 = test1.length();
        int n2 = test2.length();
        int i = 0, j = 0;
        String result = "";
        while(i < n1 && j < n2)
        {
            result = result + test1.charAt(i);
            result = result + test2.charAt(j);
            i = i + 1;
            j = j + 1;
        }
        while(i < n1)
        {
            result = result + test1.charAt(i);
            i = i + 1;
        }
        while(j < n2)
        {
            result = result + test2.charAt(j);
            j = j + 1;
        }
        return result;
        
    }
    private String encrypt(String input, String shiftedAlphabets)
    {
        String result = "";
        for(int i=0;i<input.length();i++)
        {
            boolean flag = Character.isLowerCase(input.charAt(i));
            int index = alphabet.indexOf(Character.toUpperCase(input.charAt(i)));
            if(index!=-1)
            {
                if(flag == true)
                    result = result + Character.toLowerCase(shiftedAlphabets.charAt(index));
                else
                    result = result + shiftedAlphabets.charAt(index);
            }
            else
            {
                result = result + input.charAt(i);
            }
        }
        return result;
    }
    public String decrypt(String input)
    {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1,26 - mainKey2);
        String decrypt = cc.encrypt(input);
        return decrypt;
    }
}
