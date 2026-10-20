package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Subclass of {@link ContentPage} to display third-party licenses of libraries and utilities used
 * in the development of this application
 */
public class LicensePage extends ContentPage {

    public LicensePage() {
        setLayout(new BorderLayout(0, 15));

        TitleLabel title = new TitleLabel("Licenses & Notices");
        add(title, BorderLayout.NORTH);

        SmoothScrollPane scrollPane = new SmoothScrollPane(
                createLicenseCard(),
                true,
                true,
                16
        );
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Loads the contents of {@code /licenses/NOTICE.txt} and {@code /licenses/LICENSE.txt}, adds them
     * to a {@link JLabel} and creates a new {@link InfoCard} to display it
     * @return the new {@link InfoCard}
     */
    private JPanel createLicenseCard() {
        String noticeText = loadResourceText("/licenses/NOTICE.txt");
        String apacheLicenseText = loadResourceText("/licenses/LICENSE.txt");

        String combinedHtml = "<html><body style='font-family: sans-serif; font-size: 11px;'>"
                + "<h3 style='margin: 0; color: #212529;'>Notices & Third-Party Attributions</h3>"
                + "<pre style='font-family: monospace; font-size: 11px;'>" + escapeHtml(noticeText) + "</pre>"
                + "<hr style='border: 0; border-top: 1px solid #d8dde3; margin: 20px 0;'>"
                + "<h3 style='margin: 0; color: #212529;'>Apache License 2.0</h3>"
                + "<pre style='font-family: monospace; font-size: 11px;'>" + escapeHtml(apacheLicenseText) + "</pre>"
                + "</body></html>";

        JLabel lblLicense = new JLabel(combinedHtml);
        lblLicense.setForeground(Colors.TEXT_PRIMARY);
        lblLicense.setVerticalAlignment(SwingConstants.TOP);

        InfoCard card = new InfoCard();
        card.setLayout(new BorderLayout());
        card.setBorder(new EmptyBorder(16, 16, 16, 16));
        card.add(lblLicense, BorderLayout.CENTER);

        return card;
    }

    /**
     * Load content of a specified text file within the {@code /res} directory
     * @param resourcePath The path of the file to load. E.g. for a file at location
     * {@code /res/dir/file.txt}, the parameter {@code /dir/file.txt} should be passed
     * @return If the file is found and successfully read the contents of the file are returned.
     * <p>
     * If the file could not be found or loaded, an error message is returned.
     * <p>
     * E.g. {@code "File not found"} or {@code "Failed to load"}
     */
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

    /**
     * Replace special symbols {@code &}, {@code <}, and {@code >} with HTML escape characters
     * @param text the original text with special characters {@code &}, {@code <}, and {@code >}
     * @return the text with HTML escape characters {@code &amp}, {@code &lt}, and {@code &gt}
     */
    private String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}