package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import java.awt.*;

/**
 * A {@link JScrollPane} subclass configured for smoother scrolling
 * and transparent backgrounds.
 */
public class SmoothScrollPane extends JScrollPane {

    /**
     * Constructs an empty {@code SmoothScrollPane} and applies
     * the default scrolling configuration.
     */
    public SmoothScrollPane() {
        configure();
    }

    /**
     * Constructs a {@code SmoothScrollPane} displaying the specified
     * component and applies the default scrolling configuration.
     *
     * @param view the component to display in the scroll pane
     */
    public SmoothScrollPane(Component view) {
        super(view);
        configure();
    }

    /**
     * Configures the scroll pane by disabling horizontal scrolling,
     * enabling vertical scrolling as needed, setting the vertical
     * scrollbar's unit increment to 5, enabling mouse-wheel scrolling,
     * and making the scroll pane and its viewport non-opaque.
     */
    private void configure() {
        // Create empty border
        setBorder(BorderFactory.createEmptyBorder());
        // Disable horizontal scrolling
        setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        // Enable vertical scrolling as required
        setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        // Set scroll increment to 5 units, enable scroll wheel scrolling
        getVerticalScrollBar().setUnitIncrement(5);
        setWheelScrollingEnabled(true);

        // Keep the sidebar's background
        setOpaque(false);
        getViewport().setOpaque(false);
    }

}
