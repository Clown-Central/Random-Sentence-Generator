import java.util.*;
import java.io.IOException;//for file issues
import java.io.File;//used to read file
import java.io.FileWriter;//used to save file

public class ParagraphBuilder 
{

  /*
  Description: Creates txt file for program to store paragraphs
  *Pre: String[] args
  *Param: String[] args
  *Post: None
  *Return: None
  */  	
  public static void createFile(String[] args) 
  {
  try
    {
    File userProgramParagraph = new File("userProgramParagraph.txt");
    if (userProgramParagraph.createNewFile()) 
      {
        System.out.println("File created: " + userProgramParagraph.getName());
      } 
    else 
      {
        System.out.println("File already exists.");
      }
    } 
  catch (IOException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } // ends try catch
  }// ends file creation method



  /*
  Description: User inputs their own word bank in their own txt file
  *Pre: String[] args
  *Param: String[] args
  *Post: None
  *Return: None
  */
  public static void userInputFile(String[] args) 
  {
    Scanner userWrites = new Scanner(System.in);
    boolean input = true;
    Scanner userCont = new Scanner(System.in);
    int stop = 0;
    try 
      {
        FileWriter UserNounWriter = new FileWriter("ownNounWordBank.txt"); //User's NOUN bank
        while (input = true) 
         {
          UserNounWriter.write(userWrites.nextLine());
          System.out.println("Stop = 1");
          stop = Integer.valueOf(userCont.nextLine());
          if (stop == 1) 
            {
              input = false;
            }//signifies user wants to stop adding
        } // ends while loop when user wants to stop adding into the file.
      UserNounWriter.close();
      System.out.println("Successfully wrote to the file.");


      FileWriter UserAdjWriter = new FileWriter("ownAdjWordBank.txt"); //User's ADJECTIVE bank
      while (input = true) 
        {
          UserAdjWriter.write(userWrites.nextLine());
          System.out.println("Stop = 1");
          stop = Integer.valueOf(userCont.nextLine());
          if (stop == 1) 
            {
              input = false;
            }//signifies user wants to stop adding
        } // ends while loop when user wants to stop adding into the file.
      UserAdjWriter.close();
      System.out.println("Successfully wrote to the file.");


      FileWriter UserVerbWriter = new FileWriter("ownVerbWordBank.txt"); //User's VERB bank
      while (input = true) 
        {
          UserVerbWriter.write(userWrites.nextLine());
          System.out.println("Stop = 1");
          stop = Integer.valueOf(userCont.nextLine());
          if (stop == 1) 
            {
              input = false;
            }//signifies user wants to stop adding
        } // ends while loop when user wants to stop adding into the file.
      UserVerbWriter.close();
      System.out.println("Successfully wrote to the file.");


      FileWriter UserAdverbWriter = new FileWriter("ownAdverbWordBank.txt"); //User's Adverb bank
      while (input = true) 
        {
          UserAdverbWriter.write(userWrites.nextLine());
          System.out.println("Stop = 1");
          stop = Integer.valueOf(userCont.nextLine());
          if (stop == 1) 
            {
              input = false;
            }//signifies user wants to stop adding 
        } // ends while loop when user wants to stop adding into the file.
      UserAdverbWriter.close();
      System.out.println("Successfully wrote to the file.");
    } // ends try

    catch (IOException e) 
      {
        System.out.println("An error occurred.");
        e.printStackTrace();
      } // ends catch
  }// ends userInputFile method



  /*
  Description: Mode method - Allows user to choose whether they want to take over the program, or let the program do its own thing. Manual - User chooses to add or not add sentences into the paragraph. Autonomous - User's paragraph is formed by program.
  *Pre: None
  *Param: None
  *Post: 
  *Return: int mode
  */
  public static int mode() 
  {
    Scanner userMode = new Scanner(System.in);
    int mode = -1;
    while (mode == -1) 
      {
        System.out.println("Please choose 0 - control; 1 - autonomy");
        mode = Integer.valueOf(userMode.nextLine());
        if (mode == 0) 
         {
           System.out.print("Control Chosen");
         } 
        else if (mode == 1) 
          {
            System.out.print("Autonomy Chosen");
          } 
        else 
          {
            System.out.println("Unvalid Input");
          }
      } // ends while loop
    return mode;
  }// User takes control or srg is autonomous
}// ends ParagraphBuilder class