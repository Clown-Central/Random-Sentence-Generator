import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Article extends Word
{
  private static final String file = "Word Bank/articles.txt";
  private static ArrayList<Article> list = new ArrayList<Article>();

  public Article(String word)
  {
    super(word);
  }//ends constructor

  public static void readFile(){
    
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        list.add(new Article(fileReader.next()));
      }//ends while
      fileReader.close();
      //System.out.println("words loaded from "+file);
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors

  }//ends readFile

  /* Description: Gets word from file
   * @pre ArrayList<Word> list
   * @param ArrayList<Word> list
   * @return Word word
   */
  public static Article getNew()
  {
    if(list.size()==0) readFile();
    return list.get((int)(Math.random()*list.size()));
  }//ends method

}//ends Article class