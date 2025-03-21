package thewizardstower.controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import thewizardstower.*;

public class LevelSelectionController implements ActionListener {
    private JFrame levelSelection;
    private JLabel levelImage, levelName, levelDescription;
    private JButton previous, next, levelStart, back;

    public LevelSelectionController(JFrame levelSelection, JLabel levelImage, JLabel levelName, JLabel levelDescription,
            JButton previous, JButton next, JButton levelStart, JButton back) {
        this.levelSelection = levelSelection;
        this.levelImage = levelImage;
        this.levelName = levelName;
        this.levelDescription = levelDescription;
        this.previous = previous;
        this.next = next;
        this.levelStart = levelStart;
        this.back = back;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
        }
        if (e.getSource() == previous) {
        }
        if (e.getSource() == levelStart) {
        }
        if (e.getSource() == back) {
            JFrame mainMenu = new MainMenu();
            levelSelection.dispose();
            mainMenu.setVisible(true);  
        }
    } 
}
