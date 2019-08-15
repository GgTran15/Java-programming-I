// Gg Tran
// Whitaker Brand
// 10/11/17
// CSE142
// TA: Eli Son
// HW #2

public class SpaceNeedle {
   public static final int SIZE = 7;
   public static void main(String[] args){
      topMost();
      secondPart();
      thirdPart();
      fourthPart();
      topMost();
      sixthPart();
      secondPart();
      thirdPart();
   }

     //topmost part of the space needle: Draw "||" on SIZE lines
   public static void topMost(){
      for (int line = 1; line <= SIZE; line++){
         for (int space = 1; space <= 3*SIZE; space++){
               System.out.print(" ");
         }
         for (int vertical = 1; vertical <= 2; vertical++){
               System.out.print("|");
         }
         for (int space = 1; space <= 3*SIZE; space++){
               System.out.print(" ");
         }

         System.out.println();
      }
   }
   
   
   //2nd part: Draw the part that extend outward, start with '__/||\__'
   public static void secondPart(){
      for (int line = 1; line <= SIZE; line++){
          //half left of the part:
         for (int space = 1; space <= -3 * line + (SIZE * 3); space++){ 
            System.out.print(" ");           
         }
         for (int leftFig = 1; leftFig <= 1; leftFig++){  
            System.out.print("__/"); 
         }
         for (int dot = 1; dot <= 3 * line - 3; dot++){          //':::'
             System.out.print(":");
         }
         
         //half right: 
         for (int verticalLine = 1; verticalLine <= 1; verticalLine++){
            System.out.print("||");
         }
         for (int dot = 1; dot <= 3 * line - 3; dot++){        
             System.out.print(":");
         }
         for (int rightFig =1; rightFig <= 1; rightFig++){
            System.out.print("\\__");
         }
         
         System.out.println();
      }
   }


    // Draw |""""""""""""""""""""""""|:
    public static void thirdPart(){
       System.out.print("|");
       for (int sign = 1; sign <= 3 * SIZE; sign++){
          System.out.print("\"\"");
         }
       System.out.print("|");
       System.out.println();
    }
    
    
    //Draw the part with many hats like this "/\/\/\/\/\/\/\/\/\/\/\_/":
    public static void fourthPart(){
      for (int line = 1; line <= SIZE; line++){
         for (int space = 1; space <= 2 * line - 2; space++){
            System.out.print(" "); //only this part change with regard to constant
         }
         for (int leftFig = 1; leftFig <= 1; leftFig++){
            System.out.print("\\_");
         }
         for (int midFig = 1; midFig <= - 2 * line + (3*SIZE + 1); midFig++){
            System.out.print("/\\");  //only this part change with regard to constant
         }
         for (int rightFig = 1; rightFig <= 1; rightFig++){
            System.out.print("_/");
         }
        System.out.println();
      }
    }
      

      //|%%||%%|
   public static void sixthPart(){
      for (int line = 1; line <= SIZE * SIZE; line++){
         for (int space = 1; space <= 2 * SIZE + 1; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int percent = 1; percent <= SIZE - 2; percent++) {
            System.out.print("%");
         }
         for (int vertical = 1; vertical <= 2; vertical++) {
            System.out.print("|");
         }
         for (int percent = 1; percent <= SIZE - 2; percent++) {
            System.out.print("%");
         }
         System.out.print("|");
         System.out.println();
      } 
   }
}