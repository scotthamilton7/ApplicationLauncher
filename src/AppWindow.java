import javax.swing.*;

public class AppWindow extends JFrame {

    public AppWindow() {
        // Create application window
        setTitle("Application Launcher");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Show application window
        setVisible(true);
    }

}
