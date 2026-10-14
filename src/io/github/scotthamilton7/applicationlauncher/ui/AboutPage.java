package io.github.scotthamilton7.applicationlauncher.ui;

import io.github.scotthamilton7.applicationlauncher.info.AppDetails;

import javax.swing.*;
import java.awt.*;

public class AboutPage extends ContentPage {

    public AboutPage() {
        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create page title
        TitleLabel title = new TitleLabel("About");
        add(title, BorderLayout.NORTH);

        // Add spacing between title and info cards
        add(Box.createVerticalStrut(20));

        // Create info cards
        createVersionCard();
        add(Box.createVerticalStrut(20));
        createAttributionsCard();
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
        add(pnlAppVersion);
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

        // Set sizing and add to page
        pnlAttributions.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                pnlAttributions.getPreferredSize().height
        ));
        add(pnlAttributions);
    }

}
