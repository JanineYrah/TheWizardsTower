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
        setTitle("Game Instructions");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

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
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame mainMenuScreen = new MainMenu();
                dispose();
                mainMenuScreen.setVisible(true);  
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
        label.setFont(new Font("Arial", isBold ? Font.BOLD : Font.PLAIN, isBold ? 18 : 14));
        return label;
    }
}
