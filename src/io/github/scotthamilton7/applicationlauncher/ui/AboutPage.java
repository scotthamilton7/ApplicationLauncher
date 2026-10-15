package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.info.AppDetails;

import javax.swing.*;
import java.awt.*;

/**
 * GUI page for application info, attributions, and links
 */
public class AboutPage extends ContentPage {

    /**
     * Pre-defined section spacing
     */
    private static final int SECTION_SPACING = 20;

    /**
     * Parent application window
     */
    private final AppWindow window;

    /**
     * Container JPanel for info cards
     */
    private final JPanel content;

    /**
     * Constructs a new AboutPage
     * @param window the application window in which the page is displayed
     */
    public AboutPage(AppWindow window) {
        this.window = window;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        TitleLabel title = new TitleLabel("About");
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        title.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                title.getPreferredSize().height
        ));
        add(title);

        add(Box.createVerticalStrut(SECTION_SPACING));

        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);
        content.setAlignmentX(Component.LEFT_ALIGNMENT);

        createVersionCard();
        addCardSpacing();

        createAttributionsCard();
        addCardSpacing();

        createLicenseCard();

        SmoothScrollPane scrollPane = new SmoothScrollPane(content);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(scrollPane);
    }

    /**
     * Creates a new info card with section heading
     * @param title the section heading to display on the card
     * @return the newly created info card
     */
    private InfoCard createCard(String title) {
        InfoCard card = new InfoCard();

        card.add(new SubTitle(title));
        card.add(Box.createVerticalStrut(SECTION_SPACING));

        return card;
    }

    /**
     * Adds a specified info card to the container JPanel
     * @param card the info card to add to the container
     */
    private void addCard(InfoCard card) {
        card.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                card.getPreferredSize().height
        ));

        content.add(card);
    }

    /**
     * Add a spacer of pre-defined size (defined as {@code SECTION_SPACING})
     */
    private void addCardSpacing() {
        content.add(Box.createVerticalStrut(SECTION_SPACING));
    }

    /**
     * Creates an info card displaying the application version number along
     * with a link to the application's GitHub page
     */
    private void createVersionCard() {
        InfoCard card = createCard("Version Information");

        card.add(new InfoLabel(
                "App Version: v" + AppDetails.APP_VERSION_NUMBER
        ));

        card.add(new LinkLabel(
                "Project GitHub",
                "https://github.com/scotthamilton7/ApplicationLauncher"
        ));

        addCard(card);
    }

    /**
     * Creates an info card displaying attributions to third-party resources
     * used by the application.
     */
    private void createAttributionsCard() {
        InfoCard card = createCard("Attributions");

        card.add(new LinkLabel(
                "Icons by Icons8",
                "https://icons8.com"
        ));

        card.add(new LinkLabel(
                "Look and Feel by FlatLaf",
                "https://formdev.com"
        ));

        card.add(new LinkLabel(
                "WrapLayout by tips4java",
                "https://github.com/tips4java/tips4java"
        ));

        addCard(card);
    }

    /**
     * Creates an info card containing a link to view third-party licenses.
     */
    private void createLicenseCard() {
        InfoCard card = createCard("Licenses");

        LinkLabel licensesLink =
                new LinkLabel("View third-party licenses", "");

        licensesLink.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                window.setContent(new LicensePage());
            }
        });

        card.add(licensesLink);

        addCard(card);
    }
}