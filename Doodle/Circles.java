// Whitaker Brand
// 10/16/17
// This program will draw 7 figures


import java.awt.*;

public class Circles {
   public static void main (String[] args) {
      DrawingPanel panel = new DrawingPanel(500, 350);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.CYAN);
      drawCircles(g, 0, 0, 100, 10);     //top-left
      drawCircles(g, 130, 25, 100, 10);  //top-middle 1
      drawCircles(g, 260, 0, 60, 6);      //top-middle 2
      drawCircles(g, 360, 50, 80, 4);     //top-right
      drawGrid(g, 10, 170, 48, 4, 3);         //bottom-left grid
      drawGrid(g, 180, 200, 24, 2, 5);        //bottom-middle grid
      drawGrid(g, 330, 170, 72, 9, 2);        //bottom-right grid
   }
   
   //Draw a circle with n number of sub-circles inside:
   public static void drawCircles (Graphics g, int x, int y, int size, int n) {
      g.setColor(Color.YELLOW);
      g.fillOval(x, y, size, size);
      g.setColor(Color.BLACK);
      for (int i = 1; i <= n; i++) {
         g.drawOval((x - size/n/2) + size/n/2 * i , (y - size/n/2) + size/n/2 * i , (size/n + size) - size / n * i, (size/n + size) - size / n * i);
      }
      System.out.println();
   }
   
   //Drawing a grid with multiple subfigures inside. Each subfigure contains n number of sub-circles
   public static void drawGrid(Graphics g, int xRect, int yRect, int subSize, int n, int subDimension) {
      int rectSize = subSize * subDimension;
      g.setColor(Color.GREEN);
      g.fillRect(xRect, yRect, rectSize, rectSize);
      g.setColor(Color.BLACK);
      g.drawRect(xRect, yRect, rectSize, rectSize);
      for (int i = 1; i <= subDimension; i++) {
         for (int j = 1; j <= subDimension; j++) {
            for (int k = 1; k <= subDimension; k++) {
               drawCircles(g, xRect + subSize * j - subSize, yRect + k*subSize - subSize, subSize, n);
            }
         }
      }
      g.drawLine(xRect, yRect, xRect + rectSize, yRect + rectSize);
      g.drawLine(xRect, yRect + rectSize , xRect + rectSize, yRect);
   }
}

