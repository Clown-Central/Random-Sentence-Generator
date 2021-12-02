package WordStuff;
import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Verb extends Word
{



  private static final String file = "Word Bank/verbs.txt";
  private static ArrayList<Verb> list = new ArrayList<Verb>();



  /* Description: Verb constructor
   * @pre: String word
   * @param: String Word
   * @return: None
  */
  public Verb(String word)
  {
    super(word,"Verb");
  }//ends constructor



  /* Description: Gets word from file
   * @pre: none
   * @param: none
   * @return: Word from article file
  */
  public static Verb getNew()
  {
    if(list.size()==0)
    {
      readFile();
    }
      return list.get((int)(Math.random()*list.size()));
  }//ends method
  
  

  /* Description: Conjugates verb
   * @pre: none
   * @param int: none
   * @return: Verb
   */
  public LinkedList<Word> conjugate(/*tense?*/)
  {
    String last = this.toString().substring(this.toString().length()-1);
    String temp;
    LinkedList<Word> fullVerb = new LinkedList<Word>();
    
    if(last.equals("y")&&(!this.toString().equals("convey")))
    {
      temp=this.toString().substring(0,this.toString().length()-1)+"ies";
    }
    else 
    {
      temp=this.toString();
      if(last.equals("s") || last.equals("h"))
      {
        temp+="es";
      }
      else
      {
        temp+="s";
      }
    }//ends else statement

    fullVerb.add(new Verb(temp));

    String str = "";
    //the cursed switch statement
    switch(str/*this*/)
    {
      case "frown": 
        str="at";
        break;
      case "speak": case "respond": case "listen":
        str="to";
        break;
      case "sleep": case "walk": case "run":
        str="on";
        break;
      case "account":
        str="for";
        break;
      case "communicate":
        str="with";//add "to","about","for"
        break;
      case "jump":
        str="over";
        break;
      case "deal":
        str="with";
    }
    if(!str.equals(""))
    {
      fullVerb.add(new Word(str,"Conjunction"));
    }
    return fullVerb;
  }//returns complete, conjugated verb

  /* Description: Readsfile
   * @post: list now contains words from word bank
  */
  private static void readFile(){
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
      {
        list.add(new Verb(fileReader.next()));
      }
      fileReader.close();
    }
    catch (IOException e)
    {
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors

  }//ends readFile
}//ends Verb class