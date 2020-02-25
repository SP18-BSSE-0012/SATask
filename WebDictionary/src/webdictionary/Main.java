
package webdictionary;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the url of website to create dictionary of");
        String url = input.nextLine();
        WebDictionary dict1 = new WebDictionary();
        dict1.generateIndex(url);
        dict1.generateDict(url);
        dict1.displayDict();
        dict1.displayIndex();
        int num = 0;
        while(num!=-1)
        {
            System.out.println("Please enter the number of the link you want to add to the dictionary from or press -1 to escape");
            num = input.nextInt();
            if(num != -1)
            {
                dict1.generateDict(dict1.index.get(num));
            }
            dict1.displayDict();
        }
    }
}
