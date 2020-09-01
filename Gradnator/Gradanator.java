// Gg Tran
// 10/24/17
// This program reads exam/homework scoresS
     //and reports your overall course grade.


import java.util.*;

public class Gradanator {
   public static final int TESTMAX = 100;
   public static final int SECTIONMAX = 30;
   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
      double score = 0.0;
      intro();
      score += testScore(console, "Midterm:");
      score +=testScore(console, "Final:");
      score +=homework(console);
      overallGrade(score);
   }
   
   //Print out introduction of the program
   public static void intro() {
      System.out.println("This program reads exam/homework scores");
      System.out.println("and reports your overall course grade.");
      System.out.println();
   }
        
   //Print out score report for midterm/final:
   public static double testScore(Scanner console, String test) {
      System.out.println(test);
      System.out.println("Weight (0-100)?");
      int weight = console.nextInt();
      System.out.println("Score earned?");
      int score = console.nextInt();
      System.out.println("Were scores shifted (1=yes, 2=no) ?");
      int shift = console.nextInt();
      if (shift == 1) {
         System.out.println("Shift amount?");
         int shiftAmount = console.nextInt();
         score += shiftAmount;
      }
      score = Math.min(score, TESTMAX);
      totalPoint(score, TESTMAX);
      double weightedScore = (double) score / TESTMAX * weight;
      System.out.println("Weighted score = " + rounding(weightedScore) + " / " + weight);
      System.out.println();
      return weightedScore;
   }
   
   //Print out report for homework score
   public static double homework(Scanner console) {
      System.out.println("Homework:");
      System.out.println("Weight (0 - 100)?");
      int weight = console.nextInt();
      System.out.println("Number of assignments?");
      int sumScore = 0;
      int sumMax = 0;
      int assignments = console.nextInt();
      for (int i = 1; i <= assignments; i++) {
         System.out.println("Assignment " + i + " score and max?");
         int score = console.nextInt();
         int max = console.nextInt();
         sumScore += score;
         sumMax += max;
      }
      System.out.println("How many sections did you attend?");
      int section = console.nextInt();
      int sectionScore = 5 * section;
      sectionScore = Math.min(sectionScore, SECTIONMAX);
      int total = sectionScore + sumScore;
      int totalMax = sumMax + SECTIONMAX;
      total = Math.min (total, totalMax);
      System.out.println("Section points = " + sectionScore + " / " + SECTIONMAX);
      totalPoint(total, totalMax);
      double weightedScore = (double) total / totalMax * weight;
      System.out.println("Weighted score = " + rounding(weightedScore) + " / " + weight);
      return weightedScore;
   }
        
   //Print out final GPA using total weighted scores from tests and homework
   public static void overallGrade(double score) {
      System.out.println();
      System.out.println("Overall percentage = " + rounding(score));
      double grade = 0.0;
      String comment = " ";
      if (score >= 85) {
         grade = 3.0;
         comment = "Ew.";
      } else if (75 <= score && score <= 84.99) {
         grade = 2.0;
         comment = "Shame on you and your dog.";
      } else if (60 <= score && score <= 74.99){
         grade = 0.7;
         comment = "Have fun repeating the course, sucker!";
      } else {
         grade = 0.0;
         comment = "You will do better next time. (No just kidding. You will just fail again.)";
      }
      System.out.println("Your grade will be at least: " + grade);
      System.out.println(comment);
   }
   
   //Calculate total score over maximum points possible
   public static void totalPoint(int total, int max) {
      System.out.println("Total points = " + total + " / " + max);
   }
   
   //Rounding weighted score
   public static double rounding(double score) {
      return Math.round(score * 10.0) / 10.0;
   }   
}   