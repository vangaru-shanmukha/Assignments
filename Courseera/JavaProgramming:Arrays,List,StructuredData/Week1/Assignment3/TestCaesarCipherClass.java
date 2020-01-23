package edu.duke;

import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of class TestCaesarCipherClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCipherClass
{
    public int[] countLetters(String s)
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
    public int maxIndex(int[] frequency)
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
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String text = fr.asString();
        CaesarCipherClass cc = new CaesarCipherClass(18);
        String encrypted = cc.encrypt(text);
        System.out.println("Encrypted string : " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted string : " + decrypted);
        breakCaesarCipher(encrypted);        
    }
    public void breakCaesarCipher(String input)
    {
        int[] freqs = countLetters(input);
        int maxIndex = maxIndex(freqs);
        int dKey = maxIndex - 4;
        if(maxIndex < 4)
            dKey = 26 - (4 - maxIndex);
        CaesarCipherClass cc = new CaesarCipherClass(dKey);
        String decrypted = cc.decrypt(input);
        System.out.println("Decrypted message : " + decrypted);
    }
}
