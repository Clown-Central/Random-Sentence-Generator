import java.util.*;
import WordStuff.*;

public class SentenceBuilder 
{

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
   *
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
        System.out.println("Invalid Input");
      }
    }//ends while loop
    se.close();
    return tense;
  }//ends sentenceTense method
    */

  public static String getSentence()
  {
    LinkedList<Word> sentence = new LinkedList<Word>();
    switch((int)(Math.random()*2))//change to 5 when other options complete
    {
      case 0:
      {
        add(sentence, getPhrase("subject"));
        add(sentence,Verb.getNew().conjugate());
        if(sentence.getLast().getType().equals("Conjunction") || Math.random()>0.1) 
          add(sentence,getPhrase("object")); 

        return formatSentence(sentence);
      }
      case 1:
      {
        add(sentence, getPhrase("subject"));
        add(sentence, Verb.getNew().conjugate());
        if(sentence.getLast().getType().equals("Conjunction") || Math.random()>0.1) 
        {
          add(sentence,getPhrase("object"));
          //ADJECTIVES RELOCATED TO getPhrase METHOD
        }    

        return formatSentence(sentence);
      }
      case 2:
      {
        System.out.println("not complete yet");
      }
      case 3:
      {
        System.out.println("not complete yet");
      }
      case 4:
      {
        System.out.println("not complete yet");
      }
    }
    return formatSentence(sentence);
  }//builds a sentenceLinkedList<String> test = new LinkedList<String>();

  



  /* Description: Formats the sentence
   * @pre: LinkedList<Word> list
   * @param: LinkedList<Word> list
   * @return: String formattedsentence
  */
  private static String formatSentence(LinkedList<Word> list)
  {    
    String s="";
    for(int i=0; i<list.size(); i++)
      {
        s+=list.get(i)+" ";
      }
    return s.substring(0,1).toUpperCase()+s.substring(1,s.length()-1).toLowerCase()+".";
  }//ends formatSentence - puts a capital letter and a period



  /* Description: Articles and Nouns reformatting
   * @pre: String type
   * @param: String type
   * @return: LinkedList<Word>
  */
  private static LinkedList<Word> getPhrase(String type)
  {
    LinkedList<Word> output = new LinkedList<Word>();
    if(Math.random()*100>5)//get object or use pronoun
      {
        Article art = Article.getNew();
        output.add(Noun.getNew());
        if(Math.random()>0.5)
        {
          output.add(0,Adjective.getNew());
        }
        if(art.equals("a"))
        {
          output.add(0, new Word(((output.get(0)).isVowel() ? "an":"a"), "Article"));
        }
        else 
        {
          output.add(0,art);
        }
        return output;
      }
    else
      {
        if(type.equals("subject"))
        {
          output.add(new Word("it","pronoun"));//add other possibilities
        }
        else if(type.equals("object"))
        {
          output.add(new Word("them","pronoun"));//add other possibilities
        }
        else
        {
          System.out.println("You did something wrong.");
        }
      }
    return output;
  }//ends fullNoun method - changes A to An if neccessary, returns article+noun, when we want to add adjectives, they go here



  /* Description: Adds word
   * @pre: LinkedList<Word> oldList, LinkedList<Word> newList
   * @param: LinkedList<Word> oldList, LinkedList<Word> newList
   * @return: none
  */
  private static void add(LinkedList<Word> oldList, LinkedList<Word> newList) 
  {
    for(Word word : newList)
    {
      oldList.add(word);
    }
  }//ends add method
}//ends SentenceBuilder class 