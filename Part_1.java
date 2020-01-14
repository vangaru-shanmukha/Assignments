/*
    1. Create a new Java Class named Part1. The following methods go in this class.

    2. Write the method findSimpleGene that has one String parameter dna, representing a string of DNA. This method does the following:

            Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
            Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string.
            If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.

    3. Write the void method testSimpleGene that has no parameters. You should create five DNA strings. 
       The strings should have specific test cases, such as: DNA with no “ATG”, DNA with no “TAA”, DNA with no “ATG” or “TAA”, DNA with ATG, TAA and the substring between 
       them is a multiple of 3 (a gene), and DNA with ATG, TAA and the substring between them is not a multiple of 3. For each DNA string you should:

    Print the DNA string.
    See if there is a gene by calling findSimpleGene with this string as the parameter. 
    If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.


    4. The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start 
       codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.

    5. Modify the findSimpleGene method to work with DNA strings that are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. 
       Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return the answer with lowercase letters,
        the gene “atgctataa”. HINT: there are two string methods toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.
*/

public class Part_1
{
    private boolean isLower(String dna)
    {
        if(Character.isLowerCase(dna.charAt(0)))
            return true;
        else
            return false;
    }
    private String findSimpleGene(String dna,String startCodon,String stopCodon)
    {
        String result = "";
        int startPos = 0;
        int endPos = 0;
        if(isLower(dna))
        {
            startPos = dna.indexOf(startCodon.toLowerCase());
            if(startPos > 0)
            {
                endPos = dna.indexOf(stopCodon.toLowerCase(), startPos + startCodon.length());
                if(endPos > 0)
                {
                    if(dna.substring(startPos+startCodon.length(),endPos).length()%3==0)
                    {
                        result = dna.substring(startPos,endPos + stopCodon.length());
                    }
                }
            }
        }
        else
        {
            startPos = dna.indexOf(startCodon.toUpperCase());
            if(startPos > 0)
            {
                endPos = dna.indexOf(stopCodon.toUpperCase(), startPos + startCodon.length());
                if(endPos > 0)
                {
                    if(dna.substring(startPos+startCodon.length(),endPos).length()%3==0)
                    {
                        result = dna.substring(startPos,endPos + stopCodon.length());
                    }
                }
            }
        }
        return result;
    }
    public void testSimpleGene()
    {
        String firstTestCase = "AAATTGTATCCATTAA";
        String secondTestCase = "TTTTAAACGATTTCCGATG";
        String thirdTestCase = "TTTTTTTTAAAAAAGGGGGGGTCGTA";
        String fourthTestCase = "TAAGTTTAGATGTTTAGTTAAATGTTTTAGCTT";
        String fifthTestCase = "ATGTTTTTGCCCTTTTTAATTTTGC";
        String sixthTestCase = "gatgctataat";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(firstTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + secondTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(secondTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + thirdTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(thirdTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + fourthTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(fourthTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + fifthTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(fifthTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + sixthTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(sixthTestCase,startCodon,stopCodon));
    }
}
