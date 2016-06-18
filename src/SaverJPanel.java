// Exercise 12.22 Solution: SaverJPanel.java
// Program simulates a simple screen saver
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SaverJPanel extends JPanel implements ActionListener 
{
   private final int DELAY = 9999999;
   private Timer timer;
   private Random random;

   // constructor sets window's title bar string and dimensions
   public SaverJPanel()
   {
      random = new Random(); // create random number generator      
      timer = new Timer( 50, this ); // create a new timer
      timer.start();
   } // end SaverJPanel constructor

   // draw shapes
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      
      File background;
      background = new File("Thor.jpg");
       try {
           BufferedImage thor = ImageIO.read(background);
           g.drawImage(thor, 0, 0, null);
       } catch (IOException ex) {
           Logger.getLogger(SaverJPanel.class.getName()).log(Level.SEVERE, null, ex);
       }
      File image = new File("Thor's_Hammer.png");
        try {
           BufferedImage hammer = ImageIO.read(image);

           g.drawImage(hammer.getScaledInstance(150, 150, Image.SCALE_SMOOTH), 525 , 250, null);
       } catch (IOException ex) {
           Logger.getLogger(SaverJPanel.class.getName()).log(Level.SEVERE, null, ex);
       }
      
      // draw 100 different shapes
      for ( int i = 0; i < 50; i++ ) 
      {
        int shape = random.nextInt( 1 ); // pick a random shape
         
         switch( shape )
         {
            case 0:
                
               makeLine( g );
               
               break;
            case 1:
               makeRect( g );
               break;
            case 2:
               makeOval( g );
               break;
            case 3:
               makeRoundRect( g );
               break;
         } // end switch

         // slow the drawing down. the body of the for loop is empty
         for ( int q = 1; q < DELAY; q++ ) ;
      } // end for
   } // end method paintComponent

   // repaint JPanel
   public void actionPerformed( ActionEvent actionEvent )
   {
      repaint();
   } // end method actionPerformed
   
   // draw a random lines
   private void makeLine( Graphics g )
   {
      Graphics2D g2d = ( Graphics2D ) g;     
      SecureRandom sr = new SecureRandom();
      
      double x;
      double y;
      do{x=random.nextDouble() * 200+450;
      y=random.nextDouble() * 200+200;
      }while(Math.pow(y-300, 2)+Math.pow(x-550, 2)>=1200);//starting zone
      
      double x1;
      double y1;
      do{x1=random.nextDouble() * 750+300;
      y1=random.nextDouble() * 640;
      }while(Math.pow(y1-300, 2)+Math.pow(x1-550, 2)<1100);//excludes most of starting zone


      g2d.setPaint( new GradientPaint( ( int ) x, ( int ) y,
         new Color( 200, 200, 200), ( int ) x1, ( int ) y1, 
         new Color( 0,0,0), true ) );
      
      g2d.draw( new Line2D.Double( x,y, x1, y1 ) );
   } // end method makeline
   
   // draw a random rectangle
   private void makeRect( Graphics g ) 
   {   
      Graphics2D g2d = ( Graphics2D ) g;
      
      double x = random.nextDouble() * 300;
      double y = random.nextDouble() * 300;
      double width = random.nextDouble() * 100;
      double height = random.nextDouble() * 100;

      g2d.setPaint( new GradientPaint( ( int ) x, ( int ) y,
         new Color( random.nextFloat(), random.nextFloat(), 
         random.nextFloat() ), ( int )( x + width ),
         ( int )( y + height ),
         new Color( random.nextFloat(), random.nextFloat(),
         random.nextFloat() ), true ) );
      
      g2d.draw( new Rectangle2D.Double( x, y, width, height ) );
   } // end method makeRect
   
   // draw a random oval
   private void makeOval( Graphics g ) 
   {   
      Graphics2D g2d = ( Graphics2D ) g;
      
      double x = random.nextDouble() * 300;
      double y = random.nextDouble() * 300;
      double width = random.nextDouble() * 100;
      double height = random.nextDouble() * 100;

      g2d.setPaint( new GradientPaint( ( int ) x, ( int ) y,
         new Color( random.nextFloat(), random.nextFloat(),
         random.nextFloat() ), ( int )( x + width ),
         ( int )( y + height ), 
         new Color( random.nextFloat(), random.nextFloat(), 
         random.nextFloat() ), true ) );
      
      g2d.draw( new Ellipse2D.Double( x, y, width, height ) );
   } // end method makeOval
   
   // create a random rounded rectangle
   private void makeRoundRect( Graphics g ) 
   {
      Graphics2D g2d = ( Graphics2D ) g;
      
      double x = random.nextDouble() * 300;
      double y = random.nextDouble() * 300;
      double width = random.nextDouble() * 100;
      double height = random.nextDouble() * 100;
      double arcWidth = random.nextDouble() * width;
      double arcHeight = random.nextDouble() * height;

      g2d.setPaint( new GradientPaint( ( int ) x, ( int ) y,
         new Color( random.nextFloat(), random.nextFloat(),
         random.nextFloat() ), ( int )( x + width ),
         ( int )( y + height ), 
         new Color( random.nextFloat(), random.nextFloat(),
         random.nextFloat() ), true ) );
      
      g2d.draw( new RoundRectangle2D.Double( x, y, width, height, 
         arcWidth, arcHeight ) );
   } // end method makeRoundRect
} // end class SaverJPanel


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/