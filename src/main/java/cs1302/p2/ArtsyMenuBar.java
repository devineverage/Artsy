package cs1302.p2;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ArtsyMenuBar extends JMenuBar {
 
  private JMenu fileMenu = new JMenu("File");
  private JMenu openMenu = new JMenu("Open");
  
  private JMenuItem saveResult = new JMenuItem("Save Result As");
  private JMenuItem exitItem = new JMenuItem("Exit");
  private JMenuItem image1 = new JMenuItem("Open Image 1");
  private JMenuItem image2 = new JMenuItem("Open Image 2");
  
  public ArtsyMenuBar(ArtsyPanel p1, ArtsyPanel p2, ArtsyPanel p3) {
  super();
  add(fileMenu);
  fileMenu.add(openMenu);
  openMenu.add(image1);
  openMenu.add(image2);
  fileMenu.add(saveResult);
  fileMenu.add(exitItem);
  exitItem.addActionListener(e -> System.exit(0));
  image1.addActionListener(i -> {           // add listener to button
      System.out.println("added image");
      p1.updateFileImage();
      });
  image2.addActionListener(p -> {           // add listener to button
      System.out.println("added image");
      p2.updateFileImage();
      });
  saveResult.addActionListener(z -> {
      p3.saveImage();
  });
  }

}