//Game Screen Maker
package thewizardstower;

import thewizardstower.controller;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JLabel gameTitle, background;
    private JButton newGameButton, continueGameButton, tutorialButton, settingsButton, aboutUsButton, quitButton;
    private JPanel backgroundPanel, titlePanel, menuPanel;
    private MainMenuController controller;
    private ImageIcon backgroundImage; //use testImage for testing
    private GridBagConstraints gbc = new GridBagConstraints();

    public MainMenu() {
        /* Setting main JFrame */
        super("The Wizard's Tower Main Menu");
        this.setSize(1080, 720);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Setting backgroundPanel */
        this.backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setPreferredSize(new Dimension(1080, 720));

        /* Setting titlePanel */
        this.titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(100, 100));
        titlePanel.setBounds(100, 100, 280, 300);

        /* Setting menuPanel */
        this.menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setPreferredSize(new Dimension(280, 300));
        menuPanel.setBounds(100, 100, 200, 300);

        /* Adding gameTitle */
        gameTitle = new JLabel("The Wizard's Tower", SwingConstants.CENTER);
        gameTitle.setForeground(Color.blue);
        gameTitle.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 80));
        gameTitle.setPreferredSize(new Dimension(100, 100));
        
        /* Setting the Buttons */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        newGameButton = new JButton("New Game"); //New Game
        newGameButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(newGameButton, gbc); //Adding to menuPanel

        gbc.gridy = 1;
        continueGameButton = new JButton("Continue Game"); //Continue Game
        continueGameButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(continueGameButton, gbc); //Adding to menuPanel

        gbc.gridy = 2;
        tutorialButton = new JButton("Tutorial"); //Tutorial
        tutorialButton.setPreferredSize(new Dimension(200, 40));
        menuPanel.add(tutorialButton, gbc); //Adding to menuPanel

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // One column
        gbc.anchor = GridBagConstraints.WEST; // Places button to left
        settingsButton = new JButton("Settings"); //Settings
        settingsButton.setPreferredSize(new Dimension(100, 40));
        menuPanel.add(settingsButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; //Places button to right
        aboutUsButton = new JButton("About Us"); //About Us
        aboutUsButton.setPreferredSize(new Dimension(100, 40));
        menuPanel.add(aboutUsButton, gbc);
        
        gbc.gridy = 4;
        quitButton = new JButton("Quit"); //Quit
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
        controller = new MainMenuController(this, newGameButton, continueGameButton, tutorialButton,
                                            settingsButton, aboutUsButton, quitButton);
        
        newGameButton.addMouseListener(controller);
        continueGameButton.addMouseListener(controller);
        tutorialButton.addMouseListener(controller);
        settingsButton.addMouseListener(controller);
        aboutUsButton.addMouseListener(controller);
        quitButton.addMouseListener(controller);
        
        this.setVisible(true);

    }
}
