import java.util.*;
/*import java.io.IOException;//for file issues
import java.io.File;//used to read file
import java.io.FileWriter;//used to save file*/

public class SentenceBuilder
{
  public static ArrayList<Word> prepositionalPhrases;//not used yet
  public static ArrayList<Word> conjunctions;//not used yet
  private static ArrayList<Word> nouns;
  private static ArrayList<Word> articles;
  //private static ArrayList<Word> adjectives;//not used yet
  private static ArrayList<Word> verbs;
  //private static ArrayList<Word> adverbs;//not used yet
  
  public SentenceBuilder()
  {
    nouns = UsefulMethods.readFile("Word Bank/nouns.txt","noun");
    articles = UsefulMethods.readFile("Word Bank/articles.txt","article");
    //adjectives = UsefulMethods.readFile("Word Bank/adjectives.txt","adjective");
    verbs = UsefulMethods.readFile("Word Bank/verbs.txt","verb");
    //adverbs = UsefulMethods.readFile("Word Bank/adverbs.txt","adverb"); 
  }

  /* Description: This is the independent clause
   * @return String independentClause
   *
  private static String indepdentClause()
  {
    String independent = "";
    return independent;
  }//Code to build Independent Clause

  /* Description: This is the dependent clause 
   * @return String dependentClause
   *
  private static String dependentClause()
  {
    String dependent = "";
    return dependent;
  }//Code for Dependent Clause

  /* Description: User chooses the tense to which they want their 
   * sentence to be in.
   * @return int tense
   */
  public static int sentenceTense()
  {
    Scanner se = new Scanner(System.in);
    int tense = -1;
    int valid = -1;
    while(valid == -1){
      System.out.println("Please choose 0 - past; 1 - present, 2 - future");
      tense = Integer.valueOf(se.nextLine());   
      if(tense == 0)
      {
        valid++;
      }
      else if (tense == 1)
      {
        valid++;
      }
      else if (tense == 2)
      {
        valid++;
      }
      else{
        System.out.println("Unvalid Input");
      }
    }//ends while loop

    se.close();
    return tense;
  }//ends sentenceTense method



  /*public static String getSentence()
  {
    String sentence = "";
    sentence += Subject.getSubject()+" ";
    sentence += VerbsAndAdverbs.conjugateVerb();
    //sentence += VerbsAndAdverbs.conjugateVerb("convey");

    if(sentence.substring(sentence.length()-3,sentence.length()-2).equals(" ") || Math.random()>0.1)sentence+=" "+Object.getObject();

    return formatSentence(sentence);
  }//builds a sentence*/
  



  /* Description: Builds the actual sentence
   * @return String formatSentence(sentence)
   */
  /*public static String getSentence()
  {
    String sentence = "";
    sentence += Subject.getSubject()+" ";
    sentence += VerbsAndAdverbs.conjugateVerb();
    //sentence += VerbsAndAdverbs.conjugateVerb("convey");

    if(sentence.substring(sentence.length()-3,sentence.length()-2).equals(" ") || Math.random()>0.1)sentence+=" "+Object.getObject();

    return formatSentence(sentence);
  }//builds a sentence
  THIS IS THE VERSION WITHOUT A LINKED LIST*/



/* Description: Builds the actual sentence
 * @return String formatSentence(sentence)
 */
  public static String getSentence()
  {
    LinkedList<Word> sentence = new LinkedList<Word>();
      System.out.println(sentence);
    sentence.add(getSubject());
      System.out.println(sentence);
    sentence.add(conjugateVerb());
      System.out.println(sentence);
    //test.add((String)(VerbsAndAdverbs.conjugateVerb("convey")));
    
    if(sentence.getLast().toString().length()<3 || Math.random()>0.1)
    {
      sentence.add(getObject());
        System.out.println(sentence);
    }//ends if

    return formatSentence(sentence);
  }//builds a sentenceLinkedList<String> test = new LinkedList<String>();



  /*private static String formatSentence(String s) {    
    return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase()+".";}*/

  private static String formatSentence(LinkedList<Word> list)
  {    
    String s="";
    for(int i=0; i<list.size(); i++)
    {
       s+=list.get(i)+" ";
    }
    return s.substring(0,1).toUpperCase()+s.substring(1,s.length()-1).toLowerCase()+".";

    //list.getFirst();
    //list.remove(0);
  }//ends formatSentence - puts a capital letter and a period












    
  
  
  /* Description: gets Object
   * @return object
   */
  public static Word getObject()
  {
    Word art = UsefulMethods.getWord(articles);
    Word n = UsefulMethods.getWord(nouns);
    String phrase = "";
    if(Math.random()*100>15)
    {
      if(art.toString().equals("a")) phrase+=(UsefulMethods.isVowel(n.toString()))?"an":"a";
      else phrase+=art;
      //ADJECTIVES WILL GO HERE
      return new Word(phrase+" "+n);//FIX LATER - make linked list
    }
    else
    {
      return new Word("them");//randomized pronoun (from list?)
      //To do: make conjugation match other possible pronouns (ex.   "they") and plural nouns
    }
  }//ends fullNoun method - changes A to An if neccessary, returns article+noun, when we want to add adjectives, they go here

  
  

  
  /* Description: Gets the subject
   * @return String subject
   */
  public static Word getSubject(/*String art, String n*/)
  {
    Word art = UsefulMethods.getWord(articles);
    Word n = UsefulMethods.getWord(nouns);
    String phrase = "";
    if(Math.random()*100>15)
    {
      if(art.toString().equals("a")) phrase+=(UsefulMethods.isVowel(n.toString()))?"an":"a";
      else phrase+=art.toString();
      //ADJECTIVES WILL GO HERE
      System.out.println(phrase + " " + n.toString());
      return new Word(phrase+" "+n.toString());
    }
    else
    {
      return new Word("it");//randomized pronoun (from list?)
      //To do: make conjugation match other possible pronouns (ex.   "they") and plural nouns
    }
  }//ends fullNoun method - changes A to An if neccessary, returns article+noun, when we want to add adjectives, they go here





  

   
  /* Description: Conjugates verb
   * @pre int tense
   * @param int tense
   * @return String conjugated verb
  */
  public static Word conjugateVerb(/*int tense*/)
  {
    Word v = UsefulMethods.getWord(verbs);
    //v = new Word(v.toString().toLowerCase());
    String result = v.toString().substring(0,v.toString().length()-1);
    if(v.toString().substring(v.toString().length()-1).equals("y")&& (!v.toString().equals("convey"))) result+="ies";
    else 
    {
      result+=v.toString().substring(v.toString().length()-1);
      if(v.toString().substring(v.toString().length()-1).equals("s")) 
      {
        result+="es";
      }
      else if(v.toString().substring(v.toString().length()-1).equals("h"))
      { 
        result+="es";
      }
      else result+="s";
    }//ends else
    //ADVERBS and any other words that need to follow the verb (ex. "at" for the verb "looked at") WILL GO HERE
    if (v.toString().equals("frown"))result+=" at";
    if (v.toString().equals("speak")||v.toString().equals("respond"))result+=" to";
    //add "account for", but also fix the thing in the sentence generator that checks for a two letter word.
          System.out.println(result);
    return new Word(result);//change to linked list
  }//returns complete, conjugated verb





}//ends SentenceBuilder class 