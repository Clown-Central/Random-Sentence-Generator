import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file

public class Noun extends Word
{

  private static final String file = "Word Bank/nouns.txt";
  private static ArrayList<Noun> list = new ArrayList<Noun>();  

  public Noun(String word){
    super(word);}//ends constructor

  public static void readFile(){
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

    list = info;
  }//ends readFile

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

}//ends Noun class