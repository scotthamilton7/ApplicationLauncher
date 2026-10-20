package io.github.scotthamilton7.applicationlauncher.ui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

/**
 * Subclass of {@link InfoLabel}
 */
public class LinkLabel extends InfoLabel{

    /**
     * Constructs a new {@link LinkLabel} which using HTML link styling and navigates to a specified
     * URL when clicked
     * @param text the text to be displayed by the label
     * @param url the URL to navigate to when clicked
     */
    public LinkLabel(String text, String url) {
        setText("<html><a href=''>" + text + "</a></html>");

        makeClickable(url);
    }

    /**
     * Add a mouse listener to the {@link LinkLabel} which listens for a mouse click, and navigates to the given
     * URL when the mouse is clicked.
     * @param url the URL to navigate to when clicked
     */
    private void makeClickable(String url) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Prevent blank browser window opening if URL is left blank
        if (url.isEmpty()) return;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(
                            new URI(url)
                    );
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
