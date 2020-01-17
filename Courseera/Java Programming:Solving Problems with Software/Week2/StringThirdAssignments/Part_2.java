/*

Problem Statement:

1. Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. 
   For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.

   Write a method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna. 

2. Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method processes all the strings in sr to find out information about them. Specifically, it should:

    print all the Strings in sr that are longer than 9 characters
    print the number of Strings in sr that are longer than 9 characters
    print the Strings in sr whose C-G-ratio is higher than 0.35
    print the number of strings in sr whose C-G-ratio is higher than 0.35
    print the length of the longest gene in sr

    Write a method testProcessGenes. This method will call your processGenes method on different test cases. Think of five DNA strings to use as test cases. 
    These should include: one DNA string that has some genes longer than 9 characters, one DNA string that has no genes longer than 9 characters, 
    one DNA string that has some genes whose C-G-ratio is higher than 0.35, and one DNA string that has some genes whose C-G-ratio is lower than 0.35. 
    Write code in testProcessGenes to call processGenes five times with StorageResources made from each of your five DNA string test cases.

3.  We have some real DNA for you to test your code on. Download the file brca1line.fa from the DukeLearnToProgram Project Resources page. 
    Make sure you save it in your BlueJ project so that your code can access it. 
    Modify your processGenes method so that it prints all the Strings that are longer than 60 characters and prints the number of Strings that are longer than 60 characters (you do not need to make changes to the rest of the method).
    Modify the method testProcessGenes to call processGenes with a StorageResource of the genes found in the file brca1line.fa.


*/
import java.util.*;
import edu.duke.*;
public class Part_2
{
    public double cgRatio(String dna)
    {
        int count = 0;
        for(int i=0;i<dna.length();i++)
        {
            if(dna.charAt(i)=='C' || dna.charAt(i)=='c')
                count = count + 1;
            else if(dna.charAt(i)=='G' || dna.charAt(i)=='g')
                count = count + 1;
        }
        return ((count*1.0)/(dna.length()*1.0));
    }
    public int countCTG(String dna)
    {
        int count = 0;
        int startIndex = 0;
        while(true)
        {
             if(startIndex < dna.length())
             {
                int currIndex = dna.indexOf("CTG",startIndex);
                if(currIndex==-1)
                    break;
                else
                {
                    count = count + 1;
                    startIndex = currIndex + 3;
                }
             }
             else
                break;
        }
        return count;
    }
    public void testcountCTG()
    {
        System.out.println(countCTG("CTGHYDCGTCTGGGGAACTG"));
    }
    public void testcgRatio()
    {
        String firstTestCase = "ATGCCATAG";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("cg ration: " + cgRatio(firstTestCase));
    }
    public void processGenes(StorageResource sr)
    {
        int maximum = 0;
        StorageResource longerString = new StorageResource();
        StorageResource cgRatioString = new StorageResource();
        for(String s : sr.data())
        {
            if(s.length()>60)
            {
                longerString.add(s);
            }
            if(cgRatio(s)>0.35)
            {
                cgRatioString.add(s);
            }
            maximum = Math.max(maximum,s.length());
        }
        System.out.println("Strings that are longer than 60 characters: " + longerString.size());
        for(String s : longerString.data())
            System.out.println(s);
        System.out.println("Strings having a cg ration higher than 0.35: " + cgRatioString.size());
        for(String s : cgRatioString.data())
            System.out.println(s);
        System.out.println("length of the longest gene is : " + maximum);
    }
    public void testProcessGenes()
    {
        StorageResource testCases = new StorageResource();
        testCases.add("CGATGATCGCATGATTCATGCTTAAATAAAGCTCA");
        testCases.add("CGATGATCCATGATTCATGCTTAAGATAAAGCTCA");
        FileResource fr = new FileResource("brca1line.fa");
        testCases.add(fr.asString().toUpperCase());
        for(String testCase : testCases.data())
        {
            StorageResource genes = new Part_1().getAllGenes(testCase);
            processGenes(genes);
        }
    }
}