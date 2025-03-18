//Game Menu Screen Maker
package q3aa3_tau_alcayde.tolentino.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class MainGameplay extends JFrame {
    private JLayeredPane gamePanel, gameBackgroundPanel, gameAssetsPanel;
    private JPanel eastPanel, statusPanel, inventoryPanel, settingsPanel;
    private JLabel healthBar;
    private JButton settingsButton;
    
    public MainGameplay() {
        /* Setting main JFrame */
        super("Gameplay Screen");
        this.setSize(1080, 720);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Setting gamePanel */
        this.gamePanel = new JLayeredPane();
        gamePanel.setPreferredSize(new Dimension(800, 720));
        gamePanel.setBorder(new LineBorder(Color.BLACK, 3));
        
        /* Setting gameBackgroundPanel */
        this.gameBackgroundPanel = new JLayeredPane();
        gameBackgroundPanel.setBounds(0, 0, 800, 720);
        gameBackgroundPanel.setBorder(new LineBorder(Color.GREEN, 2));
        
        /* Setting gameAssetsPanel */
        this.gameAssetsPanel = new JLayeredPane();
        gameAssetsPanel.setBounds(0, 0, 800, 720);
        gameAssetsPanel.setBorder(new LineBorder(Color.RED, 2));
        
        /* Adding eastPanel */
        this.eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(280, 720)); // Fixed width for right-side UI
        eastPanel.setLayout(new BorderLayout());
        
        /* statusPanel + health bar */
        this.statusPanel = new JPanel();
        statusPanel.setBorder(new LineBorder(Color.BLACK, 3));
        statusPanel.setPreferredSize(new Dimension(280, 100));
        statusPanel.setLayout(new BorderLayout());
        
        this.healthBar = new JLabel("Health Bar");
        healthBar.setOpaque(true);
        healthBar.setBackground(Color.GREEN);
        healthBar.setPreferredSize(new Dimension(200, 30));
        statusPanel.add(healthBar, BorderLayout.NORTH);
        
        /* Adding inventoryPanel */
        this.inventoryPanel = new JPanel();
        inventoryPanel.setBorder(new LineBorder(Color.BLACK, 3));
        inventoryPanel.setLayout(new GridLayout(6, 3, 5, 5));
        for (int i = 0; i < 18; i++) {
            JLabel slot = new JLabel("Slot " + (i + 1), SwingConstants.CENTER);
            slot.setBorder(new LineBorder(Color.DARK_GRAY, 1));
            inventoryPanel.add(slot);
        }
        
        /* Adding settingsPanel + settingsButton */
        this.settingsPanel = new JPanel();
        settingsPanel.setBorder(new LineBorder(Color.BLACK, 3));
        settingsPanel.setPreferredSize(new Dimension(280, 60));
        settingsPanel.setLayout(new BorderLayout());
        
        this.settingsButton = new JButton("Settings");
        settingsPanel.add(settingsButton, BorderLayout.EAST);
        
        /* Adding everything onto screen */
        
        eastPanel.add(statusPanel, BorderLayout.NORTH);
        eastPanel.add(inventoryPanel, BorderLayout.CENTER);
        eastPanel.add(settingsPanel, BorderLayout.SOUTH);
        
        this.getContentPane().add(gamePanel, BorderLayout.CENTER);
        this.getContentPane().add(eastPanel, BorderLayout.EAST);
        this.pack();

        this.setVisible(true);

    }
    
}