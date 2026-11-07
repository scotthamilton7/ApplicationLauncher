package io.github.scotthamilton7.applicationlauncher.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a category containing a collection of applications.
 */
public class Category {

    /**
     * Category name to be displayed in the GUI
     */
    private final String name;

    /**
     * Collection of applications which belong in this category
     */
    private final List<App> apps;

    /**
     * Constructs a category with the specified name and an empty list of applications.
     * @param name the name of the category
     */
    public Category(String name) {
        this.name = name;
        this.apps = new  ArrayList<>();
    }

    /**
     * Returns the name of this category.
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Adds an application to this category.
     * @param app the application to add
     */
    public void addApp(App app) {
        if (getApp(app.getId()) != null) {
            IO.println(String.format(
                    "Error - cannot add app with the same ID (%s) to the same category (%s)",
                    app.getId(),
                    name
            ));
            return;
        }

        apps.add(app);
    }

    /**
     * Returns the list of applications belonging to this category.
     * The list is returned in an unmodifiable form.
     * @return the list of applications in this category
     */
    public List<App> getApps() {
        return Collections.unmodifiableList(apps);
    }

    /**
     * Get an application by its id in this category
     * @param id the id of the application to find
     * @return the application, or {@code null} if it was not found
     */
    public App getApp(String id) {
        for (App app : apps) {
            if (app.getId().equals(id)) {
                return app;
            }
        }

        return null;
    }

}
