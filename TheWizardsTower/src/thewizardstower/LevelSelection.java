package q3aa3_tau_alcayde.tolentino.gui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class LevelSelection extends JFrame {
    
    private JPanel container, levelImagePanel, levelSwitchingPanel, levelNamePanel, levelStartPanel, levelDescriptionPanel;
    private LevelSelectionController controller;
    private JLabel levelImage, levelName, levelDescription;
    private JButton previous, next, levelStart;
    
    //parameters in constructor are for display purposes. THIS WILL SOON BE REPLACED WITH CLASS FLOOR OBJECTS
    public LevelSelection(/*ImageIcon levelImage, ImageIcon prev, ImageIcon nex,*/ String name, String description) {
        /* DISPLAY */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1080, 720);
        
        /* setting up container */
        container = new JPanel(new GridLayout(4, 1, 10, 10)); //TO-DO: Change to gridbag formatting, fix sizing issues
        this.add(container);
        
        /* setting up panels and positions */
        levelImagePanel = new JPanel(); //level image panel (for levelImage jlabel)
        levelImagePanel.setPreferredSize(new Dimension(1000, 500));
        container.add(levelImagePanel);
        
        levelNamePanel = new JPanel(); //level name panel (for levelName jlabel)
        container.add(levelNamePanel);
        
        levelStartPanel = new JPanel(); //level start panel (for levelStart jbutton)
        container.add(levelStartPanel);
        
        levelDescriptionPanel = new JPanel(); //level description panel (for levelDescription jlabel)
        container.add(levelDescriptionPanel);
        
        levelSwitchingPanel = new JPanel(); //level switching panel (for next and previous jbuttons) (TO DO: fix format later)
        levelImagePanel.add(levelSwitchingPanel); //this panel is placed in the levelImagePanel
        
        
        
        //FOR DEBUGGING. REMOVE AS SOON AS FIXED
        
        levelImagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //levelNamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //levelStartPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //levelDescriptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //levelSwitchingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
 
        //END OF DEBUGGING SECTION
        
        
        
        
        /* setting up level IMAGE object/s */
        
        
        
        
        /* setting up leve NAME object/s */
        levelName = new JLabel(name);
        levelName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 27));
        levelName.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelNamePanel.add(levelName);
        
        
        
        /* setting up level START object/s */
        
        
        
        
        
        /* setting up level DESCRIPTION object/s */
        levelDescription = new JLabel(description);
        levelDescription.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        levelDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelNamePanel.add(levelDescription);

        /* setting up level SWITCHING object/s */
        
        

        /* CONTROLLER STARTS HERE */
        
        
        
        /* for visibility */
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
