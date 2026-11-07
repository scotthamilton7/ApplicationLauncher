package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.info.AppDetails;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Subclass of {@link JPanel} for the application's sidebar
 * <p>
 * Displays the application's title, category navigation buttons, and links to the
 * Settings and About pages
 */
public class Sidebar extends JPanel {

    /**
     * Represents the {@link AppWindow} that this sidebar belongs to
     */
    private final AppWindow window;

    /**
     * Pre-defined width of sidebar button images
     */
    private static final int BUTTON_IMAGE_WIDTH = 16;

    /**
     * Pre-defined height of sidebar button images
     */
    private static final int BUTTON_IMAGE_HEIGHT = 16;

    /**
     * The list of categories to create a {@link SidebarButton} for
     */
    private final Category[] categories;

    /**
     * Constructs the application sidebar
     * @param window The {@link AppWindow} to create the sidebar for
     * @param categories The categories to display in the navigation panel
     */
    public Sidebar(AppWindow window, Category[] categories) {
        this.window = window;
        this.categories = categories;

        configure();

        add(createSidebarTitle(), BorderLayout.NORTH);
        add(createNavigation(), BorderLayout.CENTER);
    }

    /**
     * Configures the sidebar's background, preferred size, and layout
     */
    private void configure() {
        setBackground(Colors.BACKGROUND_TERTIARY);
        setPreferredSize(new Dimension(220, 0));
        setLayout(new BorderLayout());
    }

    /**
     * Creates the label displayed at the top of the sidebar.
     * @return the configured {@link TitleLabel}
     */
    private JLabel createSidebarTitle() {
        TitleLabel lblTitle = new TitleLabel(AppDetails.SIDEBAR_TITLE);
        lblTitle.setBorder(new EmptyBorder(25, 10, 25, 10));
        return lblTitle;
    }

    /**
     * Creates the scrollable navigation area containing the category
     * and settings sections.
     * @return A {@link SmoothScrollPane} containing the navigation panel
     */
    private JScrollPane createNavigation() {
        JPanel navigation = createNavigationPanel();

        addCategoriesSection(navigation);
        addSettingsSection(navigation);

        return new SmoothScrollPane(navigation);
    }

    /**
     * Creates and configures the panel used to hold navigation components.
     * @return the configured navigation panel
     */
    private JPanel createNavigationPanel() {
        JPanel navigation = new JPanel();

        navigation.setOpaque(false);
        navigation.setLayout(new BoxLayout(navigation, BoxLayout.Y_AXIS));
        navigation.setBorder(new EmptyBorder(10, 12, 10, 12));

        return navigation;
    }

    /**
     * Adds the category title and a navigation button for each category.
     * Each button navigates to the related category page when clicked.
     * @param navigation The panel that the category buttons have to be added to
     */
    private void addCategoriesSection(JPanel navigation) {
        navigation.add(createSectionLabel("Categories"));

        if (categories.length < 1) {
            navigation.add(new InfoLabel("No categories"));
            navigation.add(Box.createVerticalStrut(20));
            return;
        }

        for (Category category : categories) {
            SidebarButton btn = new SidebarButton(
                    category.getName(),
                    "/icons/imgCategory.png",
                    BUTTON_IMAGE_WIDTH,
                    BUTTON_IMAGE_HEIGHT
            );

            btn.addActionListener(e -> {
                window.setContent(new CategoryPage(category));
            });

            navigation.add(btn);
        }

        navigation.add(Box.createVerticalStrut(20));
    }

    /**
     * Adds navigation buttons for the Settings and About pages.
     * @param navigation The panel that the buttons have to be added to
     */
    private void addSettingsSection(JPanel navigation) {
        navigation.add(createSectionLabel("Settings"));

        SidebarButton btnSettings = new SidebarButton(
                "Settings",
                "/icons/imgSettings.png",
                BUTTON_IMAGE_WIDTH,
                BUTTON_IMAGE_HEIGHT
        );
        btnSettings.addActionListener(e -> {
                window.setContent(new SettingsPage());
        });
        navigation.add(btnSettings);

        SidebarButton btnAbout = new SidebarButton(
                "About",
                "/icons/imgAbout.png",
                BUTTON_IMAGE_WIDTH,
                BUTTON_IMAGE_HEIGHT
        );
        btnAbout.addActionListener(e -> {
            window.setContent(new AboutPage(window));
        });
        navigation.add(btnAbout);
    }

    /**
     * Creates a styled label for a sidebar section heading.
     * @param text The text to be displayed in the label
     * @return The configured section label
     */
    private JLabel createSectionLabel(String text) {
        JLabel sectionLabel = new JLabel(text);
        sectionLabel.setForeground(Colors.TEXT_SECONDARY);
        sectionLabel.setBorder(new EmptyBorder(10, 10, 8, 10));

        return sectionLabel;
    }

}
