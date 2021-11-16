import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Article extends Word
{
  private static final String file = "Word Bank/articles.txt";
  
  public static ArrayList<Word> readFile(){
    ArrayList<Word> info = new ArrayList<Word>();
    
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        info.add(new Article(fileReader.next()));
      }//ends while
      fileReader.close();
      //System.out.println("words loaded from "+file);
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors

    return info;
  }





public static  readFile(String file)
  {
    
  }//ends readFile









  public Article(String word)
  {
    super(word);
  }//ends constructor
}//ends Article class