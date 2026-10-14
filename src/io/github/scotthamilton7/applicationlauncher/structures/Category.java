package io.github.scotthamilton7.applicationlauncher.structures;

import java.util.ArrayList;

public class Category {

    String name;
    ArrayList<App> apps;

    public Category(String name) {
        this.name = name;
        this.apps = new  ArrayList<>();
    }

    public String getName() {
        // Return category name
        return name;
    }

    public void addApp(App app) {
        // Add new app to this category
        apps.add(app);
    }

    public ArrayList<App> getApps() {
        // Return list of apps
        return apps;
    }

}
