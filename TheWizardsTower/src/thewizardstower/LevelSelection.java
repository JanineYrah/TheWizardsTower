package thewizardstower;

import thewizardstower.controller.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class LevelSelection extends JFrame {
    
    private JPanel container, levelImagePanel, levelNamePanel, levelStartPanel, levelDescriptionPanel;
    private LevelSelectionController controller;
    private JLabel levelImage, levelName, levelDescription;
    private JButton previous, next, levelStart, back;

    public LevelSelection() {
        /* DISPLAY */
        super("Select a level");
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        /* setting up container */
        container = new JPanel(new FlowLayout());
        container.setSize(1000, 720);
        this.getContentPane().add(container);
        
        /* setting up panels and positions */
        levelImagePanel = new JPanel(new FlowLayout());
        levelImagePanel.setPreferredSize(new Dimension(1000, 700));
        container.add(levelImagePanel);
        
        levelNamePanel = new JPanel(new FlowLayout());
        levelNamePanel.setPreferredSize(new Dimension(400, 50));
        container.add(levelNamePanel);
        
        levelStartPanel = new JPanel(new FlowLayout());
        levelStartPanel.setPreferredSize(new Dimension(300, 50));
        container.add(levelStartPanel);
        
        levelDescriptionPanel = new JPanel(new FlowLayout());
        levelDescriptionPanel.setPreferredSize(new Dimension(700, 200));
        container.add(levelDescriptionPanel);
        

        /* setting up level IMAGE object/s */
        levelImage = new JLabel();
        
        levelImagePanel.add(levelImage);
        
        
        
        
        /* setting up leve NAME object/s */
        levelName = new JLabel();
        
        levelNamePanel.add(levelImage);
        
        
        /* setting up level START object/s */
        levelStart = new JButton();
        
        levelStartPanel.add(levelImage);
        
        
        /* setting up level DESCRIPTION object/s */
        levelDescription = new JLabel();
        
        levelDescriptionPanel.add(levelImage);

        
        
        
        /* setting up level SWITCHING object/s (next and prev) */
        previous = new JButton("Prev");
        previous.setPreferredSize(new Dimension(100, 40));
        this.add(previous);
        
        next = new JButton("Next");
        next.setPreferredSize(new Dimension(100, 40));
        this.add(next);

        /* setting up back object */
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(100, 40));
        this.add(back);

        
        
        
        
        /* CONTROLLER STARTS HERE */
        controller = new LevelSelectionController(this, levelImage, levelName, levelDescription, previous, next, levelStart, back);
        previous.addActionListener(controller);
        next.addActionListener(controller);
        levelStart.addActionListener(controller);
        back.addActionListener(controller);

        /* for visibility */
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
