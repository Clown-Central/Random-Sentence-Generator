public /*abstract*/ class Word
{
  private String word;

  /* Description: Word constructor
   * @pre String word, String type
   * @param String word, String type
   */
  public Word(String word/*, String type*/)
  {
    this.word = word;
  }//ends constructor

  /* Description: Converts word toString
   * @return String word
   */
  public String toString(){
    return word;}//ends toString

  public boolean equals(String str){
    return (boolean)((this.toString()).equals(str));}

  public boolean equals(Word other){
    return (boolean)(this.toString()).equals(other.toString());}

}//ends word class