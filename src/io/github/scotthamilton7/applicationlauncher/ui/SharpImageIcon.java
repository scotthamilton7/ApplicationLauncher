package io.github.scotthamilton7.applicationlauncher.ui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.Objects;

public class SharpImageIcon implements Icon {
    private final Image image;
    private final int width;
    private final int height;

    public SharpImageIcon(String resourcePath, int targetWidth, int targetHeight) {
        this.image = new ImageIcon(Objects.requireNonNull(getClass().getResource(resourcePath))).getImage();
        this.width = targetWidth;
        this.height = targetHeight;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Capture the display scaling (e.g., 1.5 for 150%, 2.0 for 200%)
        AffineTransform transform = g2d.getTransform();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();

        // Translate the engine to the target layout coordinates first
        g2d.translate(x, y);

        // Strip out the soft native scaling to get back to 1:1 crisp pixel mapping
        g2d.scale(1.0 / scaleX, 1.0 / scaleY);

        // Draw the original high-res image directly onto the exact pixel coordinates
        // Scaling the boundaries up maps them to the exact physical HiDPI monitor grid
        g2d.drawImage(image, 0, 0, (int) (width * scaleX), (int) (height * scaleY), null);

        g2d.dispose();
    }

    @Override
    public int getIconWidth() { return width; }
    @Override
    public int getIconHeight() { return height; }
}
