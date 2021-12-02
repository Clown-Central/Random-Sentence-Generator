package WordStuff;
import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Adjective extends Word
{


  private static final String file = "Word Bank/adjectives.txt";
  private static ArrayList<Adjective> list = new ArrayList<Adjective>(); 




  public Adjective(String word)
  {
    super(word,"Adjective");
  }




  public static Adjective getNew()
  {
    if(list.size()==0)
    {
      readFile();
    }
    return list.get((int)(Math.random()*list.size()));
  }




  /* Description: Read file
   * @post: list now contains words from word bank
  */
  private static void readFile(){
    try
    {
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
        {
          list.add(new Adjective(fileReader.next()));
        }
      fileReader.close();
    }
    catch (IOException e)
    {
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors
  }//ends readFile

}