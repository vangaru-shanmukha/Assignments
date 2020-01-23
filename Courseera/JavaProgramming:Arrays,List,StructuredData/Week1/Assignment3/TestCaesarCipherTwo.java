package edu.duke;

import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of class TestCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo
{
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String content = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);        
        System.out.println("Contents of file : " + content);
        String encrypted = cc.encrypt(content);
        System.out.println("Encrypted string : " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted string : " + decrypted);
        System.out.println("===============================");
        System.out.println("Encrypted string : " + encrypted);
        breakCaesarCipher(encrypted);
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
    public void breakCaesarCipher(String input)
    {
        String test1 = halfOfString(input,0);
        String test2 = halfOfString(input,1);
        int dKey1 = getKey(test1);
        int dKey2 = getKey(test2);
        System.out.println(dKey1 + " " + dKey2);
        CaesarCipherTwo cc = new CaesarCipherTwo(dKey1,dKey2);
        String decrypted = cc.decrypt(input);
        System.out.println("Decrypted string : " + decrypted);
    }
}
