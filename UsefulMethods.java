import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class UsefulMethods
{

  /* Description: Returns the input from a given 
   * file as an ArrayList
   * @pre String file
   * @param String file
   * @return ArrayList<Word> info
   */
  public static ArrayList<Word> readFile(String file)
  {
    ArrayList<Word> info = new ArrayList<Word>();
    
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        info.add(new Word(fileReader.next()));
      }//ends while
      fileReader.close();
      System.out.println("words loaded from "+file+"\n"+info);
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors

    return info;
  }//ends readFile

  /*
  Description: Gets word from file
  *Pre: ArrayList<Word> list
  *Param: ArrayList<Word> list
  *Post: None
  *Return: Word word
  */
  public static Word getWord(ArrayList<Word> list)
  {
    try
    { 
      Word word = list.get((int)(Math.random()*list.size()));
      System.out.println(word.toString());
      return word;
    }
    catch(NullPointerException e)
    {
      System.out.println("Problem: line 51 of UsefulMethods");
      return new Word("n/a");
    }//ends catch
  }//ends getNoun() method

  /*
  Description: Checks whether noun starts with a vowel.
  *Pre: String str
  *Param: String str
  *Post: None
  *Return: boolean vowel
  */
  public static boolean isVowel(String str)
  {
    return str.substring(0,1).toLowerCase().matches("[aeiou]");    
  }//ends isVowel

}//ends class