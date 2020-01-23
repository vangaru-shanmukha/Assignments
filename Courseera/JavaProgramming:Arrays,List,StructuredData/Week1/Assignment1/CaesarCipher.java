package edu.duke;

import edu.duke.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    private String encrypt(String input,int key)
    {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabets = alphabets.substring(key) + alphabets.substring(0,key);
        String result = "";
        for(int i=0;i<input.length();i++)
        {
            boolean flag = Character.isLowerCase(input.charAt(i));
            int index = alphabets.indexOf(Character.toUpperCase(input.charAt(i)));
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
    private String encryptTwoKeys(String input,int key1,int key2)
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
        test1 = encrypt(test1,23);
        test2 = encrypt(test2,17);
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
    public void testEncryptTwoKeys()
    {
        String test = "First Legion";
        int key1 = 23;
        int key2 = 17;
        System.out.println("Original string : ");
        System.out.println("Key 1: " + key1);
        System.out.println("Key 2: " + key2);
        System.out.println("Encrypted string : " + encryptTwoKeys(test,key1,key2));
    }
    public void testCaesar()
    {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;
        String encrypted = encrypt(message,key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    public void testEncrypt()
    {
        String test1 = "FIRST LEGION ATTACK EAST FLANK!";
        int key1 = 23;
        System.out.println("Original string: " + test1);
        System.out.println("Key : " + key1);
        System.out.println("Encrypted string : " + encrypt(test1,key1));
        String test2 = "First Legion";
        int key2 = 23;
        System.out.println("Original string: " + test2);
        System.out.println("Key : " + key2);
        System.out.println("Encrypted string : " + encrypt(test2,key2));
        String test3 = "First Legion";
        int key3 = 17;
        System.out.println("Original string: " + test3);
        System.out.println("Key : " + key3);
        System.out.println("Encrypted string : " + encrypt(test3,key3));
    }
}
