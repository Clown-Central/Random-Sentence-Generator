import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file
//import java.io.FileWriter;//used to save file

public class UsefulMethods
{

  /*
  Description: Returns the input from a given file as an ArrayList
  *Pre: String file
  *Param: String file
  *Post: None
  *Return: ArrayList<Word> info
  */
  public static ArrayList<Word> readFile(String file, String type)
  {
    ArrayList<Word> info = new ArrayList<Word>();
    
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        info.add(new Word(fileReader.next(),type));
      }//ends while
      fileReader.close();
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
  *Return: String word
  */
  public static Word getWord(ArrayList<Word> list)
  {
    try
    { 
      return list.get((int)(Math.random()*list.size()));
    }
    catch(NullPointerException e)
    {
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