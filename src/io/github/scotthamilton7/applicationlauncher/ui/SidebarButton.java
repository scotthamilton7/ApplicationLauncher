package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SidebarButton extends JButton {

    public SidebarButton(String text) {
        // Set button text
        super(text);

        // Set attributes
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(10, 12, 10, 12));
        setFocusPainted(false);

        // Set style
        setForeground(Colors.TEXT_PRIMARY);
        setBackground(Colors.BACKGROUND_TERTIARY);
    }

    public SidebarButton(String text, String imagePath, int imageWidth, int imageHeight) {
        // Create standard button before adding icon
        this(text);

        // Set icon from provided path
        SharpImageIcon icon = new SharpImageIcon(imagePath, imageWidth, imageHeight);
        setIcon(icon);
    }

}
