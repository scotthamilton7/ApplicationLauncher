package io.github.scotthamilton7.applicationlauncher.structures;

public class App {

    String name;
    String description;

    public App(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
