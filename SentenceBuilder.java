import java.util.*;

public class SentenceBuilder
{
  //public static ArrayList<Word> prepositionalPhrases;
  //public static ArrayList<Word> conjunctions;
  //private static ArrayList<Word> adjectives;
  //private static ArrayList<Word> adverbs;
  
  public static void prep()
  {
    //System.out.println("prep called");
    Noun.list = Noun.readFile();
    Article.list = Article.readFile();
    //adjectives = Adjective.readFile();
    Verb.list = Verb.readFile();
    //adverbs = Adverbs.readFile(); 
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
  
/* Description: Builds the actual sentence
 * @return String formatSentence(sentence)
 */
  public static String getSentence()
  {
    LinkedList<Word> sentence = new LinkedList<Word>();
    sentence.add(getSubject());
    Verb verb = Verb.getNew();
    System.out.println(verb.toString());
    verb.conjugate();
    System.out.println(verb.toString());
    sentence.add(verb);
    
    if(sentence.getLast().toString().length()<3 || Math.random()>0.1) 
    sentence.add(getObject());

    return formatSentence(sentence);
  }//builds a sentenceLinkedList<String> test = new LinkedList<String>();

  private static String formatSentence(LinkedList<Word> list)
  {    
    String s="";
    for(int i=0; i<list.size(); i++)
    {
       s+=list.get(i)+" ";
    }
    return s.substring(0,1).toUpperCase()+s.substring(1,s.length()-1).toLowerCase()+".";
  }//ends formatSentence - puts a capital letter and a period

  /* Description: gets Object
   * @return object
   * CHANGE TO LINKEDLIST OF WORDS
   */
  private static Word getObject()
  {
    Article art = Article.getNew();
    Noun n = Noun.getNew();
    String phrase = "";
    if(Math.random()*100>15)
    {
      if(art.equals("a")) phrase+=(UsefulMethods.isVowel(n.toString()))?"an":"a";
      else phrase+=art;
      //ADJECTIVES WILL GO HERE
      return new Word(phrase+" "+n);//FIX LATER - make linked list
    }
    else
    {
      return new Word("them");//randomized pronoun (from list?)
      //To-do: make conjugation match other possible pronouns (ex. "they") and plural nouns
    }
  }//ends fullNoun method - changes A to An if neccessary, returns article+noun, when we want to add adjectives, they go here

  /* Description: Gets the subject
   * @return String subject
   */
  public static Word getSubject(/*String art, String n*/)
  {
    Article art = Article.getNew();
    Noun n = Noun.getNew();
    String phrase = "";
    if(Math.random()*100>15)
    {
      if(art.equals("a")) phrase+=(UsefulMethods.isVowel(n.toString()))?"an":"a";
      else phrase+=art.toString();
      //ADJECTIVES WILL GO HERE
      return new Word(phrase+" "+n.toString());
    }
    else
    {
      return new Word("it");//randomized pronoun (from list?)
    }
  }//ends fullNoun method - changes A to An if neccessary, returns article+noun, when we want to add adjectives, they go here
   
}//ends SentenceBuilder class 