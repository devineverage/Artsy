package cs1302.p2;

import cs1302.effects.Artsy;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * This is the driver for this application. It ensures that GUI components
 * are created in the Event Dispatch Thread.
 */
public class Driver {

    /**
     * Creates the frame for this application and sets up the main panel.
     */
    public static void createAndShowGUI() {

        // Create the frame
       JButton button1 = new JButton("Checkers");
      JButton button2 = new JButton("Horizontal Stripes");
       JButton button3 = new JButton("Vertical Stripes");
      
      JToolBar toolbar = new JToolBar();
      toolbar.add(button1);
      toolbar.add(button2);
      toolbar.add(button3);
    	JFrame frame = new JFrame("Artsy!");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The single MyArtsy object that you are allowed to pass around
        Artsy artsy = new MyArtsy();
        ArtsyPanel panel1 = new ArtsyPanel();
        ArtsyPanel panel2 = new ArtsyPanel();
        ArtsyPanel panel3 = new ArtsyPanel();
        
        // Create the main panel and add it to the frame
        //toolbar.setLayout(new BorderLayout(toolbar,BorderLayout.PAGE_START));
        JPanel mainPanel = new MainPanel(panel1, panel2, panel3, button1, button2, button3);
        
        frame.add(toolbar, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setJMenuBar(new ArtsyMenuBar(panel1,panel2,panel3));

        

    	// show the window.
        frame.pack();
        frame.setVisible(true);
		
    } // createAndShowGUI

    /**
     * The entry point into the program. 
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    } // main

} // Driver
