package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InfoCard extends JPanel {

    public InfoCard() {
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
    }

}
