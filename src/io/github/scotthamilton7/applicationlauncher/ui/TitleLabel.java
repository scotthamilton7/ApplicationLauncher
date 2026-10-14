package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TitleLabel extends InfoLabel {

    public TitleLabel(String text) {
        // Pass text to InfoLabel constructor
        super(text);

        // Set styling
        setFont(getFont().deriveFont(Font.BOLD, 18f));
        setForeground(Colors.TEXT_PRIMARY);
        setBorder(new EmptyBorder(10, 12, 10, 12));
    }

}
