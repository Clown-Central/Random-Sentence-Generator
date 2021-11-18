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
  public String toString(){
    return word;}//ends toString

  public void set(String word){
    this.word=word;}

  public boolean equals(String str){
    return (this.toString()).equals(str);}

  public boolean equals(Word other){
    return (this.toString()).equals(other.toString());}

  protected static ArrayList<Noun> readFile(String file){
    ArrayList<Noun> info = new ArrayList<Noun>();
    
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

}//ends word class