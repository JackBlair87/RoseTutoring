//Jack Blair 7/17/19
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PanelPix extends JPanel
{
   private DisplayPix display;
   private ScoreboardPix scoreboard;
   
   public PanelPix()
   {
      setLayout(new BorderLayout());
   //
   // north
   //
      scoreboard = new ScoreboardPix();
      add(scoreboard,BorderLayout.NORTH);
   //
   // east
   //
      JPanel east = new JPanel();
      east.setLayout(new GridLayout(18,1));
   /******************************************************************  1 */
      JButton zero = new JButton("Zero Blue");
      zero.addActionListener(new Listener_zeroBlue());
      east.add(zero);
   /******************************************************************  2 */
      JButton negate = new JButton("Negate");
      negate.addActionListener(new Listener_negate());
      east.add(negate);
   /******************************************************************  3 */
      JButton grayscale = new JButton("Grayscale");
      grayscale.addActionListener(new Listener_grayscale());
      east.add(grayscale);
   /******************************************************************  4 */
      JButton sepia = new JButton("Sepia Tone");
      sepia.addActionListener(new Listener_sepia());
      east.add(sepia);
   /******************************************************************  5 */
      JButton blur = new JButton("Blur");
      blur.addActionListener(new Listener_blur());
      east.add(blur);			
   /******************************************************************  6 */
      JButton posterize = new JButton("Posterize");
      posterize.setEnabled(true);
      posterize.addActionListener(new Listener_posterize());
      east.add(posterize);			
   /******************************************************************  7 */
      JButton splash = new JButton("Color Splash");
      splash.setEnabled(true);
      splash.addActionListener(new Listener_splash());
      east.add(splash);					
   /******************************************************************  8 */
      JButton mirrorLR = new JButton("Mirror Left-Right");
      mirrorLR.setEnabled(true);
      mirrorLR.addActionListener(new Listener_mirrorLR());
      east.add(mirrorLR);			
   /******************************************************************  9 */
      JButton mirrorUD = new JButton("Mirror Up-Down");
      mirrorUD.setEnabled(true);
      mirrorUD.addActionListener(new Listener_mirrorUD());
      east.add(mirrorUD);
   /****************************************************************** 10 */
      JButton flipLR = new JButton("Flip Left-Right");
      flipLR.setEnabled(true);
      flipLR.addActionListener(new Listener_flipLR());
      east.add(flipLR);
   /****************************************************************** 11 */
      JButton flipUD = new JButton("Flip Up-Down");
      flipUD.setEnabled(true);
      flipUD.addActionListener(new Listener_flipUD());
      east.add(flipUD);			
   /****************************************************************** 12 */
      JButton pixelate = new JButton("Pixelate");
      pixelate.setEnabled(true);
      pixelate.addActionListener(new Listener_pixelate());
      east.add(pixelate);			
   /****************************************************************** 13 */
      JButton sunsetize = new JButton("Sunsetize");
      sunsetize.setEnabled(true);
      sunsetize.addActionListener(new Listener_sunsetize());
      east.add(sunsetize);	
   /****************************************************************** 14 */
      JButton redeye = new JButton("Remove Red-Eye");
      redeye.setEnabled(true);
      redeye.addActionListener(new Listener_redeye());
      east.add(redeye);									
   /****************************************************************** 15 */
      JButton detect = new JButton("Edge Detector");
      detect.setEnabled(true);
      detect.addActionListener(new Listener_detect());
      east.add(detect);
   /****************************************************************** 16a */
      JButton encode = new JButton("Encode");
      encode.setEnabled(true);
      encode.addActionListener(new Listener_encode());
      east.add(encode);
   /****************************************************************** 16b */
      JButton decode = new JButton("Decode");
      decode.setEnabled(true);
      decode.addActionListener(new Listener_decode());
      east.add(decode);		
   
   /****************************************************************** 17 */
      JButton chromakey = new JButton("Chromakey");
      chromakey.setEnabled(true);
      chromakey.addActionListener(new Listener_chromakey());
      east.add(chromakey);		
   
   /****************************************************************** END */      
      add(east,BorderLayout.EAST);
   //
   // center
   //
      display = new DisplayPix();
      display.addMouseListener(new Mouse());
   
      display.addKeyListener(new Key());
      display.setFocusable(true);
      add(display,BorderLayout.CENTER);
   //
   // south
   //
      JPanel south = new JPanel();
      south.setLayout(new FlowLayout());
      JButton restore = new JButton("Restore Original Image");
      restore.addActionListener(new Listener_restore());
      south.add(restore);
      JButton openimg = new JButton("Open an Image File");
      openimg.addActionListener(new Listener_openimg());
      south.add(openimg);
      JButton undo = new JButton("Undo");
      undo.setEnabled(true);
      undo.addActionListener(new Listener_undo());
      south.add(undo);
      add(south,BorderLayout.SOUTH);
   }    

   private class Listener_zeroBlue implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.zeroBlue();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_negate implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.negate();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_grayscale implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.grayscale();
         update( display.getXval() , display.getYval() );
      }
   }
   
   private class Listener_sepia implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.sepia();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_blur implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.blur();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_posterize implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.posterize();
         update( display.getXval() , display.getYval() );
      }
   }
   
   private class Listener_splash implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.splash();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_mirrorLR implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.mirrorLR();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_mirrorUD implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.mirrorUD();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_flipLR implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.flipLR();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_flipUD implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.flipUD();
         update( display.getXval() , display.getYval() );
      }
   }
   
   private class Listener_pixelate implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.pixelate();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_sunsetize implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.sunsetize();
         update( display.getXval() , display.getYval() );
      }
   }
   
   private class Listener_redeye implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.redeye();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_detect implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.detect();
         update( display.getXval() , display.getYval() );
      }
   }
   
   private class Listener_encode implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.encode();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_decode implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.decode();
         update( display.getXval() , display.getYval() );
      }
   } 
   
   private class Listener_chromakey implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.chromakey();
         update( display.getXval() , display.getYval() );
      }
   } 

   private class Listener_restore implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         display.resetImage();
         update( display.getXval() , display.getYval() );
      }
   }
   
   private class Listener_openimg implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if( display.openImage() )
         {
            update( display.getXval() , display.getYval() );
         }
      }
   }

   private class Listener_undo implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //yeah do this
      }
   }
   
   private class Mouse extends MouseAdapter
   {
      public void mouseClicked(MouseEvent e)
      {
         update( e.getX() , e.getY() );
      }
   }
   
   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         switch( e.getKeyCode() )
         {
            case KeyEvent.VK_UP:    display.up();    
               break;
            case KeyEvent.VK_DOWN:  display.down();  
               break;
            case KeyEvent.VK_LEFT:  display.left();  
               break;
            case KeyEvent.VK_RIGHT: display.right(); 
               break;
         }
      //
         update( display.getXval() , display.getYval() );
      }
   }   
     
   private void update(int x, int y)
   {
      int rgb = display.getRGB(x,y);
   //
      scoreboard.update(x,y,rgb);
   //
      display.update(x,y);
      display.repaint();
   //
      display.requestFocus();
   }
}