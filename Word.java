import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Word
{

  private String word;
  private String type;


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

  /* Description: Word constructor
   * @pre String word, String type
   * @param String word, String type
   */
  public Word(String word, String type)
  {
    this.word = word;
    this.type = type;
  }//ends constructor

  /* Description: Converts word toString
   * @return String word
   */
  public String toString()
  {
    return word;
  }//ends toString

  /* Description: gets type
   * @return String type
   */
  public String getType()
  {
    return type;
  }//ends toString

  /* Description: sets type
   * @param String type
   */
  public void setType(String type)
  {
    this.type = type;
  }//ends toString

  /* Description: checks if the word is equal to word
   * @param: Word other
   * @return: true or false
  */
  public boolean equals(Word other)
  {
    return (this.toString()).equals(other.toString());
  }//

  /* Description: checks if the word is equal to string
   * @param: String other
   * @return: true or false
  */
  public boolean equals(String other)
  {
    return (this.toString()).equals(other);
  }//
}//ends word class