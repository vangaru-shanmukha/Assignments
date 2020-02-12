package edu.duke;

import java.util.*;
import edu.duke.*;

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
        String content = fr.asString();
        fr = new FileResource();
        HashSet<String> dictionary = readDictionary(fr);
        System.out.println(dictionary);
        String decrypted = breakForLanguage(content,dictionary);
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
    
    public String breakForLanguage(String encrypted,HashSet<String> dictionary)
    {
        int max = 0;
        String result = "";
        int dKey[] = null;
        for(int i=1;i<=100;i++)
        {
            int key[] = tryKeyLength(encrypted,i,'e');                                    
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
}
