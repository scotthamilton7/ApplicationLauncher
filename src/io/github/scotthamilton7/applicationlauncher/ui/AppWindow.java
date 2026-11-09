package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.io.AppConfig;
import io.github.scotthamilton7.applicationlauncher.structures.App;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Subclass of {@link JFrame} to create a window with sidebar and content panel
 */
public class AppWindow extends JFrame {

    /**
     * The {@link JPanel} to display the current {@link ContentPage}
     */
    private JPanel pnlContentContainer;

    /**
     * The categories to be shown in the sidebar
     */
    private List<Category> categories;

    /**
     * Constructs an {@link AppWindow} and adds a sidebar and content panel
     */
    public AppWindow() {
        configureWindow();

        try {
            this.categories = AppConfig.loadCategories();
        } catch (IOException e) {
            System.err.println("Failed to load apps.csv:");
            e.printStackTrace();
        }

        add(createSidebar(), BorderLayout.WEST);
        add(createContentPanel(), BorderLayout.CENTER);
        setContent(new CategoryPage(categories.getFirst()));

        setVisible(true);
    }

    /**
     * Configure the window's title, size, close operation, location, and background
     */
    private void configureWindow() {
        setTitle("");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Colors.BACKGROUND_SECONDARY);
    }

    /**
     * Create a new sidebar
     * @return the new sidebar
     */
    private JPanel createSidebar() {
        return new Sidebar(this, categories.toArray(new Category[0]));
    }

    /**
     * Creates a {@link JPanel} to display the current in view {@link ContentPage}.
     * The layout is set to {@link BorderLayout} and the background is set to {@code BACKGROUND_SECONDARY}
     * @return the new {@link JPanel}
     */
    private JPanel createContentPanel() {
        pnlContentContainer = new JPanel();
        pnlContentContainer.setLayout(new BorderLayout());
        pnlContentContainer.setBackground(Colors.BACKGROUND_SECONDARY);
        return pnlContentContainer;
    }

    /**
     * Replace the page currently in view with a specified {@link ContentPage}
     * @param page the {@link ContentPage} to display
     */
    public void setContent(ContentPage page) {
        pnlContentContainer.removeAll();
        pnlContentContainer.add(page, BorderLayout.CENTER);

        pnlContentContainer.revalidate();
        pnlContentContainer.repaint();
    }

}
