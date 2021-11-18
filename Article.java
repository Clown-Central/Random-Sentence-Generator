import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Article extends Word
{

  private static final String file = "Word Bank/articles.txt";
  private static ArrayList<Article> list = new ArrayList<Article>();



  /* Description: Article constructor
   * @pre: String word
   * @param: String Word
   * @return: None
  */
  public Article(String word)
  {
    super(word);
  }//ends constructor
  


  /* Description: Gets word from file
   * @pre: none
   * @param: none
   * @return: Word from article file
  */
  public static Article getNew()
  {
    if(list.size()==0) readFile();
      return list.get((int)(Math.random()*list.size()));
  }//ends getNew() method



  /* Description: Reads File
   * @pre: none
   * @param: none
   * @return: none
  */
  private static void readFile(){
    try
      {
        Scanner fileReader = new Scanner(new File(file));
        while(fileReader.hasNext())
          {
            list.add(new Article(fileReader.next()));
          }//ends while loop
        fileReader.close();
        //System.out.println("words loaded from "+file);
      }
    catch (IOException e)
      {
        System.out.println("Something's wrong with the file.");
      }//ends catch file errors
  }//ends readFile method
}//ends Article class