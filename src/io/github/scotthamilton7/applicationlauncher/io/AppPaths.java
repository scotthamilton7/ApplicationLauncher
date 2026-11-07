package io.github.scotthamilton7.applicationlauncher.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AppPaths {

    public static final String APP_ID = "io.github.scotthamilton7.applicationlauncher";

    private AppPaths() {}

    /**
     * Returns the system specific config path for storing config files
     * @return On Windows: {@code %APPDATA%}
     *    <br> On macOS: {@code ~/Library/Application Support}
     *    <br> On Linux/Unix: {@code ~/.config}
     */
    public static Path getConfigDirectory() {
        String os = System.getProperty("os.name").toLowerCase();
        Path path;

        if (os.contains("win")) {
            // Windows: %APPDATA% (Roaming app data)
            String appData = System.getenv("APPDATA");
            path = (appData != null && !appData.isBlank())
                    ? Paths.get(appData)
                    : Paths.get(System.getProperty("user.home"), "AppData", "Roaming");
        }
        else if (os.contains("mac")) {
            // macOS: ~/Library/Application Support
            path = Paths.get(System.getProperty("user.home"), "Library", "Application Support");
        }
        else {
            // Linux/Unix: $XDG_CONFIG_HOME or ~/.config
            String xdgConfig = System.getenv("XDG_CONFIG_HOME");
            path = (xdgConfig != null && !xdgConfig.isBlank())
                    ? Paths.get(xdgConfig)
                    : Paths.get(System.getProperty("user.home"), ".config");
        }

        Path configDirectory = path.resolve(APP_ID);
        createDirectoryIfNotExists(configDirectory);
        return configDirectory;
    }

    /**
     * Returns the system specific data path for storing application icon caches
     * @return On Windows: {@code %LOCALAPPDATA%}
     *    <br> On macOS: {@code ~/Library/Caches}
     *    <br> On Linux/Unix: {@code ~/.local/share}
     */
    public static Path getIconDirectory() {
        String os = System.getProperty("os.name").toLowerCase();
        Path path;

        if (os.contains("win")) {
            // Windows: %LOCALAPPDATA% (Local app data)
            String appData = System.getenv("LOCALAPPDATA");
            path = (appData != null && !appData.isBlank())
                    ? Paths.get(appData)
                    : Paths.get(System.getProperty("user.home"), "AppData", "Local");
        }
        else if (os.contains("mac")) {
            // macOS: ~/Library/Caches
            path = Paths.get(System.getProperty("user.home"), "Library", "Caches");
        }
        else {
            // Linux/Unix: $XDG_DATA_HOME or ~/.local/share
            String xdgData = System.getenv("XDG_DATA_HOME");
            path = (xdgData != null && !xdgData.isBlank())
                    ? Paths.get(xdgData)
                    : Paths.get(System.getProperty("user.home"), ".local", "share");
        }

        Path iconDirectory = path.resolve(APP_ID).resolve("icons");
        createDirectoryIfNotExists(iconDirectory);
        return iconDirectory;
    }

    /**
     * Checks a specified directory path and creates it if it doesn't already exist
     * @param path the path to create if it doesn't exist
     */
    private static void createDirectoryIfNotExists(Path path) {
        File directory = path.toFile();

        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

}
