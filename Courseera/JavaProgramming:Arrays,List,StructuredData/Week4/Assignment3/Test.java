package edu.duke;


/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public void testCaesarCipher()
    {
        FileResource fr = new FileResource();
        String text = fr.asString();
        CaesarCipher2 cc = new CaesarCipher2(3);
        String encrypted = cc.encrypt(text);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));        
    }
    public void testCaesarCracker()
    {
        FileResource fr = new FileResource();
        String text = fr.asString();
        CaesarCracker cc = new CaesarCracker('a');
        int dKey = cc.getKey(text);
        System.out.println(cc.decrypt(text));
    }
    public void testVigenereCipher()
    {
        FileResource fr = new FileResource();
        String text = fr.asString();
        int key[] = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(key);
        String encrypted = vc.encrypt(text);
        System.out.println(encrypted);
        System.out.println(vc.decrypt(encrypted));
    }
    public void testVigenereBreaker()
    {
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        String text = fr.asString();
        int key[] = vb.tryKeyLength(text,5,'e');
        for(int i=0;i<key.length;i++)
            System.out.println(key[i]);        
    }
    public void testbreakVigenere()
    {
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere();
    }
}
