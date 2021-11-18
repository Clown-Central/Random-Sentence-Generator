import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Word
{

  private String word;


  /*public static ArrayList<Word> readFile(){
    return new ArrayList<Word>();
  }*/



  /* Description: Word constructor
   * @pre String word, String type
   * @param String word, String type
   */
  public Word(String word/*, String type*/)
  {
    this.word = word;
  }//ends constructor



  /* Description: Converts word toString
   * @return String word
   */
  public String toString()
  {
    return word;
  }//ends toString



  /* Description: checks if the word is equal to word in file
   * @pre: Word other
   * @param: Word other
   * @return: true or false
  */
  public boolean equals(Word other)
  {
    return (this.toString()).equals(other.toString());
  }//
}//ends word class