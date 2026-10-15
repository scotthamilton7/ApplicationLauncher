package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.info.AppDetails;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Sidebar extends JPanel {

    AppWindow window;

    int buttonImageWidht = 16;
    int buttonImageHeight = 16;

    Category[] categories;

    public Sidebar(AppWindow window, Category[] categories) {
        // Save parent window and categories
        this.window = window;
        this.categories = categories;

        // Create sidebar
        setBackground(Colors.BACKGROUND_TERTIARY);
        setPreferredSize(new Dimension(220, 0));
        setLayout(new BorderLayout());

        // Add contents to sidebar
        createSidebarTitle();
        addCategories();
        addVersionLabel();
    }

    private void createSidebarTitle() {
        // Logo and application name
        JLabel logo = new JLabel(AppDetails.SIDEBAR_TITLE);
        logo.setFont(logo.getFont().deriveFont(Font.BOLD, 18f));
        logo.setForeground(Colors.TEXT_PRIMARY);
        logo.setBorder(new EmptyBorder(25, 10, 25, 10));
        add(logo, BorderLayout.NORTH);
    }

    private void addCategories() {
        // Create JPanel to contain sidebar buttons
        JPanel navigation = new JPanel();
        navigation.setOpaque(false);
        navigation.setLayout(new BoxLayout(navigation, BoxLayout.Y_AXIS));
        navigation.setBorder(new EmptyBorder(10, 12, 10, 12));

        // Add categories title to sidebar
        JLabel categoriesLabel = new JLabel("Categories");
        categoriesLabel.setForeground(Colors.TEXT_SECONDARY);
        categoriesLabel.setBorder(new EmptyBorder(10, 10, 8, 10));
        navigation.add(categoriesLabel);

        // TEMPORARY
        // Add sample categories to sidebar
        for (Category category : categories) {
            SidebarButton btn = new SidebarButton(category.getName(), "/icons/imgCategory.png", buttonImageWidht, buttonImageHeight);
            navigation.add(btn);
            btn.addActionListener(e -> {
                window.setContent(new CategoryPage(category));
            });
        }

        // Create separator between category and settings buttons
        navigation.add(Box.createVerticalStrut(20));

        // Add settings title to sidebar
        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setForeground(Colors.TEXT_SECONDARY);
        settingsLabel.setBorder(new EmptyBorder(10, 10, 8, 10));
        navigation.add(settingsLabel);

        // Create settings and about buttons
        SidebarButton btnSettings = new SidebarButton("   Settings", "/icons/imgSettings.png",
                buttonImageWidht,  buttonImageHeight);
        navigation.add(btnSettings);
        btnSettings.addActionListener(e -> {
            window.setContent(new SettingsPage());
        });
        SidebarButton btnAbout = new SidebarButton("   About", "/icons/imgAbout.png",
                buttonImageWidht, buttonImageHeight);
        navigation.add(btnAbout);
        btnAbout.addActionListener(e -> {
            window.setContent(new AboutPage(window));
        });

        // Create and add scroll pane for navigation JPanel
        SmoothScrollPane scrollPane = new SmoothScrollPane(navigation);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addVersionLabel() {
        // Create and add version info label to sidebar
        JLabel version = new JLabel("  " + AppDetails.APP_VERSION);
        version.setForeground(Colors.TEXT_SECONDARY);
        version.setBorder(new EmptyBorder(15, 10, 15, 10));
        add(version, BorderLayout.SOUTH);
    }

}
