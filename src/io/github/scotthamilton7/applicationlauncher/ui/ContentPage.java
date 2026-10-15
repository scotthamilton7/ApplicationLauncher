package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ContentPage extends JPanel {

    public ContentPage() {
        // Set background color and border layout
        setBackground(Colors.BACKGROUND_SECONDARY);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 12, 10, 12));
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

}
