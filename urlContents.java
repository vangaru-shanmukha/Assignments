/*
    Problem Statement:
        Write a program that reads the lines from the file at this URL location, http://www.dukelearntoprogram.com/course2/data/manylinks.html, 
        and prints each URL on the page that is a link to youtube.com. Assume that a link to youtube.com has no spaces in it and would be in the 
        format (where [stuff] represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”

*/
import java.net.*;
import java.io.*;
public class urlContents
{
    public static void main(String[] args)
    {
        getUrlContents("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    private static String getUrl(String originalUrl,String tempUrl)
    {
        int index = tempUrl.indexOf("youtube");
        int startQuote = 0;
        int endQuote = 0;
        for(int i=index;i>=0;i--)
        {
            if(tempUrl.charAt(i)=='\"')
            {
                startQuote = i;
                break;
            }
        }
        for(int i=index+1;i<tempUrl.length();i++)
        {
            if(tempUrl.charAt(i)=='\"')
            {
                endQuote = i;
                break;
            }
        }
        return originalUrl.substring(startQuote,endQuote+1);
    }
    private static void getUrlContents(String theUrl)
    {
        try
        {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String originalUrl;
            while ((originalUrl = bufferedReader.readLine()) != null)
            {
                String tempUrl = originalUrl.toLowerCase();
                if(tempUrl.contains("youtube.com"))
                {
                    String urls = getUrl(originalUrl,tempUrl);
                    System.out.println(urls);
                }
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
