/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thewizardstower;


import thewizardstower.controller.GameScreenSettingsController;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Itzle Alcayde
 */
public class GameScreenSettings extends JFrame {
    private JPanel titlePanel, sliderPanel, buttonPanel;
    private JLabel title, sounds, volumeTitle, soundFXTitle;
    private JSlider volume, soundFX;
    private JButton save, back;
    private GameScreenSettingsController controller;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Image titleimg;

    public GameScreenSettings() {
        /* Setting main JFrame */
        super("In-Game Settings");
        this.setSize(700, 400);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        /* Setting NamePanel */
        this.titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        
        /* Setting slider panel */
        this.sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        sliderPanel.setPreferredSize(new Dimension(600, 150));
        
        /* Setting button panel */
        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension(800, 100));
        
        /* Setting title label */
        title = new JLabel();
        try { //Placing settings font logo in button
            titleimg = ImageIO.read(getClass().getResourceAsStream("/assets/imgs/Settings.png")).getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        title.setIcon(new ImageIcon(titleimg));
        titlePanel.add(title, BorderLayout.WEST);
        
        /* Setting LABELS */
        
        /* Setting slider label and sliders */
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        sounds = new JLabel("Sounds", SwingConstants.CENTER);
        sounds.setForeground(Color.black);
        sounds.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        sounds.setPreferredSize(new Dimension(300, 30));
        sliderPanel.add(sounds, gbc);
        
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        volume = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        volume.setFont(new Font("Serif", Font.PLAIN, 10));
        volume.setPreferredSize(new Dimension(200, 50));
        //setting ticks
        volume.setMajorTickSpacing(10);
        volume.setMinorTickSpacing(1);
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        sliderPanel.add(volume, gbc);

        gbc.gridy = 1;
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        soundFX = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        soundFX.setFont(new Font("Serif", Font.PLAIN, 10));
        soundFX.setPreferredSize(new Dimension(200, 50));
        //setting ticks
        soundFX.setMajorTickSpacing(10);
        soundFX.setMinorTickSpacing(1);
        soundFX.setPaintTicks(true);
        soundFX.setPaintLabels(true);
        sliderPanel.add(soundFX, gbc);
        
        /* Setting slider labels */
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        volumeTitle = new JLabel("Volume", SwingConstants.CENTER);
        volumeTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        sliderPanel.add(volumeTitle, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.EAST;
        soundFXTitle = new JLabel("SoundFX", SwingConstants.CENTER);
        soundFXTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        sliderPanel.add(soundFXTitle, gbc);

        /* Setting back and save buttons */
        save = new JButton("Save");
        save.setFont(new Font("Monospaced", save.getFont().getStyle(), save.getFont().getSize()));
        save.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(save);
 
        back = new JButton("Back");
        back.setFont(new Font("Monospaced", back.getFont().getStyle(), back.getFont().getSize()));
        back.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(back);        

        /* Adding panels into frame */
        this.getContentPane().add(titlePanel);
        this.getContentPane().add(sliderPanel);
        this.getContentPane().add(buttonPanel);

        /* Adding controller */
        controller = new GameScreenSettingsController(this, volume, soundFX, save, back);
        volume.addMouseListener(controller);
        soundFX.addMouseListener(controller);
        save.addMouseListener(controller);
        back.addMouseListener(controller);
        
        this.setVisible(true);
    }
}