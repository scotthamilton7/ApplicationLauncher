package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.layout.WrapLayout;
import io.github.scotthamilton7.applicationlauncher.structures.App;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import java.awt.*;

/**
 * Subclass of {@link ContentPage} to display applications in a given category
 */
public class CategoryPage extends ContentPage {

    /**
     * The category of applications being displayed
     */
    private final Category category;

    /**
     * Constructs a {@link CategoryPage} displaying applications within the specified category
     * @param category the specified category to display
     */
    public CategoryPage(Category category) {
        this.category = category;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new TitleLabel(category.getName()));
        add(Box.createVerticalStrut(20));
        add(createScrollingAppPane());
    }

    /**
     * Creates a {@link SmoothScrollPane} containing a {@link JPanel} with an {@link AppCard} for every
     * application within this category
     * @return the created {@link SmoothScrollPane}
     */
    private JScrollPane createScrollingAppPane() {
        JPanel appPanel = new JPanel(new WrapLayout(FlowLayout.LEFT, 12, 12));
        appPanel.setOpaque(false);
        appPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (App app : category.getApps()) {
            appPanel.add(new AppCard(app));
        }

        SmoothScrollPane scrollPane = new SmoothScrollPane(appPanel);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        return scrollPane;
    }

}
