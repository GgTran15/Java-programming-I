// Whitaker Brand
// 10/16/17
// CSE142
// TA:  Eli Son
// Assignment #3
//
// This program will draw a random figure

import java.awt.*;

public class Doodle {
   public static void main (String[] args) {
      DrawingPanel panel = new DrawingPanel(500, 350);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.BLUE);
      g.setColor(Color.GRAY);
      g.fillRect(100, 100, 120, 120);
      drawCircles(g, 100, 100, 100, 100);
      g.setColor(Color.RED);
      g.drawLine(100, 100, 250, 250);
   }
   
   public static void drawCircles (Graphics g, int x, int y, int w, int h) {
      g.setColor(Color.PINK);
      for (int i = 1; i <= 10; i++) {
         g.drawOval(x + 5 * i, y + 5 * i, w - 10, h - 10);
      }
      System.out.println();
   }
}