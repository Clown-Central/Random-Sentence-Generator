import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Verb extends Word
{
  private String word;

  public Verb(String word)
  {
    super(word);
  }//ends constructor

  private static final String file = "Word Bank/verbs.txt";
  
  public static ArrayList<Word> readFile(){
    ArrayList<Word> info = new ArrayList<Word>();
    
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
    String v = word.toString().substring(0,word.toString().length()-1);
    if(word.toString().substring(word.toString().length()-1).equals("y")&& (!word.equals("convey"))) v+="ies";
    else 
    {
      v+=word.toString().substring(word.toString().length()-1);
      if(word.toString().substring(word.toString().length()-1).equals("s")) v+="es";
      else if(word.toString().substring(word.toString().length()-1).equals("h")) v+="es";
      else v+="s";
    }//ends else
    //ADVERBS and any other words that need to follow the verb (ex. "at" for the verb "looked at") WILL GO HERE
    if (word.equals("frown"))v+=" at";
    if (word.equals("speak")||word.equals("respond")||word.equals("listen"))v+=" to";
    //add "account for", but also fix the thing in the sentence generator that checks for a two letter word.
          //System.out.println(v);
    word = v;
    return this;
  }//returns complete, conjugated verb

}//ends Verb class