/*

Problem Statement:
This assignment is to write the code from the lesson to use a StorageResource to store the genes you find instead of printing them out. 
This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. 
If you get stuck, then you can go back and watch the coding videos that go with this lesson again.

Specifically, you should do the following:

1. Create a new Java project named StringsThirdAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. Copy and paste the code from your Part1 class in your StringsSecondAssignments project into this class.

3. Make a copy of the printAllGenes method called getAllGenes. Instead of printing the genes found, this method should create and return a StorageResource containing the genes found. 
   Remember to import the edu.duke libraries otherwise you will get an error message cannot find the class StorageResource.

4. Make sure you test your getAllGenes method.
*/
import java.util.*;
import edu.duke.*;
public class Part_1
{
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        int currIndex = dna.indexOf(stopCodon,startIndex + 3);
        while(currIndex!=-1)
        {
            if((currIndex-startIndex)%3 == 0)
            {
                return currIndex + stopCodon.length();
            }
            else
            {
                currIndex = dna.indexOf(stopCodon,currIndex + 1);
            }
        }
        return dna.length();
    }
    public String findGene(String dna)
    {
        int startIndex = dna.indexOf("ATG");
        if(startIndex < 0)
            return "";
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int atgIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = (taaIndex<tagIndex)?((taaIndex<atgIndex)?taaIndex:atgIndex):((tagIndex<atgIndex)?tagIndex:atgIndex);
        if(minIndex==dna.length())
            return "";
        return dna.substring(startIndex,minIndex);
    }
    public void testFindGene()
    {
        String firstTestCase = "ATCTAATAGCCCTAGGG";
        System.out.println("DNA string: " + firstTestCase);
        System.out.println("Gene: " + findGene(firstTestCase));
        String secondTestCase = "GCAATGTTTTATAGTAAT";
        System.out.println("DNA string: " + secondTestCase);
        System.out.println("Gene: " + findGene(secondTestCase));
        String thirdTestCase = "ATGCCCTAACCCTAGAACATG";
        System.out.println("DNA string: " + thirdTestCase);
        System.out.println("Gene: " + findGene(thirdTestCase));
        String fourthTestCase = "ATGCCCAATCCAAAAAGAT";
        System.out.println("DNA string: " + fourthTestCase);
        System.out.println("Gene: " + findGene(fourthTestCase));
    }
    public void printAllGenes(String dna)
    {
        while(true)
        {
            String gene = findGene(dna);
            if(gene.equals(""))
            {
                break;
            }
            else
            {
                System.out.println(gene);
                dna = dna.substring(dna.indexOf(gene)+gene.length()-1);
            }
        }
    }
    public StorageResource getAllGenes(String dna)
    {
        StorageResource stgr = new StorageResource();
        while(true)
        {
            String gene = findGene(dna);
            if(gene.equals(""))
            {
                break;
            }
            else
            {
                stgr.add(gene);
                dna = dna.substring(dna.indexOf(gene)+gene.length()-1);
            }
        }
        return stgr;
    }
    public void testAllGenes()
    {
        String firstTestCase = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("Genes: ");
        printAllGenes(firstTestCase);
    }
    public void testgetAllGenes()
    {
        String firstTestCase = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("Genes: ");
        StorageResource arr = getAllGenes(firstTestCase);
        for(String s : arr.data())
        {
            System.out.println(s);
        }
    }
    public static void main(String args[])
    {
        new Part_1().testgetAllGenes();
    }
}