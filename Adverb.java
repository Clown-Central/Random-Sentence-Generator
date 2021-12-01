import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Adverb extends Word
{



  private static final String file = "Word Bank/Adverbs.txt";
  private static ArrayList<Adverb> list = new ArrayList<Adverb>(); 




  public Adverb(String word)
  {
    super(word,"Adverb");
  }




  public static Adverb getNew()
  {
    if(list.size()==0) readFile();
    return list.get((int)(Math.random()*list.size()));
  }




  /* Description: Read file
   * @post: list now contains words from word bank
  */
  private static void readFile(){
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
        list.add(new Adverb(fileReader.next()));
      fileReader.close();
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors
  }//ends readFile

}