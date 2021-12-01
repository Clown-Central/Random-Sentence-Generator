import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Noun extends Word
{



  private static final String file = "Word Bank/nouns.txt";
  private static ArrayList<Noun> list = new ArrayList<Noun>();  



  /* Description: Noun constructor
   * @pre: String word
   * @param: String word
   * @return: none
  */
  public Noun(String word)
  {
    super(word,"Noun");
  }//ends constructor



  /* Description: Gets word from file
   * @pre: none
   * @param: none
   * @return: word from file
  */
  public static Noun getNew()
  {
    if(list.size()==0) readFile();
      return list.get((int)(Math.random()*list.size()));
  }//ends getNew() method



 
  /* Description: Read file
   * @post: list now contains words from word bank
  */
  private static void readFile(){
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
        list.add(new Noun(fileReader.next()));
      fileReader.close();
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors
  }//ends readFile
}//ends Noun class