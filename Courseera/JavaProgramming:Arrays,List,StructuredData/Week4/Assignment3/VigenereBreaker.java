package edu.duke;

import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String result = "";
        for(int i=whichSlice;i<message.length();i = i + totalSlices)
        {
            result = result + message.charAt(i);
        }
        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        int k = 0;
        for(int i=0;i<klength;i++)
        {
            String s1 = sliceString(encrypted,i,klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[k] = cc.getKey(s1);
            k++;
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        DirectoryResource dr = new DirectoryResource();
        HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
        for(File file : dr.selectedFiles())
        {
            String name = file.getName();
            String language = name.substring(0,name.length()-4);
            fr = new FileResource(file);
            HashSet<String> dictionary = readDictionary(fr);
            languages.put(language,dictionary);
        }
        String decrypted = breakForAllLanguages(encrypted,languages);
        System.out.println("Decrypted string:");
        System.out.println(decrypted);
    }
    
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> words = new HashSet<String>();
        for(String s : fr.lines())
        {
            words.add(s.toLowerCase());
        }
        return words;
    }
    
    public int countWords(String message,HashSet<String> words)
    {
        String word[] = message.split(" ");
        int count = 0;
        for(String s : word)
        {
            if(words.contains(s))
                count = count + 1;
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted,HashSet<String> dictionary,char mostCommonChar)
    {
        int max = 0;
        String result = "";
        int dKey[] = null;
        for(int i=1;i<=100;i++)
        {
            int key[] = tryKeyLength(encrypted,i,mostCommonChar);                                    
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted,dictionary);
            if(count > max)
            {                
                max = count;
                result = decrypted; 
                dKey = key;
            }
        }
        for(int j=0;j<dKey.length;j++)
            System.out.print(dKey[j] + " ");
        System.out.println();
        return result;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary)
    {
        HashMap<String,Integer> chars = new HashMap<String,Integer>();
        int max = 0;
        char character = 'c';
        for(String s : dictionary)
        {
            for(int i=0;i<s.length();i++)
            {
                String c = s.charAt(i) + "";
                if(chars.containsKey(c))
                {
                    int count = chars.get(c)+1;
                    chars.put(c,count);
                    if(count > max)
                    {
                        max = count;
                        character = c.charAt(0);
                    }
                }
                else
                {
                    chars.put(c,1);
                    if( 1 > max )
                    {
                        max = 1;
                        character = c.charAt(0);
                    }
                }
            }
        }
        return character;        
    }
    
    public String breakForAllLanguages(String encrypted,HashMap<String,HashSet<String>> languages)
    {
        int max = 0;
        String result = "";
        for(Map.Entry<String,HashSet<String>> map : languages.entrySet())
        {
            String language = map.getKey();
            HashSet<String> dictionary = map.getValue();
            char mostCommonChar = mostCommonCharIn(dictionary);
            String decrypted = breakForLanguage(encrypted,dictionary,mostCommonChar);
            int count = countWords(decrypted,dictionary);
            if( count > max )
            {
                max = count;
                result = decrypted;
            }
        }
        return result;
    }
}
