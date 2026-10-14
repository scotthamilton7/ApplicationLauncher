package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.border.EmptyBorder;

public class SubTitle extends InfoLabel {

    public SubTitle(String text) {
        // Pass text to InfoLabel constructor
        super(text);

        // Set styling
        setForeground(Colors.TEXT_SECONDARY);
        setBorder(new EmptyBorder(10, 10, 8, 10));
    }

}
