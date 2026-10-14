package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import java.awt.*;

public class SettingsPage extends ContentPage {

    public SettingsPage() {
        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create page title
        TitleLabel title = new TitleLabel("Settings");
        add(title, BorderLayout.NORTH);

        // Add spacing between title and info cards
        add(Box.createVerticalStrut(20));

        // Create info cards

    }

}
