import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Noun extends Word
{

  private static final String file = "Word Bank/nouns.txt";
  private static ArrayList<Noun> list = new ArrayList<Noun>();  



  public Noun(String word){
    super(word);}//ends constructor

  

  /* Description: Gets word from file
   * @pre ArrayList<Word> list
   * @param ArrayList<Word> list
   * @return Word word
   */
  public static Noun getNew()
  {
    if(list.size()==0) readFile();
    return list.get((int)(Math.random()*list.size()));
  }//ends method



  public boolean isVowel() {
    return this.toString().substring(0,1).toLowerCase().matches("[aeiou]");}//ends isVowel

  
  
  private static void readFile(){
    try{
      Scanner fileReader = new Scanner(new File(file));
      while(fileReader.hasNext())
        list.add(new Noun(fileReader.next()));
      fileReader.close();
    }catch (IOException e){
      System.out.println("Something's wrong with the file.");
    }//ends catch file errors
  }//ends readFile

}//ends Noun class