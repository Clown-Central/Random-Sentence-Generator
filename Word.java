public /*abstract*/ class Word
{
  private String word;

  /* Description: Word constructor
   *@pre: String word, String type
   *@param: String word, String type
   */
  public Word(String word, String type)
  {
    this.word = word;
  }//ends constructor 2 parameters

  /* Description: Word constructor
   * @pre String type
   * @param String type
   */
  public Word(String type)
  {
    /*this.type = type;
    switch (type)
    {
      case "adjective":
        //Adjective();
        break;
      case "adverb":
        //Adverb();
        break;
      case "article":
        //Article();
        break;
      case "conjunction":
        //Conjucntion();
        break;
      case "noun":
        //Noun();
        break;
      case "verb":
        //Verb();
        break;
      default:
        System.out.println("Error in Word class");
    }//ends switch*/
  }//ends contructor 1 parameters

  /* Description: Converts word toString
   * @return String word
   */
  public String toString(){
    return word;}//ends toString
  
}//ends word class