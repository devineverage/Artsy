package cs1302.p2;
import java.awt.Color;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JPanel;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;


public class ArtsyPanel extends JPanel {

  int width = 300;
  int height = 300;
  int imageNum;
  double numInput;
  double userDeg;
  int userCheck;
  int userHor;
  int userVer;
  boolean isNew = false;
  boolean thirdPanel = false;
  final JFileChooser fc = new JFileChooser();
  JFileChooser bg = new JFileChooser();
  MyArtsy Artsy1 = new MyArtsy();

  
  JFrame mainFrame = new JFrame();
  private JButton buttonRotate = new JButton("Rotate");
  private JButton buttonReset = new JButton("Reset");
  private JButton buttonC;
  private JButton buttonH;
  private JButton buttonV; 
  
  private BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
  private BufferedImage eh = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
  private BufferedImage tq = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
  private JLabel picLabel;
  //Buffered bi = null;
  File defaultImage  = new File("/home/ugrads/everage/Everage-Devin-p2/resources/default.png");
  //File sample = new File("/home/ugrads/everage/Everage-Devin-p2/samples/sample1.png");
  File file1;
  //JPopupMenu rotatePop = new JPopupMenu("Rotate image options");
  //JLabel prompt = new JLabel("Please enter an angle, in degrees:");
  //JTextField usinput = new JTextField("45.0");
   
  
  public ArtsyPanel() {
  
  super();
  
  //buttonC = c;
  //buttonH = h;
  //buttonV = v;
  imageNum++;
  //JLabel label1 = new JLabel("Image " + imageNum);
  setPreferredSize(new Dimension(320, 500));
  //add(label1);
  setDefault();
  //updateImage(bi);
  
  
    buttonRotate.addActionListener(e -> {           // add listener to button
      System.out.println("pushed the button! ");
        numInput = askRotate();
        if(isNew == false){
        tq = Artsy1.doRotate(bi, numInput);
        JLabel picLabel3 = new JLabel(new ImageIcon(tq));
        removeAll();
        revalidate();
        repaint();
        add(picLabel3);
        add(buttonRotate);
        add(buttonReset);
        }else{
        
        tq = Artsy1.doRotate(eh, numInput);
        JLabel picLabel3 = new JLabel(new ImageIcon(tq));
        removeAll();
        revalidate();
        repaint();
        add(picLabel3);
        add(buttonRotate);
        add(buttonReset);
          
        }
      
      });
      
      buttonReset.addActionListener(d -> {           // add listener to button
      System.out.println("pushed the button 2! ");
        if(isNew == false || thirdPanel == true){
        tq = bi;
        JLabel picLabel3 = new JLabel(new ImageIcon(tq));
        removeAll();
        revalidate();
        repaint();
        add(picLabel3);
        add(buttonRotate);
        add(buttonReset);
        }else{
        
        tq = eh;
        JLabel picLabel3 = new JLabel(new ImageIcon(tq));
        removeAll();
        revalidate();
        repaint();
        add(picLabel3);
        add(buttonRotate);
        add(buttonReset);
          
        }
      
      });
      
      
   	
    add(buttonRotate);
    add(buttonReset);
    
  }
  public void setDefault()
  {
     try {
      bi = ImageIO.read(defaultImage);
  } catch (IOException e) {
    System.out.println("Error");
  } // try
  
 
  if(bi != null){
    System.out.println("Success");
    picLabel = new JLabel(new ImageIcon(bi));
    add(picLabel);
  } // if
  
  }
  public void updateFileImage()
  {
    isNew = true;
   int returnVal = fc.showOpenDialog(mainFrame);
   if(returnVal == fc.APPROVE_OPTION)
   {
   file1 = fc.getSelectedFile();
   try {
      eh = ImageIO.read(file1);
  } catch (IOException t) {
    System.out.println("Error");
  } // try
  JLabel picLabel2 = new JLabel(new ImageIcon(eh));
  if(eh != null){ 
    System.out.println("Success 2");
    /*remove(picLabel);
    remove(picLabel2);
    remove(button1);
    remove(button2);*/
    removeAll();
    revalidate();
    repaint();
    add(picLabel2);
    add(buttonRotate);
    add(buttonReset);
    }
  }
  
 }
 
   public double askRotate()
   {
     try{
      userDeg = Double.parseDouble(JOptionPane.showInputDialog("Please enter an angle, in degrees:"));
      }catch(NullPointerException b) {
        System.out.println("No input");
      }catch(NumberFormatException m){
        JOptionPane.showMessageDialog(null, "Please enter a number, try again");
        askRotate();
      }
      System.out.println(userDeg);
      
      return userDeg;
     
   }
   
   public int askCheck()
   {
     try{
     userCheck = Integer.parseInt(JOptionPane.showInputDialog("Please enter the desired checker width, in pixels."));
      }catch(NumberFormatException z) {
        if(userHor == 0){
          System.out.println("no input");
        } else{
        JOptionPane.showMessageDialog(null, "Please enter a number, try again");
        askCheck();
        }
      }catch(NullPointerException qw) {
      System.out.println("No input");

      }
      return userCheck;
   
   }
   
   public int askHor()
   {
     try{
     userHor = Integer.parseInt(JOptionPane.showInputDialog("Please enter the desired stripe height, in pixels."));
      }catch(NumberFormatException z) {
      
        System.out.println("no input");
      
        JOptionPane.showMessageDialog(null, "Please enter a number, try again");
        askHor();
        System.out.println("Please enter a number, try again");
      
      }catch(NullPointerException aw) {
      System.out.println("No input");
      }
      
      return userHor;
   
   }
   
   public int askVert()
   {
     try{
     userVer = Integer.parseInt(JOptionPane.showInputDialog("Please enter the desired stripe width, in pixels."));
      }catch(NumberFormatException rw) {
       
        System.out.println("no input");
        
        JOptionPane.showMessageDialog(null, "Please enter a number, try again");
        askVert();
        System.out.println("Please enter a number, try again");
        
      }catch(NullPointerException mw) {
      System.out.println("No input");
      }
      
      return userVer;
   
   }
   
   public void setImage(BufferedImage g)
   {
     thirdPanel = true;
     isNew = true;
     eh = g;
     JLabel picLabel3 = new JLabel(new ImageIcon(eh));
     removeAll();
     revalidate();
     repaint();
     add(picLabel3);
     add(buttonRotate);
     add(buttonReset);
   }
   
   public void saveImage()
   {
     int saveVal = bg.showSaveDialog(mainFrame);
     if(saveVal == bg.APPROVE_OPTION)
     {
        File saveFile = bg.getSelectedFile();
        // save to file
      }
   }
   
   public BufferedImage getImage()
   {
     if(isNew == false)
     {
       return bi;
     }else{
     
       return eh;
     }
     
   }
  /* public String getFileName()
   {
     String str;
   if(isNew == false){
     str = FileUtils.readFileToString(defaultImage);
     
     }else{
      str = FileUtils.readFileToString(file1);
     
   }
   
   return str;
   
   }*/
    
  

}