package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.structures.App;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {

    JPanel pnlContentContainer;

    Category[] categories;

    public AppWindow() {
        // Create application window
        setTitle("");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Colors.BACKGROUND_SECONDARY);

        // TEMPORARY
        // Create some categories
        categories = new Category[]{new Category("Cat1"), new Category("Cat2"), new Category("Cat3"), new Category("Cat4")};
        categories[0].addApp(new App("Name", "Description"));

        // Add sidebar to window
        add(new Sidebar(this, categories), BorderLayout.WEST);

        // Add content page container to window
        pnlContentContainer = new JPanel();
        pnlContentContainer.setLayout(new BorderLayout());
        pnlContentContainer.setBackground(Colors.BACKGROUND_SECONDARY);
        add(pnlContentContainer, BorderLayout.CENTER);

        // Show application window
        setVisible(true);
    }

    public void setContent(ContentPage page) {
        // Swap current page for new page
        pnlContentContainer.removeAll();
        pnlContentContainer.add(page, BorderLayout.CENTER);

        // Repaint container panel to show new page
        pnlContentContainer.revalidate();
        pnlContentContainer.repaint();
    }

}
