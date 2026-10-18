package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Subclass of {@link InfoLabel} for displaying primary titles
 */
public class TitleLabel extends InfoLabel {

    /**
     * Constructs a new {@link TitleLabel} with specified text
     * @param text the text to be displayed by the label
     */
    public TitleLabel(String text) {
        super(text);

        configureStyle();
    }

    /**
     * Configures the {@link TitleLabel}'s font, forecolor, and alignment
     */
    private void configureStyle() {
        setFont(getFont().deriveFont(Font.BOLD, 18f));
        setForeground(Colors.TEXT_PRIMARY);

        setAlignmentX(Component.LEFT_ALIGNMENT);
        setHorizontalAlignment(SwingConstants.LEFT);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, getPreferredSize().height));
    }

}
