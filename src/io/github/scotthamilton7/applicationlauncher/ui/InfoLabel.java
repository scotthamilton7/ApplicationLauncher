package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Subclass of {@link JLabel} which adds more spacing to the border
 */
public class InfoLabel extends JLabel {

    /**
     * The border to be added to the {@link InfoLabel}
     */
    protected final EmptyBorder defaultBorder = new EmptyBorder(10, 10, 10, 10);

    /**
     * Constructs a new {@link InfoLabel} with no text
     */
    public InfoLabel() {
        setBorder(defaultBorder);
    }

    /**
     * Constructs a new {@link InfoLabel} with specified text
     * @param text the text to be displayed in the label
     */
    public InfoLabel(String text) {
        super(text);

        setBorder(defaultBorder);
    }

}
