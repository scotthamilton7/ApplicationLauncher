package io.github.scotthamilton7.applicationlauncher.ui;

import java.awt.*;

/**
 * Defines the color palette used throughout the application.
 * <p>
 * Provides shared colors for backgrounds and text to maintain
 * a consistent visual appearance across the user interface.
 */
public final class Colors {

    /**
     * Prevents instantiation of this utility class.
     */
    private Colors() {
        // Prevent instantiation
    }

    /**
     * Primary background color, used for main content areas.
     */
    public static final Color BACKGROUND_PRIMARY = new Color(255, 255, 255);

    /**
     * Secondary background color, used for subtly differentiated areas.
     */
    public static final Color BACKGROUND_SECONDARY = new Color(250, 250, 251);

    /**
     * Tertiary background color, used for additional visual separation.
     */
    public static final Color BACKGROUND_TERTIARY = new Color(235, 235, 237);

    /**
     * Primary text color, used for main content and headings.
     */
    public static final Color TEXT_PRIMARY = new Color(33, 37, 41);

    /**
     * Secondary text color, used for less prominent text.
     */
    public static final Color TEXT_SECONDARY = new Color(108, 117, 125);
}