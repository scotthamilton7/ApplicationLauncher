package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Subclass of {@link JButton} styled and configured for use on a {@link Sidebar}
 */
public class SidebarButton extends JButton {

    /**
     * Represents the spacing to be used between the icon and the text
     */
    private static final String ICON_TEXT_SPACING = "  ";

    /**
     * Constructs a text-only {@link SidebarButton} and configures the styling
     * @param text The text to be displayed
     */
    public SidebarButton(String text) {
        super(text);
        configure();
    }

    /**
     * Constructs a {@link SidebarButton} with an icon and configures the styling
     * @param text The text to be displayed
     * @param imagePath The path to the image to be used as the icon
     * @param imageWidth The desired width of the icon
     * @param imageHeight The desired height of the icon
     */
    public SidebarButton(String text, String imagePath, int imageWidth, int imageHeight) {
        this(ICON_TEXT_SPACING + text);
        setIcon(new SharpImageIcon(imagePath, imageWidth, imageHeight));
    }

    /**
     * Configure this {@link SidebarButton}'s colors, sizing, border, and alignment
     */
    private void configure() {
        setForeground(Colors.TEXT_PRIMARY);
        setBackground(Colors.BACKGROUND_TERTIARY);

        setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        setBorder(new EmptyBorder(10, 12, 10, 12));

        setAlignmentX(Component.LEFT_ALIGNMENT);
        setHorizontalAlignment(SwingConstants.LEFT);

        setFocusPainted(false);
    }

}
