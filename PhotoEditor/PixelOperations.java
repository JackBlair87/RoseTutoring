import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

//
public class PixelOperations
{
   public Color[][] getArray(BufferedImage img)
   {
      Color[][] arr;
   	//
      int numcols = img.getWidth();
      int numrows = img.getHeight();
   	//
      arr = new Color[numrows][numcols];
   	//
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            int rgb = img.getRGB(k,j);
         	//
            arr[j][k] = new Color(rgb);
         }
      }
   	//
      return arr;
   }
   public void setImage(BufferedImage img, Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            //
            int rgb = tmp.getRGB();
            //
            img.setRGB(k,j,rgb);
         }
      }
   }
   //
	/**********************************************************************/
	//
	// pixel operations
	// 
   public void zeroBlue(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            arr[j][k] = new Color( tmp.getRed(), tmp.getGreen(), 0 );
         }
      }
   }
   
   public void negate(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            arr[j][k] = new Color(255 - tmp.getRed(), 255 - tmp.getGreen(), 255 - tmp.getBlue());
         }
      }
   }
   
   public void grayscale(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int grayThing = (int) ((tmp.getRed() + tmp.getGreen() + tmp.getBlue()) / 3);
            
            arr[j][k] = new Color(grayThing, grayThing, grayThing);
         }
      }
   }
   
   public void sepia(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int redThing = (int) ((tmp.getRed() * .393) + (tmp.getGreen() * .769) + (tmp.getBlue() * .189));
            int greenThing = (int) ((tmp.getRed() * .349) + (tmp.getGreen() * .686) + (tmp.getBlue() * .168));
            int blueThing = (int) ((tmp.getRed() * .272) + (tmp.getGreen() * .534) + (tmp.getBlue() * .131));
            if(redThing > 255){
               redThing = 255;
            }
            
            if(greenThing > 255){
               greenThing = 255;
            }
            
            if(blueThing > 255){
               redThing = 255;
            }
            
            arr[j][k] = new Color(redThing, greenThing, blueThing);
         }
      }
   }      
  
   public void blur(Color[][] arr)
   {
      for(int j = 1; j < arr.length - 1; j++)
      {
         for(int k = 1; k < arr[0].length - 1; k++)
         {
            Color tmp = arr[j][k];
            Color tmp1 = arr[j+1][k];
            Color tmp2 = arr[j - 1][k];
            Color tmp3 = arr[j][k + 1];
            Color tmp4 = arr[j][k - 1];
            int redThing = (int) ((tmp1.getRed() + tmp2.getRed() + tmp3.getRed() + tmp4.getRed()) / 4);
            int greenThing = (int) ((tmp1.getGreen() + tmp2.getGreen() + tmp3.getGreen() + tmp4.getGreen()) / 4);
            int blueThing = (int) ((tmp1.getBlue() + tmp2.getBlue() + tmp3.getBlue() + tmp4.getBlue()) / 4);
            arr[j][k] = new Color(redThing, greenThing, blueThing);
         }
      }
   }
   
   public void posterize(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int theColor1 = (int) (tmp.getRed());
            int theColor2 = (int) (tmp.getGreen());
            int theColor3 = (int) (tmp.getBlue());
            if(theColor1 >= 0 && theColor1 < 60){
               theColor1 = 30;
            }
            else if(theColor1 >= 60 && theColor1 < 120){
               theColor1 = 90;
            }
            else if(theColor1 >= 120 && theColor1 < 180){
               theColor1 = 150;
            }
            else if(theColor1 >= 180 && theColor1 < 240){
               theColor1 = 210;
            }
            else if(theColor1 >= 240 && theColor1 < 255){
               theColor1 = 247;
            }
            if(theColor2 >= 0 && theColor2 < 60){
               theColor2 = 30;
            }
            else if(theColor2 >= 60 && theColor2 < 120){
               theColor2 = 90;
            }
            else if(theColor2 >= 120 && theColor2 < 180){
               theColor2 = 150;
            }
            else if(theColor2 >= 180 && theColor2 < 240){
               theColor2 = 210;
            }
            else if(theColor2 >= 240 && theColor2 < 255){
               theColor2 = 247;
            }
            if(theColor3 >= 0 && theColor3 < 60){
               theColor3 = 30;
            }
            else if(theColor3 >= 60 && theColor3 < 120){
               theColor3 = 90;
            }
            else if(theColor3 >= 120 && theColor3 < 180){
               theColor3 = 150;
            }
            else if(theColor3 >= 180 && theColor3 < 240){
               theColor3 = 210;
            }
            else if(theColor3 >= 240 && theColor3 < 255){
               theColor3 = 247;
            }
            arr[j][k] = new Color(theColor1, theColor2, theColor3);
         }
      }
   }

   public void splash(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            int grayThing = (int) ((tmp.getRed() + tmp.getGreen() + tmp.getBlue()) / 3);
            if((tmp.getBlue() + tmp.getGreen()) < tmp.getRed()){
               arr[j][k] = new Color(tmp.getRed(), grayThing, grayThing);
            }
            else{
               arr[j][k] = new Color(grayThing, grayThing, grayThing);
            }
         }
      }
   }
   
   public void mirrorLR(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            arr[j][arr[0].length - k - 1] = new Color(tmp.getRed(), tmp.getGreen(), tmp.getBlue());
            
         }
      }
   }
   
   public void mirrorUD(Color[][] arr)
   {
      for(int j = 0; j < arr.length; j++)
      {
         for(int k = 0; k < arr[0].length; k++)
         {
            Color tmp = arr[j][k];
            arr[arr.length - j - 1][k] = new Color(tmp.getRed(), tmp.getGreen(), tmp.getBlue());
            
         }
      }
   }
   
   public void flipLR(Color[][] arr)
   {
      for(int j = 0; j < (arr.length); j++)
      {
         for(int k = 0; k < (arr[0].length / 2); k++)
         {
            Color tmp = arr[j][k];
            Color tmp2 = arr[j][arr[0].length - k - 1];
            arr[j][k] = new Color(tmp2.getRed(), tmp2.getGreen(), tmp2.getBlue());
            arr[j][arr[0].length - k - 1] = new Color(tmp.getRed(), tmp.getGreen(), tmp.getBlue());
         }
      }
   }
   
   public void flipUD(Color[][] arr)
   {
      for(int j = 0; j < (arr.length / 2); j++)
      {
         for(int k = 0; k < (arr[0].length); k++)
         {
            Color tmp = arr[j][k];
            Color tmp2 = arr[arr.length - j -1][k];
            arr[j][k] = new Color(tmp2.getRed(), tmp2.getGreen(), tmp2.getBlue());
            arr[arr.length - j -1][k] = new Color(tmp.getRed(), tmp.getGreen(), tmp.getBlue());
            
         }
      }
   }
   
   public void pixelate(Color[][] arr)
   {
      int pixelHeight = Integer.parseInt(JOptionPane.showInputDialog("Enter Pixel Height"));
   
      for(int j = 0; j < arr.length; j += pixelHeight)
      {
         for(int k = 0; k < arr[0].length; k += pixelHeight)
         {
            Color tmp = arr[j][k];
            
            for(int jd = j; (jd < j + pixelHeight) && (jd < arr.length); jd++) 
            {
               for(int kd = k; (kd < k + pixelHeight) && (kd < arr[0].length); kd++) {
               
                  arr[jd][kd] = new Color(tmp.getRed(), tmp.getGreen(), tmp.getBlue());
               }
            }
         }
      }
   }
   
   public void sunsetize(Color[][] arr)
   {
      for(int j = 0; j < (arr.length); j++)
      {
         for(int k = 0; k < (arr[0].length); k++)
         {
            Color tmp = arr[j][k];
            arr[j][k] = new Color(tmp.getRed(), (int) (tmp.getGreen() * .80), (int) (tmp.getBlue() * .80));
            
         }
      }
   }
   
   public void redeye(Color[][] arr)
   {
      for(int j = 327; j < 535; j++)
      {
         for(int k = 584; k < 1079; k++)
         {
            Color tmp = arr[j][k];
            if(tmp.getRed() > tmp.getGreen() + tmp.getBlue()){
               arr[j][k] = new Color(40, 40, 50);
            }    
         }
      }
   }
   
   public void detect(Color[][] arr)
   {
      for(int j = 0; j < (arr.length); j++)
      {
         for(int k = 0; k < (arr[0].length - 1); k++)
         {
            Color tmp = arr[j][k];
            Color tmp2 = arr[j][k + 1];
            if(Math.abs(tmp.getRed() - tmp2.getRed()) >= 15){ 
               arr[j][k] = new Color(0, 0, 0);
            }    
            else
               arr[j][k] = new Color(255, 255, 255);
         }
      }
   }

   public void encode(Color[][] arr)
   {
      for(int j = 0; j < (arr.length); j++)
      {
         for(int k = 0; k < (arr[0].length); k++)
         {
            Color tmp = arr[j][k];
            if((tmp.getRed() % 2) == 1){
               arr[j][k] = new Color(tmp.getRed() - 1, tmp.getGreen(), tmp.getBlue());
            }
            
            
         }
      }
   }
   
   public void decode(Color[][] arr)
   {
      for(int j = 0; j < (arr.length); j++)
      {
         for(int k = 0; k < (arr[0].length); k++)
         {
            Color tmp = arr[j][k];
            if((tmp.getRed() % 2) == 1){
               arr[j][k] = new Color(tmp.getRed() - 1, tmp.getGreen(), tmp.getBlue());
            }
         }
      }
   }
   
   public void chromakey(Color[][] arr)
   {
      for(int j = 0; j < (arr.length); j++)
      {
         for(int k = 0; k < (arr[0].length); k++)
         {
            Color tmp = arr[j][k];
            if((tmp.getRed() % 2) == 1){
               arr[j][k] = new Color(tmp.getRed() - 1, tmp.getGreen(), tmp.getBlue());
            }
         }
      }
   }





}