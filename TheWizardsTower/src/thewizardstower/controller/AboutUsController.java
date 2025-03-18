/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3aa3_tau_alcayde.tolentino.gui;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import q3aa3_tau_alcayde.tolentino.files.*;
//import q3aa3_tau_alcayde.tolentino.resources.*;
//import q3aa3_tau_alcayde.tolentino.test.*;

/**
 *
 * @author janineyrahtolentino
 */
public class AboutUsController implements MouseListener {
    private JFrame aboutUs;
    private JButton back;
    
    public AboutUsController(JFrame aboutUs, JButton back) {
        this.aboutUs = aboutUs;
        this.back = back;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            JFrame mainMenuScreen = new MainMenu();
            aboutUs.dispose();
            mainMenuScreen.setVisible(true);    
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
