import java.util.*;

public class SentenceBuilder
{
  //public static ArrayList<Word> prepositionalPhrases;
  //public static ArrayList<Word> conjunctions;
  //private static ArrayList<Word> adjectives;
  //private static ArrayList<Word> adverbs;

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
    add(sentence,getThing("subject"));
    sentence.add(Verb.getNew().conjugate());
    
    if(sentence.getLast().toString().length()<3 || Math.random()>0.1) 
      add(sentence,getThing("object"));

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

  /* Description: Gets the subject or object
   * @return String subject
   */
  public static LinkedList<Word> getThing(String type)
  {
    LinkedList<Word> output = new LinkedList<Word>();
    if(Math.random()*100>15)//get object or use pronoun
    {
      Article art = Article.getNew();
      output.add(Noun.getNew());
      if(art.equals("a")) 
        output.add(0,new Word(((Noun)(output.get(0))).isVowel()?"an":"a"));
      else 
        output.add(0,art);
      //ADJECTIVES WILL GO HERE
      return output;
    }
    else
    {
      if(type.equals("subject"))
        output.add(new Word("it"));//add other possibilities
      else if(type.equals("object"))
        output.add(new Word("them"));//add other possibilities
      else System.out.println("You did something wrong.");
    }
    return output;
  }//ends fullNoun method - changes A to An if neccessary, returns article+noun, when we want to add adjectives, they go here

  private static void add(LinkedList<Word> oldList, LinkedList<Word> newList) {
    for(Word word : newList) 
      oldList.add(word);}//ends add method
   
}//ends SentenceBuilder class 