
package webdictionary;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;


public class WebDictionary 
{
    ArrayList<String> index =  new ArrayList();
    HashMap<String,Integer> dictionary = new HashMap();
    
    public void generateIndex(String domain) throws IOException
    {
        Document doc = Jsoup.connect(domain).get();
        Elements links = doc.select("a[href]");
        for(Element e: links)
        {
            this.index.add(e.attr("abs:href"));
        }
    }
    public void displayIndex()
    {
        int i = 0;
        for(String links : index)
        {
            System.out.println(i+ " ." +links);
            i++;
        }
    }
    
    public void generateDict(String domain) throws IOException
    {
        Document doc = Jsoup.connect(domain).get();
        Elements paragraphs =  doc.select("p");
        for(Element para: paragraphs)
        {
            for(String lines: para.text().split("\\."))
            {
                for(String word: lines.split(" "))
                {
                    if(dictionary.containsKey(word))
                    {
                        dictionary.replace(word, dictionary.get(word)+1);
                    }  
                    else
                    {
                        dictionary.put(word, 1);
                    }
                }
            }           
        }
    }
    
    public void displayDict()
    {
        for(String s : this.dictionary.keySet())
        {
            System.out.println(s +  ":" + dictionary.get(s));
        }
    }
    
}
