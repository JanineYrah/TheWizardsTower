/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

import thewizardstower.controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    private JButton settingsButton, instructionsButton;
    private Image settingsImg, instructionsImg;
    
    public GameScreen(){
        this.application = new JFrame();
        application.setTitle("The Wizard's Tower");
        application.setSize(1080, 720);
        application.setLayout(new BorderLayout());
        application.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        application.setResizable(false);
        
       /* Setting GAME PANEL */
        this.gamePanel = new JLayeredPane();
        gamePanel.setPreferredSize(new Dimension(800, 720));
        gamePanel.setBorder(new LineBorder(Color.BLACK, 3));

        /* Setting game BACKGROUND panel */
        this.gameBackgroundPanel = new JLayeredPane(); // add in playingscreen?
        gameBackgroundPanel.setBounds(0, 0, 800, 720);

        /* Setting game ASSETS panel */
        this.gameAssetsPanel = new JLayeredPane(); // add in playingscreen?
        gameAssetsPanel.setBounds(0, 0, 800, 720);

        /* Seting ACTUAL GAME PANEL */
        this.actualGamePanel = new PlayingScreen();
        actualGamePanel.startGameThread();
        
        gameBackgroundPanel.add(actualGamePanel); //Adding actual game panel to background panel
        gamePanel.add(gameBackgroundPanel, Integer.valueOf(0));
        gamePanel.add(gameAssetsPanel, Integer.valueOf(1));

        this.eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(280, 720)); 
        eastPanel.setLayout(new BorderLayout());

        /* Setting STATUS PANEL (which holds player stats, like hp) */
        this.statusPanel = new JPanel();
        statusPanel.setBorder(new LineBorder(Color.BLACK, 3));
        statusPanel.setPreferredSize(new Dimension(280, 100));
        statusPanel.setLayout(new BorderLayout());

        /* Making Health Bar */
        this.healthBar = new JLabel("Health Bar");
        healthBar.setOpaque(true);
        healthBar.setBackground(Color.GREEN);
        healthBar.setFont(new Font("Monospaced", Font.PLAIN, 15));
        healthBar.setPreferredSize(new Dimension(200, 30));
        statusPanel.add(healthBar, BorderLayout.NORTH);

        /* Setting INVENTORY PANEL */
        this.inventoryPanel = new JPanel();
        inventoryPanel.setBorder(new LineBorder(Color.BLACK, 3));
        inventoryPanel.setLayout(new GridLayout(6, 3, 5, 5));

        /* Making INVENTORY */
        HashMap<JLabel, InvDetails> openDetailsWindows = new HashMap<>();

        for (int i = 0; i < 18; i++) {
            JLabel slot = new JLabel("Slot " + (i + 1), SwingConstants.CENTER);
            slot.setBorder(new LineBorder(Color.DARK_GRAY, 1));
            slot.setOpaque(true);
            slot.setBackground(Color.LIGHT_GRAY);
            slot.setFont(new Font("Monospaced", Font.PLAIN, 15));

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
        
        /* Setting SETTINGS Panel */
        this.settingsPanel = new JPanel();
        settingsPanel.setBorder(new LineBorder(Color.BLACK, 3));
        settingsPanel.setPreferredSize(new Dimension(280, 60));
        settingsPanel.setLayout(new BorderLayout());

        /* Making Settings button */
        this.settingsButton = new JButton();
        try { //Placing settings font logo in button
            settingsImg = ImageIO.read(getClass().getResourceAsStream("/assets/imgs/SettingsOutline.png")).getScaledInstance(90, 50,  java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        settingsButton.setIcon(new ImageIcon(settingsImg));
        settingsPanel.add(settingsButton, BorderLayout.EAST);

        /* Making instructions button */
        this.instructionsButton = new JButton();
        try { //Placing settings font logo in button
            instructionsImg = ImageIO.read(getClass().getResourceAsStream("/assets/imgs/InstructionsOutline.png")).getScaledInstance(100, 45,  java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        instructionsButton.setIcon(new ImageIcon(instructionsImg));
        settingsPanel.add(instructionsButton, BorderLayout.WEST);

        eastPanel.add(statusPanel, BorderLayout.NORTH);
        eastPanel.add(inventoryPanel, BorderLayout.CENTER);
        eastPanel.add(settingsPanel, BorderLayout.SOUTH);

        application.add(actualGamePanel, BorderLayout.CENTER);
        application.add(eastPanel, BorderLayout.EAST);

        application.setVisible(true);
        
    }
}