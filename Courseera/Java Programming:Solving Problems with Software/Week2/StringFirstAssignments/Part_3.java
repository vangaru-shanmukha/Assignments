/*

This assignment will give you additional practice using String methods. You will write two methods to solve some problems using strings and a third method to test these two methods.

Specifically, you should do the following:

1.  Create a new Java Class named Part3 in the StringsFirstAssignments project. Put the following methods in this class.

2.  Write the method named twoOccurrences that has two String parameters named stringa and stringb. This method returns true if stringa appears at least twice in stringb, otherwise it returns false. 
    For example, the call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”, the call twoOccurrences(“a”, “banana”) returns true as there are three occurrences 
    of “a” so “a” occurs at least twice, and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one occurence of “atg”.

3.  Write the void method named testing that has no parameters. This method should call twoOccurrences on several pairs of strings and print the strings and the result of calling twoOccurrences (true or false) for each pair. 
    Be sure to test examples that should result in true and examples that should result in false.

4.  Write the method named lastPart that has two String parameters named stringa and stringb. This method finds the first occurrence of stringa in stringb, and returns the part of stringb that follows stringa. 
    If stringa does not occur in stringb, then return stringb. For example, the call lastPart(“an”, “banana”) returns the string “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) 
    returns the string “forest” since “zoo” does not appear in that word.

5. Add code to the method testing to call the method lastPart with several pairs of strings. For each call print the strings passed in and the result. For example, the output for the two calls above might be:

    The part of the string after an in banana is ana.
    The part of the string after zoo in forest is forest.
*/
import java.util.*;
public class Part_3
{
    private boolean twoOccurrences(String stringa,String stringb)
    {
        boolean result = false;
        int startIndex = 0;
        int count = 0;
        while(true)
        {
            if(startIndex < stringb.length())
            {
                int currIndex = stringb.indexOf(stringa,startIndex);
                if(currIndex==-1)
                    break;
                else
                {
                    count = count + 1;
                    startIndex = currIndex + stringa.length();
                }
            }
            else
                break;
        }
        if(count>=2)
            result = true;
        return result;
    }
    private String lastPart(String stringa,String stringb)
    {
        String result = "";
        int startIndex = stringb.indexOf(stringa);
        if(startIndex==-1)
        {
            result = stringb;
        }
        else
        {
            result = stringb.substring(startIndex + stringa.length());
        }
        return result;
    }
    public void testing()
    {
        String stringa = "by";
        String stringb = "A story by Abby Long";
        System.out.println("stringa: " + stringa);
        System.out.println("stringb: " + stringb);
        System.out.println("toOccurrences: " + twoOccurrences(stringa,stringb));
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println("stringa: " + stringa);
        System.out.println("stringb: " + stringb);
        System.out.println("toOccurrences: " + twoOccurrences(stringa,stringb));
        stringa = "an";
        stringb = "banana";
        System.out.println("stringa: " + stringa);
        System.out.println("stringb: " + stringb);
        System.out.println("Result string: " + lastPart(stringa,stringb));
        stringa = "zoo";
        stringb = "forest";
        System.out.println("stringa: " + stringa);
        System.out.println("stringb: " + stringb);
        System.out.println("Result string: " + lastPart(stringa,stringb));
    }
}