import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Noun extends Word
{

  public Noun(String word)
  {
    super(word);
  }//ends constructor

  private static final String file = "Word Bank/nouns.txt";
  
  public static ArrayList<Word> readFile(){
    ArrayList<Word> info = new ArrayList<Word>();
    
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        info.add(new Noun(fileReader.next()));
      }//ends while
      fileReader.close();
      //System.out.println("words loaded from "+file);
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors

    return info;
  }//ends readFile
}//ends Noun class