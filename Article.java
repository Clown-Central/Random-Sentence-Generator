import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Article extends Word
{
  public static ArrayList<Article> list = new ArrayList<Article>();

  public Article(String word)
  {
    super(word);
  }//ends constructor

  private static final String file = "Word Bank/articles.txt";
  
  public static ArrayList<Article> readFile(){
    ArrayList<Article> info = new ArrayList<Article>();
    
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
  }//ends readFile

  /* Description: Gets word from file
   * @pre ArrayList<Word> list
   * @param ArrayList<Word> list
   * @return Word word
   */
  public static Article getNew()
  {
    return list.get((int)(Math.random()*list.size()));
  }//ends method

}//ends Article class