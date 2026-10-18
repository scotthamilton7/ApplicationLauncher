package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.border.Border;

/**
 * Subclass of {@link InfoLabel} for displaying subtitles. Displays text in the secondary text color.
 */
public class SubTitle extends InfoLabel {

    /**
     * Constructs a new {@link SubTitle} with specified text and the default border
     * @param text the text to be displayed in the label
     */
    public SubTitle(String text) {
        super(text);

        setForeground(Colors.TEXT_SECONDARY);
    }

    /**
     * Constructs a new {@link SubTitle} with specified text and a custom border
     * @param text the text to be displayed in the label
     * @param customBorder the border to be used by the label
     */
    public SubTitle(String text, Border customBorder) {
        this(text);

        setBorder(customBorder);
    }

}
