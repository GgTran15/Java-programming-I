// Gg Tran
// Whitaker Brand
// 10/11/17
// CSE142
// TA: Eli Son
// HW #2
//I died doing HW2



public class AsciiArt {
   public static void main (String[] args){
      for (int star = 1; star <= 9; star++){
         System.out.print("*");
      }
      System.out.print("(v)");
      for (int star = 1; star <= 6; star++){
         System.out.print("*");
      }
      System.out.println();
      for (int star = 1; star <= 4; star++){
         System.out.print("*");
         for (int fig = 1; fig <= 2; fig++){
            System.out.print("<>");
         } 
         for (int slash = 1; slash <= 2; slash++){
            System.out.print("||");
         }
         for (int fig = 1; fig <= 2; fig++){
            System.out.print("<>");
         }
         for (int slash = 1; slash <= 2; slash++){
            System.out.print("||");
         }
         System.out.print("*");
      System.out.println();
      }
   }
}