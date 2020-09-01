//Gg Tran
//11/17/2017
//This program creates mad lib stories from user's input


import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      intro();
      String reply = " ";
      while (!reply.equalsIgnoreCase("q")) {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         reply = console.nextLine();
         if (reply.equalsIgnoreCase("c")) {
            fileScan(input(console), console);
         } else if (reply.equalsIgnoreCase("v")) {
            viewMadLib(input(console));
         }
      }
   }
   
   //Print the intro of the program:
   public static void intro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   //Prompt user to type in the input file name, prompt again if file not found
   public static Scanner input(Scanner console)
   throws FileNotFoundException {
      System.out.print("Input file name: ");
      File input = new File(console.nextLine());
      while (!input.exists()) {
         System.out.print("File not found. Try again: ");
         input = new File(console.nextLine());
      }
      Scanner madLib = new Scanner(input);
      return madLib;
   }
   
   //Ask user to fill out the placeholders, then print out the content to the output file
   public static void fileScan(Scanner input, Scanner console) throws FileNotFoundException {
      System.out.print("Output file name: ");
      PrintStream output = new PrintStream(new File(console.nextLine()));
      System.out.println();

      while (input.hasNextLine()) {
         String line = input.nextLine();           //Print the line
         Scanner lineScan = new Scanner(line);     //Scan the line
         while (lineScan.hasNext()) {
            String word = lineScan.next();       //Scan each word
            while (word.startsWith("<")) {
               word = word.replace("<", " ");
               word = word.replace("-", " ");
               word = word.replace(">", ":");
               article(word);
               String wordInput = console.nextLine();
               word = wordInput;
            }
            output.print(word + " ");
         }
         output.println();
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   //Print out either article A or An base on vowel/consonant
   public static void article(String word) {
      String vowel = "aeiouAEIOU";
      if (vowel.contains(word.substring(1, 2))) {
            System.out.print("Please type an" + word + " ");
      } else {
            System.out.print("Please type a" + word + " ");
      }
   }
   
   //Print content of output file
   public static void viewMadLib(Scanner input) {
      System.out.println();    
      while(input.hasNextLine()) {
         System.out.println(input.nextLine());
      }
      System.out.println();
   }
}