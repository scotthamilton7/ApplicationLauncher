package io.github.scotthamilton7.applicationlauncher.structures;

/**
 * Represents an application
 * (This may be replaced by a record class in the future)
 */
public class App {

    /**
     * Application name to be displayed in the GUI
     */
    private final String name;

    /**
     * Description of application to be displayed in the GUI
     */
    private final String description;

    /**
     * Constructs an application with the specified details
     * @param name the application name
     * @param description a description of the application
     */
    public App(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the name of this application
     * @return the name of this application
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this application
     * @return the description of this application
     */
    public String getDescription() {
        return description;
    }

}
