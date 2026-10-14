package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InfoLabel extends JLabel {

    public InfoLabel() {
        // Set styling
        setBorder(new EmptyBorder(10, 12, 10, 12));
    }

    public InfoLabel(String text) {
        // Pass text to JLabel constructor
        super(text);

        // Set styling
        setBorder(new EmptyBorder(5, 12, 5, 12));
    }

}
