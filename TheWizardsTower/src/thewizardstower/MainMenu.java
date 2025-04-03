//Game Screen Maker
package thewizardstower;

import thewizardstower.controller.MainMenuController;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainMenu extends JFrame {
    private JLabel gameTitle, background;
    private JButton newGameButton, continueGameButton, instructionsButton, settingsButton, aboutUsButton, quitButton;
    private JPanel backgroundPanel, titlePanel, menuPanel;
    private MainMenuController controller;
    private ImageIcon backgroundImage; //use testImage for testing
    private GridBagConstraints gbc = new GridBagConstraints();
    private Image titleImg;

    public MainMenu() {
        /* Setting main JFrame */
        super("The Wizard's Tower Main Menu");
        this.setSize(1080, 720);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        /* Setting backgroundPanel */
        this.backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setPreferredSize(new Dimension(1080, 720));
        backgroundPanel.setBackground(Color.BLACK);

        /* Setting titlePanel */
        this.titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(100, 100));
        titlePanel.setBounds(100, 100, 280, 300);
        titlePanel.setBackground(Color.BLACK);

        /* Setting menuPanel */
        this.menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setPreferredSize(new Dimension(280, 300));
        menuPanel.setBounds(100, 100, 200, 300);
        menuPanel.setBackground(Color.BLACK);

        /* Adding gameTitle */
        gameTitle = new JLabel("", SwingConstants.CENTER);
        try { //Placing game title font logo in button
            titleImg = ImageIO.read(getClass().getResourceAsStream("/assets/imgs/Logo.png")).getScaledInstance(1000, 600, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        gameTitle.setIcon(new ImageIcon(titleImg));
        gameTitle.setPreferredSize(new Dimension(100, 100));
        
        /* Setting the Buttons */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        newGameButton = new JButton("New Game"); //New Game
        newGameButton.setFont(new Font("Monospaced", newGameButton.getFont().getStyle(), newGameButton.getFont().getSize()));
        newGameButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(newGameButton, gbc); //Adding to menuPanel

        gbc.gridy = 1;
        continueGameButton = new JButton("Continue Game"); //Continue Game
        continueGameButton.setFont(new Font("Monospaced", continueGameButton.getFont().getStyle(), continueGameButton.getFont().getSize()));
        continueGameButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(continueGameButton, gbc); //Adding to menuPanel

        gbc.gridy = 2;
        instructionsButton = new JButton("How to Play"); //Tutorial
        instructionsButton.setFont(new Font("Monospaced", instructionsButton.getFont().getStyle(), instructionsButton.getFont().getSize()));
        instructionsButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(instructionsButton, gbc); //Adding to menuPanel

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // One column
        gbc.anchor = GridBagConstraints.WEST; // Places button to left
        settingsButton = new JButton("Settings"); //Settings
        settingsButton.setFont(new Font("Monospaced", settingsButton.getFont().getStyle(), settingsButton.getFont().getSize()));
        settingsButton.setPreferredSize(new Dimension(100, 40));
        menuPanel.add(settingsButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; //Places button to right
        aboutUsButton = new JButton("About Us"); //About Us
        aboutUsButton.setFont(new Font("Monospaced", aboutUsButton.getFont().getStyle(), aboutUsButton.getFont().getSize()));
        aboutUsButton.setPreferredSize(new Dimension(100, 40));
        menuPanel.add(aboutUsButton, gbc);
        
        gbc.gridy = 4;
        quitButton = new JButton("Quit"); //Quit
        quitButton.setFont(new Font("Monospaced", quitButton.getFont().getStyle(), quitButton.getFont().getSize()));
        quitButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(quitButton, gbc);
        
        /* Adding background to background panel */
        
        background = new JLabel();
        background.setIcon(backgroundImage);

        /* Adding components to panels */
        titlePanel.add(gameTitle);
        backgroundPanel.add(titlePanel);
        backgroundPanel.add(menuPanel);
        backgroundPanel.add(background);

        /* Adding panels into frame */
        this.getContentPane().add(backgroundPanel);
        this.getContentPane().add(titlePanel, BorderLayout.CENTER);
        this.getContentPane().add(menuPanel, BorderLayout.AFTER_LAST_LINE);

        /* Adding controller to components */
        controller = new MainMenuController(this, newGameButton, continueGameButton, instructionsButton,
                                            settingsButton, aboutUsButton, quitButton);
        
        newGameButton.addMouseListener(controller);
        continueGameButton.addMouseListener(controller);
        instructionsButton.addMouseListener(controller);
        settingsButton.addMouseListener(controller);
        aboutUsButton.addMouseListener(controller);
        quitButton.addMouseListener(controller);
        
        this.setVisible(true);

    }
}