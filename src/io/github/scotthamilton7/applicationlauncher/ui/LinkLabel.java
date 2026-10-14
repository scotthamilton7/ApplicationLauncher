package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class LinkLabel extends InfoLabel{

    public LinkLabel(String text, String url) {
        // Set text
        setText("<html><a href=''>" + text + "</a></html>");

        // Set styling
        setBorder(new EmptyBorder(5, 12, 5, 12));

        // Setup link clicking
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
