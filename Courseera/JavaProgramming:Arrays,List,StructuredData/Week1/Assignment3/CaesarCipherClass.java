package edu.duke;

import edu.duke.*;
import java.util.*;
import java.io.*;

/**
 * Write a description of class CaesarCipherClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherClass
{
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipherClass(int key)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    public String encrypt(String input)
    {
        String result = "";
        for(int i=0;i<input.length();i++)
        {
            boolean flag = Character.isLowerCase(input.charAt(i));
            int index = alphabet.indexOf(Character.toUpperCase(input.charAt(i)));
            if(index!=-1)
            {
                if(flag == true)
                    result = result + Character.toLowerCase(shiftedAlphabet.charAt(index));
                else
                    result = result + shiftedAlphabet.charAt(index);
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
        CaesarCipherClass cc = new CaesarCipherClass(26 - mainKey);
        String message = cc.encrypt(input);
        return message;
    }
}
