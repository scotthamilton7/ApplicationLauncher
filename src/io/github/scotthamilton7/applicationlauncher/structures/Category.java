package io.github.scotthamilton7.applicationlauncher.structures;

import java.util.ArrayList;

/**
 * Represents a category containing a collection of applications.
 */
public class Category {

    String name;
    ArrayList<App> apps;

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
        // Return category name
        return name;
    }

    /**
     * Adds an application to this category.
     * @param app the application to add
     */
    public void addApp(App app) {
        // Add new app to this category
        apps.add(app);
    }

    /**
     * Returns the list of applications belonging to this category.
     * @return the list of applications in this category
     */
    public ArrayList<App> getApps() {
        // Return list of apps
        return apps;
    }

}
