/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thewizardstower.controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import thewizardstower.*;

/**
 *
 * @author janineyrahtolentino
 */
public class MainMenuController implements MouseListener {
    private JFrame mainMenu;
    private JButton newGame, continueGame, instructions, settings, aboutUs, quit;
    private int page, maxPage, confirmChoice;
    
    public MainMenuController(JFrame mainMenu, JButton newGame, JButton continueGame, JButton instructions, JButton settings,
                              JButton aboutUs, JButton quit) {
        this.mainMenu = mainMenu;
        this.newGame = newGame;
        this.continueGame = continueGame;
        this.instructions = instructions;
        this.settings = settings;
        this.aboutUs = aboutUs;
        this.quit = quit;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == newGame) {  
            JFrame levelSelectionScreen = new LevelSelection();
            mainMenu.dispose();
            levelSelectionScreen.setVisible(true);            
        }
        if (e.getSource() == continueGame) {
            /* [TEMPORARY] for showing game screen */
            JFrame gameScreen = new GameScreen();
            mainMenu.dispose();
            gameScreen.setVisible(true);          
        }
        if (e.getSource() == instructions) {
            //JFrame instructionsScreen = new Instructions(); //Input subject to display into new subject details screen
            mainMenu.dispose();
            //instructionsScreen.setVisible(true);            
        }        
        if (e.getSource() == settings) {
            JFrame settingsScreen = new MainMenuSettings(); //Input subject to display into new subject details screen
            mainMenu.dispose();
            settingsScreen.setVisible(true);            
        }        
        if (e.getSource() == aboutUs) {
            JFrame aboutUsScreen = new AboutUs(); //Input subject to display into new subject details screen
            mainMenu.dispose();
            aboutUsScreen.setVisible(true);            
        }
        if (e.getSource() == quit) {
            confirmChoice = JOptionPane.showConfirmDialog(mainMenu, "Are you sure you want to quit?",
                                                          "Quit?", JOptionPane.YES_NO_OPTION); //confirming
            if (confirmChoice == JOptionPane.YES_OPTION) {
                mainMenu.dispose(); //If YES is chosen, exit and end all executions on close
            } else if (confirmChoice == JOptionPane.NO_OPTION) {
                JOptionPane.getRootFrame().dispose(); //If NO is chosen, dispose dialog box
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    private void addMouseListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
