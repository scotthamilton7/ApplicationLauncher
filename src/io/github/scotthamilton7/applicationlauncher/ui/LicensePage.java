package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class LicensePage extends ContentPage {

    public LicensePage() {
        // Use BorderLayout so the scroll pane fills the available content page space[cite: 9]
        setLayout(new BorderLayout(0, 15));

        // Page title[cite: 18]
        TitleLabel title = new TitleLabel("Licenses & Notices");
        add(title, BorderLayout.NORTH);

        // Load both files
        String noticeText = loadResourceText("/licenses/NOTICE.txt");
        String apacheLicenseText = loadResourceText("/licenses/LICENSE.txt");

        // Format combined text as HTML with preformatted blocks
        String combinedHtml = "<html><body style='font-family: sans-serif; font-size: 11px;'>"
                + "<h3 style='margin: 0; color: #212529;'>Notices & Third-Party Attributions</h3>"
                + "<pre style='font-family: monospace; font-size: 11px;'>" + escapeHtml(noticeText) + "</pre>"
                + "<hr style='border: 0; border-top: 1px solid #d8dde3; margin: 20px 0;'>"
                + "<h3 style='margin: 0; color: #212529;'>Apache License 2.0</h3>"
                + "<pre style='font-family: monospace; font-size: 11px;'>" + escapeHtml(apacheLicenseText) + "</pre>"
                + "</body></html>";

        JLabel lblLicense = new JLabel(combinedHtml);
        lblLicense.setForeground(Colors.TEXT_PRIMARY); //[cite: 8]
        lblLicense.setVerticalAlignment(SwingConstants.TOP);

        // Wrap inside an InfoCard for consistent rounded styling[cite: 10]
        InfoCard card = new InfoCard(); //[cite: 10]
        card.setLayout(new BorderLayout());
        card.setBorder(new EmptyBorder(16, 16, 16, 16));
        card.add(lblLicense, BorderLayout.CENTER);

        // Put inside scroll pane
        JScrollPane scrollPane = new JScrollPane(card);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    private String loadResourceText(String resourcePath) {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) {
                return "File not found: " + resourcePath;
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            return "Failed to load " + resourcePath + ": " + e.getMessage();
        }
    }

    private String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}