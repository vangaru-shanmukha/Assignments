package edu.duke;

import edu.duke.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class CaesarBreaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarBreaker
{
    private String decrypt(String encrypted, int key)
    {
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
    }
    private String halfOfString(String message, int start)
    {
        String result = "";
        for(int i=start;i < message.length();i = i + 2)
        {
            result = result + message.charAt(i);
        }
        return result;
    }
    private int[] countLetters(String s)
    {
        int frequency[] = new int[27];
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch) == true)
            {
                char c = Character.toLowerCase(ch);
                frequency[(int)(c)-97] = frequency[(int)(c)-97] + 1;
            }
        }
        return frequency;
    }
    private int maxIndex(int[] frequency)
    {
        int max = 0;
        int index = 0;
        for(int i=0;i<frequency.length;i++)
        {
            if(max < frequency[i])
            {
                max = frequency[i];
                index = i;
            }
        }
        return index;
    }
    private int getKey(String s)
    {
        int frequency[] = countLetters(s);
        int maxIndex = maxIndex(frequency);
        int dKey = maxIndex - 4;
        if(maxIndex < 4)
            dKey = 26 - (4 - maxIndex);
        return dKey;
    }
    private String decryptTwoKeys(String encrypted)
    {
        String firstHalf = halfOfString(encrypted,0);
        String secondHalf = halfOfString(encrypted,1);
        int dKey1 = getKey(firstHalf);
        int dKey2 = getKey(secondHalf);
        System.out.println("Decryption key1 : " + dKey1 + "\nDecryption key2 : " + dKey2);
        CaesarCipher cc = new CaesarCipher();
        String decrypted = cc.encryptTwoKeys(encrypted,26 - dKey1,26 - dKey2);
        return decrypted;
    }
    public void testDecryptTwoKeys()
    {
        String test = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        System.out.println("Encrypted string : " + test);
        System.out.println(decryptTwoKeys(test));
    }
    public void testGetKey()
    {
        System.out.println("Key : " + getKey("hello world z"));
    }
    public void testHalfOfString()
    {
        String test = "Qbkm Zgis";
        System.out.println("Original string : " + test);
        System.out.println("First half of string : " + halfOfString(test,0));
        System.out.println("Second half of string : " + halfOfString(test,1));
    }
    public void testDecrypt()
    {
        String encrypted = "Cfopq Ibdflk";
        int key = 23;
        String decrypted = decrypt(encrypted, key);
        System.out.println("Encrypted message : " + encrypted);
        System.out.println("Decrypted message : " + decrypted);
    }
}
