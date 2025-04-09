/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thewizardstower;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import thewizardstower.controller.InstructionsController;

/**
 *
 * @author janineyrahtolentino
 */
public class Instructions extends JFrame{
     public Instructions() {
        this.setTitle("The Wizard's Tower Controls");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        panel.add(createLabel("CLICK W A S D keys", true));
        panel.add(createLabel("to go forward, left, down and right", false));

        panel.add(Box.createVerticalStrut(10)); // Spacing

        panel.add(createLabel("HOLD Shift", true));
        panel.add(createLabel("To sprint in the game", false));

        panel.add(Box.createVerticalStrut(10)); // Spacing

        panel.add(createLabel("Left Click on Items", true));
        panel.add(createLabel("to select items", false));

        panel.add(Box.createVerticalStrut(10)); // Spacing

        panel.add(createLabel("Right Click on Items", true));
        panel.add(createLabel("to see the item details", false));

        panel.add(Box.createVerticalStrut(20)); // Spacing

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Monospace", Font.BOLD, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    // Method to create labels with different font styles
    private JLabel createLabel(String text, boolean isBold) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Monospace", isBold ? Font.BOLD : Font.PLAIN, isBold ? 18 : 14));
        label.setForeground(Color.WHITE);
        return label;
    }
}