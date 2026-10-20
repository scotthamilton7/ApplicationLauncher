package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.structures.App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Subclass of {@link JPanel} displaying a specified application's
 * details, and a launch button.
 */
public class AppCard extends JPanel {

    /**
     * The size of the application icon
     */
    public static final int APP_CARD_IMAGE_SIZE = 48;

    /**
     * The standard/fallback application icon
     */
    public static final String APP_CARD_DEFAULT_IMAGE = "/icons/imgPlay.png";

    /**
     * The application this {@code AppCard} represents
     */
    private final App app;

    /**
     * Constructs an {@link AppCard} for a specified application
     * @param app the application to create the {@link AppCard} for
     */
    public AppCard(App app) {
        this.app = app;

        configureCard();

        add(createLogo());
        add(createTitle());
        add(createDescription());

        add(Box.createVerticalGlue());
        add(createLaunchButton());
    }

    /**
     * Configure the {@link AppCard}'s background, layout, border, alignment,
     * and dimensions
     */
    private void configureCard() {
        setBackground(Colors.BACKGROUND_PRIMARY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 12, 10, 12));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // Round corners and add border
        putClientProperty("FlatLaf.style", "arc: 20; " +
                "border: 10,12,10,12, #d8dde3, 1, 20"
        );

        Dimension cardSize = new Dimension(300, 180);
        setPreferredSize(cardSize);
        setMinimumSize(cardSize);
        setMaximumSize(cardSize);
    }

    /**
     * Create a JLabel with the application's logo
     * @return a {@link JLabel} containing the application's logo
     */
    private JLabel createLogo() {
        return new JLabel(
                new SharpImageIcon(
                        APP_CARD_DEFAULT_IMAGE,
                        APP_CARD_IMAGE_SIZE,
                        APP_CARD_IMAGE_SIZE
                )
        );
    }

    /**
     * Create a title label with the application's name
     * @return the application name label
     */
    private JLabel createTitle() {
        return new TitleLabel(app.getName());
    }

    /**
     * Create a subtitle label with the application's description
     * @return the application description label
     */
    private JLabel createDescription() {
        return new SubTitle(app.getDescription(), new EmptyBorder(0, 10, 8, 10));
    }

    /**
     * Create a {@link JButton} which launches the application
     * @return the application launch button
     */
    private JButton createLaunchButton() {
        JButton btnLaunch = new JButton("Launch");

        // Ensure BoxLayout stretches the button horizontally
        btnLaunch.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnLaunch.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        btnLaunch.setPreferredSize(new Dimension(Integer.MAX_VALUE, 32));

        // Center text and set cursor
        btnLaunch.setHorizontalAlignment(SwingConstants.CENTER);
        btnLaunch.setFocusPainted(false);
        btnLaunch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // FlatLaf styling: rounded corners, outline border, and custom padding
        btnLaunch.putClientProperty("FlatLaf.style", "arc: 12; " +
                "borderWidth: 1; " +
                "borderColor: #d8dde3; " +
                "background: #ffffff; " +
                "hoverBackground: #f0f2f5; " +
                "margin: 4,8,4,8"
        );

        return btnLaunch;
    }

}
