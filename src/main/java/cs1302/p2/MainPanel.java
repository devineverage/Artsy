package cs1302.p2;

import cs1302.effects.Artsy;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * This is the main panel for this application. Components
 * and sub-panels should be added to this panel.
 */
public class MainPanel extends JPanel {

    //private JLabel label;
    //private JPanel bp = new JPanel();
    private ArtsyPanel panel1;
    private JToolBar toolbar = new JToolBar();
   // private JLabel nameLabel1;
    private ArtsyPanel panel2;
   // private JLabel nameLabel2;
    private ArtsyPanel panel3;
   // private JLabel nameLabel3;
    private JButton buttonC;
    private JButton buttonH;
    private JButton buttonV;
    private MyArtsy Artsy1 = new MyArtsy();
  
   



    /** 
     * Creates a new <code>MainPanel</code> object. Feel free
     * to change the parameters to this constructor if needed. 
     * However, if you do change the parameters, you will need
     * to update the <code>Driver</code> class where an instance
     * of this class is created.
     */
    public MainPanel(ArtsyPanel panelA, ArtsyPanel panelB, ArtsyPanel panelC, JButton c, JButton h, JButton v) {
        super();
        
        JLabel nameLabel1 = new JLabel("Image 1: default.png");
        JLabel nameLabel2 = new JLabel("Image 2: default.png");
        JLabel nameLabel3 = new JLabel("Result");
        
        buttonC = c;
        buttonH = h;
        buttonV = v;
        
        panel1 = panelA;
        panel2 = panelB;
        panel3 = panelC;
        
        panel1.add(nameLabel1);
        panel2.add(nameLabel2);
        panel3.add(nameLabel3);

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
        
        buttonC.addActionListener(n -> { System.out.println("Checkers works");  
        
        });
        buttonH.addActionListener(k -> { System.out.println("Horizontal works");  
          panel3.setImage(Artsy1.doHorizontalStripes(panel1.getImage(),panel2.getImage(), panel3.askHor()));
          
        });
        buttonV.addActionListener(x -> { System.out.println("Vertical works");  
          panel3.setImage(Artsy1.doVerticalStripes(panel1.getImage(),panel2.getImage(),panel3.askVert()));
        });

        
        
        
        
        //label = new JLabel("Artsy!"); // initialize the label
        //add(label);
        //add(nameLabel1);
        //add(button1, BorderLayout.PAGE_START);  
        //add(button2);
        //add(button3);
        //add(toolbar, BorderLayout.PAGE_START);
        add(panel1); 
        //add(nameLabel2);
        add(panel2);
        //add(nameLabel3);
        add(panel3);                // add the label to the panel
        
    } // MainPanel

} // MainPanel
