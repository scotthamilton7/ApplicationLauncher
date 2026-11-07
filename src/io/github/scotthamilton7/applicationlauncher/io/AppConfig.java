package io.github.scotthamilton7.applicationlauncher.io;

import io.github.scotthamilton7.applicationlauncher.structures.App;
import io.github.scotthamilton7.applicationlauncher.structures.Category;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public final class AppConfig {

    public static final String APP_LIST_PATH = "apps.csv";
    public static final String COMMA_DELIMITER = ",";
    public static final String ARGUMENT_DELIMITER = ";";

    private AppConfig() {}

    public static List<Category> loadCategories() throws IOException {
        Path appPath = AppPaths.getConfigDirectory().resolve(APP_LIST_PATH);
        File file = appPath.toFile();

        if (!file.exists()) {
            return new ArrayList<>();
        }

        Map<String, List<App>> data = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // Skip CSV header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // Check all 7 expected fields exist
                String[] values = line.split(COMMA_DELIMITER, -1);
                if (values.length < 7) {
                    continue;
                }

                String id = values[0].trim();
                String name = values[1].trim();
                String description = values[2].trim();
                String command = values[3].trim();
                String rawArgs = values[4].trim();
                String icon = values[5].trim();
                String category = values[6].trim();

                // Separate arguments
                ArrayList<String> arguments = new ArrayList<>();
                if (!rawArgs.isEmpty()) {
                    arguments.addAll(List.of(rawArgs.split(ARGUMENT_DELIMITER)));
                }

                // Add new app to category
                App app = new App(id, name, description, command, arguments);
                resolveAndSetIcon(app, icon);
                data.computeIfAbsent(category, k -> new ArrayList<>()).add(app);
            }
        }

        List<Category> categories = new ArrayList<>();
        for (Map.Entry<String, List<App>> entry : data.entrySet()) {
            Category newCat = new Category(entry.getKey());
            for (App app : entry.getValue()) {
                newCat.addApp(app);
            }
            categories.add(newCat);
        }

        return categories;
    }

    private static void resolveAndSetIcon(App app, String icon) {
        app.setRawIconPath(icon);

        if (icon == null || icon.isBlank()) return;

        // Check if icon is in local cache
        Path cached = AppPaths.getIconDirectory().resolve(icon);
        if (cached.toFile().exists()) {
            app.setAppIcon(new ImageIcon(cached.toAbsolutePath().toString()));
            return;
        }

        // If not, check if an absolute path has been given
        File direct = new File(icon);
        if (direct.exists()) {
            app.setAppIcon(new ImageIcon(direct.getAbsolutePath()));
        }

        // Otherwise, default play icon will be used
    }

}
