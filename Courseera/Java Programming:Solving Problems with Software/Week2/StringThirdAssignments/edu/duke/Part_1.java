package edu.duke;
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
    public void testGetAllGenes()
    {
        String firstTestCase = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("Genes: ");
        StorageResource stgr = getAllGenes(firstTestCase);
        for(String s : stgr.data())
        {
            System.out.println(s);
        }
    }
    public static void main(String args[])
    {
        new Part_1().testGetAllGenes();
    }
}