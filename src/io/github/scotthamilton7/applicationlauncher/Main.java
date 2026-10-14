package io.github.scotthamilton7.applicationlauncher;

import io.github.scotthamilton7.applicationlauncher.ui.AppWindow;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Main {

    void main() {
        // Set FlatLaf before creating any Swing components.
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialise FlatLaf");
            }

            // Create application window
            AppWindow appWindow = new AppWindow();
        });
    }

}
