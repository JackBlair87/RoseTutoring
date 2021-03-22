import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;
import java.awt.*; 
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;


public class Car{
   //Physics
   private int myX; //Position
   private int myY;
   private double velX;
   private double velY;
   private double accelX;
   private double accelY;
   private double maxAccel;
   
   //Graphics
   private int myLength = 150;
   private int myHeight = 75;
   private String icon;
   private BufferedImage myCar;
   
   public Car(int x, int y, String colorFile, double d, double da){
      icon = colorFile;
      
      myX = x;
      myY = y;
      velX = da;
      velY = 0;
      accelX = 0.0;
      accelY = 0.0;
      maxAccel = d;
      
      try{
         myCar = ImageIO.read(new File(icon));
      }catch(Exception e) { }
   }
   
   public void tick(double delta, String s){
   //acceleration
      if(s.equals("F")){
         accelX = maxAccel;
      }
      //deceleration
      else if(s.equals("R")){
         accelX = -maxAccel;
      }
      else{
         if(velX > 0){
            accelX = -maxAccel;
         }
         else if(velX < 0){
            accelX = maxAccel;
         }
         else{
            accelX = 0.0;
         }
      }
   
      velX += accelX;
      velY += accelY;
      myX += velX * delta;;
      myY += velY * delta;;
      
      if(myX > 1510){
         myX = -60;
      }
      else if(myX < -60){
         myX = 1510;
      }
   }
   
   //Draws the car
   public void render(Graphics g){
      double x = myX - (myLength/2); //Draws car from center
      double y = myY - (myHeight/2);
      g.drawImage(myCar, (int) x, (int) y, (int) (x + myLength), (int) (y + myHeight), 0, 0, 300, 150, null);
   }
}

//0, 0        X          1440, 0

//Y


//0, 800                1440, 800