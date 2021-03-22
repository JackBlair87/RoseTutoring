import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.awt.event.*; 
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.File;
import java.awt.Graphics;

import java.util.*;

public class TrafficSim{
   public Car theBestCar;
   public Car betterCar;
   private TrafficListener tl;

   public TrafficSim(TrafficListener t){
      theBestCar = new Car(200, 500, "GreenCar.png", 0.3, 40);
      betterCar = new Car(200, 300, "BlueCar.png", 0.5, 5);
   }
   
   public void tick(double deltaT){
      theBestCar.tick(deltaT, tl.getMode());
      betterCar.tick(deltaT, "F");
   }
   
   public void render(Graphics g){
      theBestCar.render(g);
      betterCar.render(g);
   }
   
   public Car getCar(){
      return theBestCar;
   }
   
   public void setTL(TrafficListener t){
      tl = t;
   }
}