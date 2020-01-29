package edu.duke;

import java.util.*;
/**
 * Write a description of class CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharactersInPlay
{
    private ArrayList<String> characters;
    private ArrayList<Integer> freqs;
    public CharactersInPlay()
    {
        characters = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    public void update(String person)
    {
        if(characters.contains(person))
        {
            int value = freqs.get(characters.indexOf(person));
            freqs.set(characters.indexOf(person),value + 1);
        }
        else
        {
            characters.add(person);
            freqs.add(1);
        }
    }
    public void findAllCharacters()
    {
        characters.clear();
        freqs.clear();
        FileResource fr = new FileResource();
        for(String s : fr.lines())
        {
            int index = s.indexOf(".");
            if(index != -1)
            {
                String character = s.substring(0,index);
                update(character);
            }
        }
        for(int i=0;i<characters.size();i++)
        {
            if(freqs.get(i) > 1)
                System.out.println(characters.get(i) + " " + freqs.get(i));
        }
    }
    public void charactersWithNumParts(int num1, int num2)
    {
        for(int i=0;i<characters.size();i++)
        {
            if(freqs.get(i) >= num1 && freqs.get(i) <= num2)
            {
                System.out.println(characters.get(i));
            }
        }
    }
    public void tester()
    {
        findAllCharacters();
        charactersWithNumParts(2,3);
    }
}
