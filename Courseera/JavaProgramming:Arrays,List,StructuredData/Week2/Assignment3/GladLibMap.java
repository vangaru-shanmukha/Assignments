package edu.duke;

import edu.duke.*;
import java.util.*;

public class GladLibMap {  
    private HashMap<String,ArrayList<String>> hashMap;
    private ArrayList<String> usedList; 
    private ArrayList<String> category;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "/home/vangaru/Downloads/data";
    
    public GladLibMap(){
        hashMap = new HashMap<String,ArrayList<String>>();
        category = new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        hashMap = new HashMap<String,ArrayList<String>>();
        category = new ArrayList<String>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String categories[] = {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
        for(String s : categories)
        {
            hashMap.put(s,readIt(source+"/"+s+".txt"));
        }        
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if(category.contains(label) == false)
            category.add(label);
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        String replace = randomFrom(hashMap.get(label));
        if(replace.equals(""))
            return "**UNKNOWN**";
        return replace;
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(usedList.contains(sub) == true)
        {
            sub = getSubstitute(w.substring(first+1,last));
        }
        usedList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    public int totalWordsInMap()
    {
        int total = 0;
        for(Map.Entry<String,ArrayList<String>> map : hashMap.entrySet())
        {
            total = total + map.getValue().size();
        }
        return total;
    }
    public int totalWordsConsidered()
    {
        int total = 0;
        for(Map.Entry<String,ArrayList<String>> map : hashMap.entrySet())
        {
            if(category.contains(map.getKey()))
                total = total + map.getValue().size();
        }
        return total;
    }
    public void makeStory(){
        System.out.println("\n");
        usedList = new ArrayList<String>();
        String story = fromTemplate("/home/vangaru/Downloads/data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println();
        System.out.println("Number of words replaced : " + usedList.size());
        System.out.println("Total number of words : " + totalWordsInMap());
        System.out.println(category.size());
        System.out.println("Total number of words used : " + totalWordsConsidered());
    }
}
