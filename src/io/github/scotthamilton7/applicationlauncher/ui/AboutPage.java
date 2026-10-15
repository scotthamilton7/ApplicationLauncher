package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.info.AppDetails;

import javax.swing.*;
import java.awt.*;

public class AboutPage extends ContentPage {

    AppWindow window;
    JPanel content;

    public AboutPage(AppWindow window) {
        // Save app window so license page can be loaded
        this.window = window;

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create page title
        TitleLabel title = new TitleLabel("About");
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        title.setMaximumSize(new Dimension(Integer.MAX_VALUE, title.getPreferredSize().height));
        add(title);

        // Add spacing between title and info cards
        add(Box.createVerticalStrut(20));

        // Initialize content panel
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setOpaque(false);
        content.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Create info cards
        createVersionCard();
        content.add(Box.createVerticalStrut(20));
        createAttributionsCard();
        content.add(Box.createVerticalStrut(20));
        createLicenseCard();

        // Add cards to scroll pane
        SmoothScrollPane scrollPane =  new SmoothScrollPane(content);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(scrollPane);
    }

    private void createVersionCard() {
        // Create info card
        InfoCard pnlAppVersion = new InfoCard();

        // Create subtitle
        SubTitle lblVersionTitle = new SubTitle("Version Information");
        pnlAppVersion.add(lblVersionTitle);

        // Create spacer
        pnlAppVersion.add(Box.createVerticalStrut(20));

        // Add version number
        InfoLabel lblVersion = new InfoLabel("App Version: v" + AppDetails.APP_VERSION_NUMBER);
        pnlAppVersion.add(lblVersion);

        // Add GitHub link
        LinkLabel lblGitHub = new LinkLabel("Project GitHub", "https://github.com/scotthamilton7/ApplicationLauncher");
        pnlAppVersion.add(lblGitHub);

        // Set sizing and add to page
        pnlAppVersion.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                pnlAppVersion.getPreferredSize().height
        ));
        content.add(pnlAppVersion);
    }

    private void createAttributionsCard() {
        // Create info card
        InfoCard pnlAttributions = new  InfoCard();

        // Create subtitle
        SubTitle lblAttributionsTitle = new SubTitle("Attributions");
        pnlAttributions.add(lblAttributionsTitle);

        // Create spacer
        pnlAttributions.add(Box.createVerticalStrut(20));

        // Add icons8 link
        LinkLabel lblIcons8 = new LinkLabel("Icons by Icons8", "https://icons8.com");
        pnlAttributions.add(lblIcons8);

        // Add FlatLaf link
        LinkLabel lblFlatLaf = new LinkLabel("Look and Feel by FlatLaf", "https://formdev.com");
        pnlAttributions.add(lblFlatLaf);

        // Add WrapLayout link
        LinkLabel lblWrapLayout = new LinkLabel("WrapLayout by tips4java", "https://github.com/tips4java/tips4java");
        pnlAttributions.add(lblWrapLayout);

        // Set sizing and add to page
        pnlAttributions.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                pnlAttributions.getPreferredSize().height
        ));
        content.add(pnlAttributions);
    }

    private void createLicenseCard() {
        // Create info card
        InfoCard pnlLicenses = new  InfoCard();

        // Create subtitle
        SubTitle lblAttributionsTitle = new SubTitle("Licenses");
        pnlLicenses.add(lblAttributionsTitle);

        // Create spacer
        pnlLicenses.add(Box.createVerticalStrut(20));

        // Add icons8 link
        LinkLabel lblLicenses = new LinkLabel("View third-party licenses", "");
        lblLicenses.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                window.setContent(new LicensePage());
            }
        });
        pnlLicenses.add(lblLicenses);

        // Set sizing and add to page
        pnlLicenses.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                pnlLicenses.getPreferredSize().height
        ));
        content.add(pnlLicenses);
    }

}
