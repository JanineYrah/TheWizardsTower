/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thewizardstower;

import javax.swing.*;
import java.awt.*;
import thewizardstower.controller;

/**
 *
 * @author janineyrahtolentino
 */
public class AboutUs extends JFrame {
    private JPanel namePanel, contentPanel;
    private JLabel aboutUsName, gameName, gameFeature, creatorFeature, aboutGame, aboutCreator;
    private JButton back;
    private String aboutGameText, aboutCreatorText;
    private AboutUsController controller;
    private GridBagConstraints gbc = new GridBagConstraints();
    
    public AboutUs() {
        /* Setting main JFrame */
        super("About Us");
        this.setSize(1080, 720);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Setting NamePanel */
        this.namePanel = new JPanel();
        namePanel.setLayout(new GridBagLayout());
        namePanel.setPreferredSize(new Dimension(1080, 100));
        
        /* Setting contentPanel */
        this.contentPanel = new JPanel();
        contentPanel.setLayout(new SpringLayout());
        contentPanel.setPreferredSize(new Dimension(100, 800));

        /* Setting components of NAME panel */
        gbc.anchor = GridBagConstraints.WEST; //sets label to left
        aboutUsName = new JLabel("About Us"); //About us label
        aboutUsName.setForeground(Color.black);
        aboutUsName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
        aboutUsName.setPreferredSize(new Dimension(300, 40));
        namePanel.add(aboutUsName, gbc); //Adding to name panel
        
        gbc.anchor = GridBagConstraints.CENTER; //sets label to center
        gameName = new JLabel("The Wizard's Tower"); //Game name label
        gameName.setForeground(Color.blue);
        gameName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
        gameName.setPreferredSize(new Dimension(500, 40));
        namePanel.add(gameName, gbc); //Adding to name panel
        
        /* Setting "back" button */
        gbc.anchor = GridBagConstraints.EAST; //sets button to east
        back = new JButton("Back"); //Game name label
        back.setPreferredSize(new Dimension(50, 50));
        namePanel.add(back, gbc); //Adding to name panel
        
        /* Setting components of CONTENT panel */
        
        
        
        
        
        
        
        
        /* Adding panels into frame */
        this.getContentPane().add(namePanel, BorderLayout.NORTH); //Adding to JFrame
        this.getContentPane().add(contentPanel, BorderLayout.CENTER); //Adding to JFrame

        /* Adding controller */
        controller = new AboutUsController(this, back);
        back.addMouseListener(controller);
        
        this.setVisible(true);

    }
    
}
