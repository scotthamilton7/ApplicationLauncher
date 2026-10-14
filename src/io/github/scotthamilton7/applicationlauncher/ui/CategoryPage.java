package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import java.awt.*;

public class CategoryPage extends ContentPage {

    public CategoryPage(Category category) {
        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create page title
        TitleLabel title = new TitleLabel(category.getName());
        add(title, BorderLayout.NORTH);

        // Add spacing between title and info cards
        add(Box.createVerticalStrut(20));

        // Create info cards
    }

}
