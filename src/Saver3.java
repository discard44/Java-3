import java.awt.Button;
   import javax.swing.JFrame;

   public class Saver3
   {
      public static void main( String args[] ) 
      {
      // create frame for SaverJPanel
         JFrame frame = new JFrame( "Saver3" );
         frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
         SaverJPanel saverJPanel = new SaverJPanel();
         
         
        frame.setSize(1024, 675);// set frame size
        frame.add(saverJPanel);
        frame.setResizable(true);
        
        frame.setVisible( true ); // display frame
      } // end main
   } // end class Saver3