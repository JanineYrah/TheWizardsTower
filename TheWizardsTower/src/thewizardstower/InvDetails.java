package q3aa3_tau_alcayde.tolentino.gui;


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Itzle Alcayde
 */
public class InvDetails extends JFrame {
    JPanel namePanel, detailsPanel;
    JLabel name, details;

    public InvDetails(String namee, String detail) {
        this.namePanel = new JPanel();
        namePanel.setPreferredSize(new Dimension(250, 125));

        this.name = new JLabel();
        name.setText(namee);
        namePanel.add(name);

        this.detailsPanel = new JPanel();
        this.details = new JLabel();
        details.setText(detail);
        detailsPanel.add(details);

        add(namePanel, BorderLayout.NORTH);
        add(detailsPanel, BorderLayout.CENTER);

        setSize(250, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
