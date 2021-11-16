import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Verb extends Word
{

  public static ArrayList<Verb> list = new ArrayList<Verb>();

  //private String word;

  public Verb(String word)
  {
    super(word);
    //this.word = word;
  }//ends constructor

  private static final String file = "Word Bank/verbs.txt";
  
  public static ArrayList<Verb> readFile(){
    ArrayList<Verb> info = new ArrayList<Verb>();
    
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        info.add(new Verb(fileReader.next()));
      }//ends while
      fileReader.close();
      //System.out.println("words loaded from "+file);
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors

    return info;
  }//ends readFile


  /* Description: Conjugates verb
   * @pre int tense
   * @param int tense
   * @return String conjugated verb
  */
  public Verb conjugate()
  {
    
    String v = word.substring(0,word.length()-1);
    if(word.substring(word.length()-1).equals("y" )&&(!word.equals("convey"))) 
      v+="ies";
    else 
    {
      v+=word.substring(word.length()-1);
      if(word.substring(word.length()-1).equals("s")) v+="es";
      else if(word.substring(word.length()-1).equals("h")) v+="es";
      else v+="s";
    }//ends else
    //ADVERBS HERE?
    if (word.equals("frown"))v+=" at";
    if (word.equals("speak")||word.equals("respond")||word.equals("listen"))v+=" to";
    //if (word.equals("account"))v+=" for";
    //fix the thing in the sentence generator that checks for a two letter word.
    word = v;
    System.out.println(v);
    return this;
  }//returns complete, conjugated verb

  /* Description: Gets word from file
   * @pre ArrayList<Word> list
   * @param ArrayList<Word> list
   * @return Word word
   */
  public static Verb getNew()
  {
    return list.get((int)(Math.random()*list.size()));
  }//ends method


}//ends Verb class