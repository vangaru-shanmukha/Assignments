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
        int key[] = tryKeyLength(content,5,'e');
        VigenereCipher vc = new VigenereCipher(key);    
        System.out.println("Decrypted string:");
        System.out.println(vc.decrypt(content));
    }
    
}
