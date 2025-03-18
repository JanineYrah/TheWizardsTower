/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3aa3_tau_alcayde.tolentino.gui;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author janineyrahtolentino
 */
public class MainMenuSettingsController implements MouseListener {
    private JFrame settings;
    private JSlider volume, soundFX;
    private JButton save, back;
    private int confirmChoice;
    
    public MainMenuSettingsController(JFrame settings, JSlider volume, JSlider soundFX, JButton back, JButton save) {
        this.settings = settings;
        this.volume = volume;
        this.soundFX = soundFX;
        this.save = save;
        this.back = back;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            confirmChoice = JOptionPane.showConfirmDialog(settings, "Are you sure you want to quit?",
                                                          "Back?", JOptionPane.YES_NO_OPTION); //confirming
            if (confirmChoice == JOptionPane.YES_OPTION) {
                JFrame mainMenu = new MainMenu();
                settings.dispose();
                mainMenu.setVisible(true);  
            } else if (confirmChoice == JOptionPane.NO_OPTION) {
                JOptionPane.getRootFrame().dispose(); //If NO is chosen, dispose dialog box
            }
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
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
