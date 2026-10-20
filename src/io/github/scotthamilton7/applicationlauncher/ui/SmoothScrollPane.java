package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.*;
import java.awt.*;

/**
 * A {@link JScrollPane} subclass configured for smoother scrolling
 * and transparent backgrounds.
 */
public class SmoothScrollPane extends JScrollPane {

    /**
     * Represents the default choice to display a vertical scrollbar ({@code true})
     */
    private static final boolean DEFAULT_VERTICAL_SCROLL = true;

    /**
     * Represents the default choice to display a horizontal scrollbar ({@code false})
     */
    private static final boolean DEFAULT_HORIZONTAL_SCROLL = false;

    /**
     * Represents the default number of units a scrollbar increment scrolls the content ({@code 5})
     */
    private static final int DEFAULT_SCROLL_INCREMENT = 5;

    /**
     * Constructs an empty {@code SmoothScrollPane} and applies
     * the default scrolling configuration.
     */
    public SmoothScrollPane() {
        configure(
                DEFAULT_VERTICAL_SCROLL,
                DEFAULT_HORIZONTAL_SCROLL,
                DEFAULT_SCROLL_INCREMENT
        );
    }

    /**
     * Constructs a {@code SmoothScrollPane} displaying the specified
     * component and applies the default scrolling configuration.
     *
     * @param view the component to display in the scroll pane
     */
    public SmoothScrollPane(Component view) {
        super(view);
        configure(
                DEFAULT_VERTICAL_SCROLL,
                DEFAULT_HORIZONTAL_SCROLL,
                DEFAULT_SCROLL_INCREMENT
        );
    }

    /**
     * Constructs a {@code SmoothScrollPane} displaying the specified
     * component and applies the specified scrolling configuration.
     * @param view the component to display in the scroll pane
     * @param verticalScroll should a vertical scroll bar be displayed if needed
     * @param horizontalScroll should a horizontal scroll bar be displayed if needed
     * @param scrollIncrement how many units should each scrollbar increment scroll the content
     */
    public SmoothScrollPane(
            Component view,
            boolean verticalScroll,
            boolean horizontalScroll,
            int scrollIncrement
    ) {
        super(view);
        configure(verticalScroll, horizontalScroll, scrollIncrement);
    }

    /**
     * Configure the scroll pane by setting horizontal and vertical scrollbar
     * policies as specified, set the scrollbars' unit increment to the specified
     * value, and make the scroll pane and its viewport non-opaque.
     */
    private void configure(boolean vertical, boolean horizontal, int increment) {
        setBorder(BorderFactory.createEmptyBorder());

        setVerticalScrollBarPolicy(
                vertical ? JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED : JScrollPane.VERTICAL_SCROLLBAR_NEVER
        );
        setHorizontalScrollBarPolicy(
                horizontal ? JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED : JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        getVerticalScrollBar().setUnitIncrement(increment);
        getHorizontalScrollBar().setUnitIncrement(increment);
        setWheelScrollingEnabled(true);

        setOpaque(false);
        getViewport().setOpaque(false);
    }

}
