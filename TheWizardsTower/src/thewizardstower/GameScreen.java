/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

import thewizardstower.controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.border.LineBorder;


/**
 *
 * @author Itzle Alcayde
 */
public class GameScreen extends JFrame {
    private JFrame application;
    private PlayingScreen actualGamePanel;
    private JLayeredPane  gamePanel, gameBackgroundPanel, gameAssetsPanel;
    private JPanel eastPanel, statusPanel, inventoryPanel, settingsPanel;
    private JLabel healthBar, slot;
    private JButton settingsButton;
    
    public GameScreen(){
        this.application = new JFrame();
        application.setTitle("The Wizard's Tower");
        application.setSize(1080, 720);
        application.setLayout(new BorderLayout());
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setResizable(false);
        
       
        this.gamePanel = new JLayeredPane();
        gamePanel.setPreferredSize(new Dimension(800, 720));
        gamePanel.setBorder(new LineBorder(Color.BLACK, 3));

        
        this.gameBackgroundPanel = new JLayeredPane(); // add in playingscreen?
        gameBackgroundPanel.setBounds(0, 0, 800, 720);

        
        this.gameAssetsPanel = new JLayeredPane(); // add in playingscreen?
        gameAssetsPanel.setBounds(0, 0, 800, 720);

        this.actualGamePanel = new PlayingScreen();
        actualGamePanel.startGameThread();
        
        gameBackgroundPanel.add(actualGamePanel);
        gamePanel.add(gameBackgroundPanel, Integer.valueOf(0));
        gamePanel.add(gameAssetsPanel, Integer.valueOf(1));

        
        this.eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(280, 720)); 
        eastPanel.setLayout(new BorderLayout());

        
        this.statusPanel = new JPanel();
        statusPanel.setBorder(new LineBorder(Color.BLACK, 3));
        statusPanel.setPreferredSize(new Dimension(280, 100));
        statusPanel.setLayout(new BorderLayout());

        this.healthBar = new JLabel("Health Bar");
        healthBar.setOpaque(true);
        healthBar.setBackground(Color.GREEN);
        healthBar.setPreferredSize(new Dimension(200, 30));
        statusPanel.add(healthBar, BorderLayout.NORTH);

        
        this.inventoryPanel = new JPanel();
        inventoryPanel.setBorder(new LineBorder(Color.BLACK, 3));
        inventoryPanel.setLayout(new GridLayout(6, 3, 5, 5));

        HashMap<JLabel, InvDetails> openDetailsWindows = new HashMap<>();

        for (int i = 0; i < 18; i++) {
            JLabel slot = new JLabel("Slot " + (i + 1), SwingConstants.CENTER);
            slot.setBorder(new LineBorder(Color.DARK_GRAY, 1));
            slot.setOpaque(true);
            slot.setBackground(Color.LIGHT_GRAY);

            String itemName = "Item " + (i + 1);
            String itemDetail = "Details for Item " + (i + 1);

            slot.addMouseListener(new MouseAdapter() {
                private boolean selected = false;
                
                @Override
                public void mouseEntered(MouseEvent evt) {
                    if (!selected) {
                        slot.setBorder(new LineBorder(Color.ORANGE, 1));
                        slot.setBackground(Color.YELLOW);
                    }
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    if (!selected) {
                        slot.setBorder(new LineBorder(Color.DARK_GRAY, 1));
                        slot.setBackground(Color.LIGHT_GRAY);
                    }
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) { // Double-click to open/close popup
                        if (openDetailsWindows.containsKey(slot)) {
                            openDetailsWindows.get(slot).dispose();
                            openDetailsWindows.remove(slot);
                        } else {
                            InvDetails detailsWindow = new InvDetails(itemName, itemDetail);
                            detailsWindow.setLocationRelativeTo(slot);
                            detailsWindow.setVisible(true);
                            openDetailsWindows.put(slot, detailsWindow);
                        }
                    } else {
                        selected = !selected;
                        slot.setBackground(selected ? Color.ORANGE : Color.LIGHT_GRAY);
                    }
                }
            });

            inventoryPanel.add(slot);
        }
        
        this.settingsPanel = new JPanel();
        settingsPanel.setBorder(new LineBorder(Color.BLACK, 3));
        settingsPanel.setPreferredSize(new Dimension(280, 60));
        settingsPanel.setLayout(new BorderLayout());

        this.settingsButton = new JButton("Settings");
        settingsPanel.add(settingsButton, BorderLayout.EAST);

        
        eastPanel.add(statusPanel, BorderLayout.NORTH);
        eastPanel.add(inventoryPanel, BorderLayout.CENTER);
        eastPanel.add(settingsPanel, BorderLayout.SOUTH);

        
        application.add(actualGamePanel, BorderLayout.CENTER);
        application.add(eastPanel, BorderLayout.EAST);

        application.setVisible(true);
        
    }
}
