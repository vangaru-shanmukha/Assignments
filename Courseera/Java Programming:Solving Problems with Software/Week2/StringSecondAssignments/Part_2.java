/*

Problem Statement:

This assignment will write a method to determine how many occurrences of a string appear in another string.

Specifically, you should do the following:

1. Create a new Java Class named Part2in the StringsSecondAssignments project.

2. Write the method named howMany that has two String parameters named stringa and stringb. 
   This method returns an integer indicating how many times stringa appears in stringb, where each occurrence of stringa must not overlap with another occurrence of it. 
   For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs 3 times. The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.

3. Write the void method testHowMany has no parameters. Add code in here to call howMany with several examples and print the results. 
   Think carefully about what types of examples would be good to test to make sure your method works correctly.
*/
import java.util.*;
public class Part_2
{
    public int howMany(String stringa,String stringb)
    {
        int currIndex = 0;
        int startIndex = 0;
        int count = 0;
        while(true)
        {
            currIndex = stringb.indexOf(stringa,startIndex);
            if(currIndex!=-1)
            {
                count = count + 1;
                startIndex = currIndex + stringa.length();
            }
            else
                break;
        }
        return count;
    }
    public void testHowMany()
    {
        System.out.println("Testcase: 1");
        System.out.println("stringa: GAA");
        System.out.println("stringb: ATGAACGAATTGAATC");
        System.out.println("No.of occurrences: " + howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println("Testcase: 2");
        System.out.println("stringa: AA");
        System.out.println("stringb: ATAAAA");
        System.out.println("No.of occurrences: " + howMany("AA","ATAAAA"));
    }
}