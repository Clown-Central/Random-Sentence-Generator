import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Verb extends Word
{

  private static final String file = "Word Bank/verbs.txt";
  private static ArrayList<Verb> list = new ArrayList<Verb>();



  public Verb(String word)
  {
    super(word);
    //this.word = word;
  }//ends constructor



  /* Description: Gets word from file
   * @pre ArrayList<Word> list
   * @param ArrayList<Word> list
   * @return Word word
   */
  public static Verb getNew()
  {
    if(list.size()==0) readFile();
    return list.get((int)(Math.random()*list.size()));
  }//ends method
  
  
  
  /* Description: Conjugates verb
   * @pre int tense
   * @param int tense
   * @return String conjugated verb
   */
  public Verb conjugate()
  {
    String temp = this.toString().substring(0,this.toString().length()-1);
    
    if(this.toString().substring(this.toString().length()-1).equals("y" )&&(!this.toString().equals("convey"))) 
      temp+="ies";
    else 
    {
      temp+=this.toString().substring(this.toString().length()-1);
      if(this.toString().substring(this.toString().length()-1).equals("s")) temp+="es";
      else if(this.toString().substring(this.toString().length()-1).equals("h")) temp+="es";
      else temp+="s";
    }//ends else
    //ADVERBS HERE?
    if (this.toString().equals("frown"))temp+=" at";
    if (this.toString().equals("speak")||this.toString().equals("respond")||this.toString().equals("listen"))temp+=" to";
    //if (this.toString().equals("account"))temp+=" for";
    //if (this.toString().equals("communicate"))temp+=" with";
    //fix the thing in the sentence generator that checks for a two letter word.
    
    return new Verb(temp);
  }//returns complete, conjugated verb



  private static void readFile(){
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

    list=info;
  }//ends readFile

}//ends Verb class