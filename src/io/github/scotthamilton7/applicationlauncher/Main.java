package io.github.scotthamilton7.applicationlauncher;

import io.github.scotthamilton7.applicationlauncher.ui.AppWindow;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

/**
 * Entry point for the Application Launcher
 * Setups the FlatLaf theme and creates the main window
 */
public class Main {

    /**
     * Initializes FlatLaf and creates application window
     */
    void main() {
        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialise FlatLaf");
            }

            new AppWindow();
        });
    }

}
