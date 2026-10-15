package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.structures.App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AppCard extends JPanel {

    App app;

    public AppCard(App app) {
        // Save app
        this.app = app;

        // Set background color and border layout
        setBackground(Colors.BACKGROUND_PRIMARY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 12, 10, 12));

        // Align content to left
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // Round corners and add border
        putClientProperty("FlatLaf.style", "arc: 20; " +
                "border: 10,12,10,12, #d8dde3, 1, 20"
        );

        // Load app details
        addLogo();
        addTitle();
        addDescription();
        addLaunchButton();

        // Set size
        Dimension cardSize = new Dimension(300, 180);
        setPreferredSize(cardSize);
        setMinimumSize(cardSize);
        setMaximumSize(cardSize);
    }

    private void addLogo() {
        // Set logo parameters
        String imagePath = "/icons/imgPlay.png";
        int imageWidth = 48;
        int imageHeight = 48;

        // Create scaled icon
        SharpImageIcon icon = new SharpImageIcon(imagePath, imageWidth, imageHeight);

        // Create logo
        JLabel imageLabel = new JLabel(icon);
        add(imageLabel);
    }

    private void addTitle() {
        //
        TitleLabel lblTitle = new TitleLabel(app.getName());
        add(lblTitle);
    }

    private void addDescription() {
        //
        SubTitle lblDescription = new SubTitle(app.getDescription());
        lblDescription.setBorder(new EmptyBorder(0, 10, 8, 10));
        add(lblDescription);
    }

    private void addLaunchButton() {
        // Push the button to the bottom of the card
        add(Box.createVerticalGlue());

        JButton btnLaunch = new JButton("Launch");

        // Ensure BoxLayout stretches the button horizontally
        btnLaunch.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnLaunch.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        btnLaunch.setPreferredSize(new Dimension(Integer.MAX_VALUE, 32));

        // Center text and set cursor
        btnLaunch.setHorizontalAlignment(SwingConstants.CENTER);
        btnLaunch.setFocusPainted(false);
        btnLaunch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // FlatLaf styling: rounded corners, outline border, and custom padding
        btnLaunch.putClientProperty("FlatLaf.style", "arc: 12; " +
                "borderWidth: 1; " +
                "borderColor: #d8dde3; " +
                "background: #ffffff; " +
                "hoverBackground: #f0f2f5; " +
                "margin: 4,8,4,8"
        );

        add(btnLaunch);
    }

}
