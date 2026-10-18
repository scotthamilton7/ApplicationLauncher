package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Subclass of {@link JPanel} for creating visible sections within a {@link CategoryPage}
 */
public class InfoCard extends JPanel {

    /**
     * Constructs a new {@link InfoCard} creating a visible section to be used in a {@link CategoryPage}
     */
    public InfoCard() {
        configure();
    }

    /**
     * Configure the {@link InfoCard}'s background, layout, border, alignment, and FlatLaf styling
     */
    private void configure() {
        setBackground(Colors.BACKGROUND_PRIMARY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 12, 10, 12));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // FlatLaf styling for border color and radius
        putClientProperty("FlatLaf.style", "arc: 20; " +
                "border: 10,12,10,12, #d8dde3, 1, 20"
        );
    }

}
