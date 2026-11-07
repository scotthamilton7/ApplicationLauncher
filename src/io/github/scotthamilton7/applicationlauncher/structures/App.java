package io.github.scotthamilton7.applicationlauncher.structures;

import io.github.scotthamilton7.applicationlauncher.ui.SharpImageIcon;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents an application
 * (This may be replaced by a record class in the future)
 */
public class App {

    /**
     * Application id to be used to identify this application
     */
    private final String id;

    /**
     * Application name to be displayed in the GUI
     */
    private final String name;

    /**
     * Description of application to be displayed in the GUI
     */
    private final String description;

    /**
     * The command used to run the app
     */
    private final String command;

    /**
     * An array of arguments to be passed to the app
     */
    private final ArrayList<String> arguments;

    private SharpImageIcon appIcon;

    private String rawIconPath = "";

    /**
     * Constructs an application with the specified details
     * @param name the application name
     * @param description a description of the application
     * @param command the command used in the CLI to run the app
     */
    public App(
            String id,
            String name,
            String description,
            String command
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.command = command;
        this.arguments = new ArrayList<>();
        this.appIcon = null;
    }

    /**
     * Constructs an application with the specified details
     * @param name the application name
     * @param description a description of the application
     * @param command the command used in the CLI to run the app
     * @param arguments any arguments to be passed to the application
     */
    public App(
            String id,
            String name,
            String description,
            String command,
            ArrayList<String> arguments
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.command = command;
        this.arguments = arguments;
        this.appIcon = null;
    }

    /**
     * Returns this application's id
     * @return this application's id
     */
    public String getId() {
        return id;
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

    /**
     * Returns the CLI command to run the application
     * @return the application command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Returns the arguments that get passed into this application
     * @return the list of arguments that get passed to the application
     */
    public ArrayList<String> getArguments() {
        return arguments;
    }

    /**
     * Takes a {@link SharpImageIcon} and sets it to be this application's icon
     * @param appIcon The {@link SharpImageIcon} to use
     */
    public void setAppIcon(SharpImageIcon appIcon) {
        this.appIcon = appIcon;
    }

    /**
     * Sets this applications icon to be a specified {@link ImageIcon}
     * @param appIcon The ImageIcon to convert to a SharpImageIcon and set as this application's icon
     */
    public void setAppIcon(ImageIcon appIcon) {
        this.appIcon = new SharpImageIcon(appIcon);
    }

    /**
     * Sets this application's icon to a specified image path, with specified height and width
     * @param path The path of the image
     * @param width The desired width of the image
     * @param height The desired height of the image
     */
    public void setAppIcon(String path, int width, int height) {
        this.appIcon = new SharpImageIcon(path, width, height);
    }

    /**
     * Returns this application's icon as a {@link SharpImageIcon}
     * @return This application's icon
     */
    public SharpImageIcon getAppIcon() {
        return appIcon;
    }

    public void setRawIconPath(String path) {
        this.rawIconPath = path != null ? path : "";
    }

    public String getRawIconPath() {
        return rawIconPath;
    }

}
