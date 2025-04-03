/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thewizardstower.controller;

import java.awt.event.*;
import javax.swing.*;
import thewizardstower.*;

/**
 *
 * @author janineyrahtolentino
 */
public class MainMenuSettingsController implements MouseListener {
    private JFrame settings;
    private JSlider volume, soundFX;
    private JButton save, back;
    private JRadioButton easy, medium, hard;
    private int confirmChoice;
    private boolean saved = true;
    
    public MainMenuSettingsController(JFrame settings, JSlider volume, JSlider soundFX,
            JRadioButton easy, JRadioButton medium, JRadioButton hard, JButton save, JButton back) {
        this.settings = settings;
        this.volume = volume;
        this.soundFX = soundFX;
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
        this.save = save;
        this.back = back;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Personal note: unsure if I can put them all tgt, i'll separate them for now
        if (e.getSource() == easy) { //easy difficulty choice
            //add other functions here
            saved = false; // indicates that a change has been made to the settings
        }
        if (e.getSource() == medium) { //medium difficulty choice
            //add other functions here
            saved = false; // indicates that a change has been made to the settings
        }
        if (e.getSource() == hard) { //hard difficulty choice
            //add other functions here
            saved = false; // indicates that a change has been made to the settings
        }
        if (e.getSource() == back) {
            if (saved == false) {
                confirmChoice = JOptionPane.showConfirmDialog(settings, "You have unsaved changes. Are you sure you want to quit?",
                                                          "Unsaved Changes", JOptionPane.YES_NO_OPTION); //confirming
                if (confirmChoice == JOptionPane.YES_OPTION) {
                    JFrame mainMenu = new MainMenu();
                    settings.dispose();
                    mainMenu.setVisible(true);  
                } else if (confirmChoice == JOptionPane.NO_OPTION) {
                    JOptionPane.getRootFrame().dispose(); //If NO is chosen, dispose dialog box
                }
            } else {
                JFrame mainMenu = new MainMenu();
                settings.dispose();
                mainMenu.setVisible(true);  
            }
            saved = true; // updates value to indicate no pending changes are left
        }
        if (e.getSource() == save) {
            confirmChoice = JOptionPane.showConfirmDialog(settings, "Save changes?",
                                                          "Save?", JOptionPane.YES_NO_OPTION); //confirming
            if (confirmChoice == JOptionPane.YES_OPTION) {
                //methods that make changes
                JFrame mainMenu = new MainMenu();
                settings.dispose();
                mainMenu.setVisible(true);  
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
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == volume) { //volume changer
            //add other functions here
            saved = false; // indicates that a change has been made to the settings
            
        }
        if (e.getSource() == soundFX) { //soundFX changer
            //add other functions here
            saved = false; // indicates that a change has been made to the settings
            
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {}
}
