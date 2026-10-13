package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {

    public AppWindow() {
        // Create application window
        setTitle("");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Colors.BACKGROUND_SECONDARY);

        // Add sidebar to window
        add(new Sidebar(), BorderLayout.WEST);

        // Show application window
        setVisible(true);
    }

}
