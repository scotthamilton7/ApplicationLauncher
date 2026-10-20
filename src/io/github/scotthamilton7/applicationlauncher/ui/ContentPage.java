package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Subclass of {@link JPanel} for displaying content within the content panel
 * in the main {@link AppWindow}
 */
public class ContentPage extends JPanel {

    /**
     * Constructs and configures a new {@link ContentPage}
     */
    public ContentPage() {
        configure();
    }

    /**
     * Configures the {@link ContentPage}'s background, layout, border, and alignment
     */
    private void configure() {
        setBackground(Colors.BACKGROUND_SECONDARY);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 12, 10, 12));
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

}
