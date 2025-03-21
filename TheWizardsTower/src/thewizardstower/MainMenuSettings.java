/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thewizardstower;

import thewizardstower.controller.MainMenuSettingsController;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author janineyrahtolentino
 */
public class MainMenuSettings extends JFrame {
    private JPanel titlePanel, sliderPanel, difficultyPanel, buttonPanel;
    private JLabel title, sounds, volumeTitle, soundFXTitle, difficulty;
    private JSlider volume, soundFX;
    private JButton save, back;
    private JRadioButton easy, medium, hard;
    private MainMenuSettingsController controller;
    private GridBagConstraints gbc = new GridBagConstraints();

    public MainMenuSettings() {
        /* Setting main JFrame */
        super("Settings");
        this.setSize(1080, 720);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        /* Setting NamePanel */
        this.titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(1000, 100));
        
        /* Setting slider panel */
        this.sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());
        sliderPanel.setPreferredSize(new Dimension(1000, 150));
        
        /* Setting difficulty panel */
        this.difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new GridBagLayout());
        difficultyPanel.setPreferredSize(new Dimension(1000, 150));
        
        /* Setting button panel */
        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension(1000, 100));
        
        /* Setting title label */
        title = new JLabel("Settings");
        title.setForeground(Color.blue);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        title.setPreferredSize(new Dimension(1000, 30));
        titlePanel.add(title, BorderLayout.WEST);
        
        /* Setting slider label and sliders */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        sounds = new JLabel("Sounds", SwingConstants.CENTER);
        sounds.setForeground(Color.black);
        sounds.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        sounds.setPreferredSize(new Dimension(600, 30));
        sliderPanel.add(sounds, gbc);
        
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        volume = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        volume.setFont(new Font("Serif", Font.PLAIN, 15));
        volume.setPreferredSize(new Dimension(250, 50));
        //setting ticks
        volume.setMajorTickSpacing(10);
        volume.setMinorTickSpacing(1);
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        sliderPanel.add(volume, gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        soundFX = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        soundFX.setFont(new Font("Serif", Font.PLAIN, 15));
        soundFX.setPreferredSize(new Dimension(250, 50));
        //setting ticks
        soundFX.setMajorTickSpacing(10);
        soundFX.setMinorTickSpacing(1);
        soundFX.setPaintTicks(true);
        soundFX.setPaintLabels(true);
        sliderPanel.add(soundFX, gbc);
        
        /* Setting slider labels */
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        volumeTitle = new JLabel("Volume", SwingConstants.CENTER);
        volumeTitle.setFont(new Font("Serif", Font.PLAIN, 15));
        sliderPanel.add(volumeTitle, gbc);
        
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        soundFXTitle = new JLabel("SoundFX", SwingConstants.CENTER);
        soundFXTitle.setFont(new Font("Serif", Font.PLAIN, 15));
        sliderPanel.add(soundFXTitle, gbc);

        /* Setting difficulty label and difficulty buttons */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        difficulty = new JLabel("Select Level Difficulty", SwingConstants.CENTER);
        difficulty.setForeground(Color.black);
        difficulty.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        difficulty.setPreferredSize(new Dimension(600, 60));
        difficultyPanel.add(difficulty, gbc);
        
       //buttons
        JRadioButton easy = new JRadioButton();
        easy.setText("Easy");
        JRadioButton medium = new JRadioButton();
        medium.setText("Medium");
        JRadioButton hard = new JRadioButton();
        hard.setText("Hard");
        
        //grouping buttons
        ButtonGroup difficulties = new ButtonGroup();
        difficulties.add(easy);
        difficulties.add(medium);
        difficulties.add(hard);
                
        //adding buttons
        difficulties.add(easy);
        difficulties.add(medium);
        difficulties.add(hard);
        
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        easy.setPreferredSize(new Dimension(100, 40));
        difficultyPanel.add(easy, gbc);
        
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        medium.setPreferredSize(new Dimension(100, 40));
        difficultyPanel.add(medium, gbc);
        
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        hard.setPreferredSize(new Dimension(100, 40));
        difficultyPanel.add(hard, gbc);

        /* Setting back and save buttons */
        save = new JButton("Save");
        save.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(save);
 
        back = new JButton("Back");
        back.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(back);

        /* Adding panels into frame */
        this.getContentPane().add(titlePanel);
        this.getContentPane().add(sliderPanel);
        this.getContentPane().add(difficultyPanel);
        this.getContentPane().add(buttonPanel);

        /* Adding controller */
        controller = new MainMenuSettingsController(this, volume, soundFX, easy, medium, hard, save, back);
        volume.addMouseListener(controller);
        soundFX.addMouseListener(controller);
        easy.addMouseListener(controller);
        medium.addMouseListener(controller);
        hard.addMouseListener(controller);
        save.addMouseListener(controller);
        back.addMouseListener(controller);
        
        this.setVisible(true);
    }
}
