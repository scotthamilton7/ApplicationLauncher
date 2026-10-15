package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.layout.WrapLayout;
import io.github.scotthamilton7.applicationlauncher.structures.App;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import java.awt.*;

public class CategoryPage extends ContentPage {

    Category category;

    public CategoryPage(Category category) {
        // Save category
        this.category = category;

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create page title
        TitleLabel title = new TitleLabel(category.getName());
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        title.setMaximumSize(new Dimension(Integer.MAX_VALUE, title.getPreferredSize().height));
        add(title);

        // Add spacing between title and info cards
        add(Box.createVerticalStrut(20));

        // Create info cards
        loadAppList();
    }

    private void loadAppList() {
        JPanel appPanel = new JPanel(new WrapLayout(FlowLayout.LEFT, 12, 12));
        appPanel.setOpaque(false);
        appPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (App app : category.getApps()) {
            AppCard appCard = new AppCard(app);
            appPanel.add(appCard);
        }

        // Create scroll pane for apps
        SmoothScrollPane scrollPane = new SmoothScrollPane(appPanel);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(scrollPane);
    }

}
