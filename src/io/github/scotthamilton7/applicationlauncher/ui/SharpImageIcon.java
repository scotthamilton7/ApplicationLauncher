package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.Objects;

/**
 * Subclass of {@link Icon} to scale images for high resolution displays without going blurry
 */
public class SharpImageIcon implements Icon {
    /**
     * The image represented by this {@link SharpImageIcon}
     */
    private final Image image;

    /**
     * The width of this {@link SharpImageIcon}
     */
    private final int width;

    /**
     * The height of this {@link SharpImageIcon}
     */
    private final int height;

    /**
     * Constructs a new {@link SharpImageIcon} with specified image, width, and height
     * @param resourcePath The path to the resource image (within the {@code /res} directory)
     * @param targetWidth The width to scale the image to
     * @param targetHeight The height to scale the image to
     */
    public SharpImageIcon(String resourcePath, int targetWidth, int targetHeight) {
        this.image = new ImageIcon(Objects.requireNonNull(getClass().getResource(resourcePath))).getImage();
        this.width = targetWidth;
        this.height = targetHeight;
    }

    /**
     * Paints this icon at the specified position, scaling the image to account
     * for the display's HiDPI scale factor.
     * <p>
     * The graphics context's current transform is used to determine the
     * horizontal and vertical display scaling factors. The graphics context
     * is then translated to the specified position and inversely scaled
     * to compensate for the native scaling applied by the graphics system.
     * The image is drawn at dimensions adjusted for the display scale factor,
     * allowing a high-resolution source image to be rendered at the intended
     * logical dimensions with improved sharpness on HiDPI displays.
     * <p>
     * A copy of the supplied graphics context is used so that the transformations
     * applied during painting do not affect the original graphics context.
     *
     * @param c the component this icon is being painted on; may be {@code null}
     * @param g the graphics context used to paint the icon
     * @param x the x-coordinate of the icon's top-left corner
     * @param y the y-coordinate of the icon's top-left corner
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Capture the display scaling (e.g., 1.5 for 150%, 2.0 for 200%)
        AffineTransform transform = g2d.getTransform();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();

        // Translate the engine to the target layout coordinates first
        g2d.translate(x, y);

        // Remove the soft native scaling to get back to 1:1 pixel mapping
        g2d.scale(1.0 / scaleX, 1.0 / scaleY);

        // Draw the original high-res image directly onto the exact pixel coordinates
        // Scaling the boundaries up maps them to the exact physical HiDPI monitor grid
        g2d.drawImage(image, 0, 0, (int) (width * scaleX), (int) (height * scaleY), null);

        g2d.dispose();
    }

    /**
     * Get the width of this {@link SharpImageIcon}
     * @return The width of this {@link SharpImageIcon}
     */
    @Override
    public int getIconWidth() { return width; }

    /**
     * Get the height of this {@link SharpImageIcon}
     * @return The height of this {@link SharpImageIcon}
     */
    @Override
    public int getIconHeight() { return height; }
}
