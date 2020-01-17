/*
Problem Statement:

Write a program to count how many genes are in a strand of DNA.

Specifically, you should do the following:

1. Create a new Java Class named Part3 in the StringsSecondAssignments project. Put the following methods in this class.

2. Copy your methods from Part1 to find one gene and print all genes.

3. Write the method named countGenes that has a String parameter named dna representing a string of DNA. 
   This method returns the number of genes found in dna. For example the call countGenes(“ATGTAAGATGCCCTAGT”) returns 2, finding the gene ATGTAA first and then the gene ATGCCCTAG. 

4. Write the void method named testCountGenes that has no parameters. This method calls countGenes with many example strings and prints the result for each. 
   You should create several examples with different numbers of genes to test your code.

*/
import java.util.*;
public class Part_3
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
    public int countGenes(String dna)
    {
        int count=0;
        while(true)
        {
            String gene = findGene(dna);
            if(gene.equals(""))
            {
                break;
            }
            else
            {
                count = count + 1;
                dna = dna.substring(dna.indexOf(gene)+gene.length()-1);
            }
        }
        return count;
    }
    public void testCountGenes()
    {
        String firstTestCase = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("Number of Genes: " + countGenes(firstTestCase));
    }
}