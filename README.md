# Application Launcher

A clean, modern desktop application launcher built with Java Swing and styled using FlatLaf. It organises programs and shell commands into categorised cards with custom icons and launch arguments.

## Features

- **Modern Flat UI:** Sleek, consistent look and feel using the FlatLaf Light theme.
- **Category Organisation:** Categorise apps into dedicated views accessible via the sidebar navigation.
- **Responsive Layout:** Dynamic grid wrapping using `WrapLayout`, ensuring app cards reflow smoothly when the window is resized.
- **HiDPI-Ready Icons:** Custom `SharpImageIcon` implementation scales icons cleanly on high-resolution screens using display-level affine transformations.
- **Cross-Platform Path Support:** Standard configuration and cache path resolution across Linux/Unix, Windows, and macOS.
- **Simple CSV Configuration:** Populate and edit launcher items easily through an `apps.csv` configuration file.



## Configuration

The application reads its launch entries from an `apps.csv` file located in your platform-specific config directory:

- **Linux/Unix:** `~/.config/io.github.scotthamilton7.applicationlauncher/apps.csv` (or `$XDG_CONFIG_HOME/...`)
- **Windows:** `%APPDATA%\io.github.scotthamilton7.applicationlauncher\apps.csv`
- **macOS:** `~/Library/Application Support/io.github.scotthamilton7.applicationlauncher/apps.csv`

### CSV Structure

The `apps.csv` file uses a header row followed by comma-separated records with **7 fields**:

```
id,name,description,command,arguments,icon,category
```

|Column|Description|Example|
|---|---|---|
|`id`|Unique string identifier|`firefox`|
|`name`|Application name shown on the card|`Firefox Web Browser`|
|`description`|Brief subtitle or summary|`Browse the World Wide Web`|
|`command`|Executable or binary command|`firefox`|
|`arguments`|Semicolon (`;`) separated CLI arguments|`--new-window;https://github.com`|
|`icon`|Cached icon file name (in the icon cache dir) or absolute file path|`firefox.png`|
|`category`|Category name under which the app appears|`Internet`|

Example `apps.csv`:
```
id,name,description,command,arguments,icon,category
firefox,Firefox Web Browser,Browse the World Wide Web,firefox,--new-window;https://github.com,firefox.png,Internet
```

### Custom Icons

To use custom icons:

1. Place the icon in the application's icon cache directory:
    - **Linux/Unix:** `~/.local/share/io.github.scotthamilton7.applicationlauncher/icons/` (or `$XDG_DATA_HOME/...`)
    - **Windows:** `%LOCALAPPDATA%\io.github.scotthamilton7.applicationlauncher\icons\`
    - **macOS:** `~/Library/Caches/io.github.scotthamilton7.applicationlauncher/icons/`
2. Reference the filename directly in the `icon` column of your `apps.csv`.
3. Alternatively, supply an absolute path to the image file. If left blank or unfound, a default play icon is used.



## Prerequisites & Building

- **Java Development Kit (JDK):** JDK 17 or later.
- **FlatLaf Dependency:** `flatlaf-3.7.2.jar` (located under `lib/`).

### Compiling and Running via Command Line

1. Compile the sources:
   ```
   javac -cp "lib/flatlaf-3.7.2.jar:res" -d out/production/ApplicationLauncher $(find src -name "*.java")
   ```
2. Copy resources (icons and license text) to the output folder:
   ```
   cp -r res/* out/production/ApplicationLauncher/
   ```
3. Run the application:
   ```
   java -cp "out/production/ApplicationLauncher:lib/flatlaf-3.7.2.jar" io.github.scotthamilton7.applicationlauncher.Main
   ```

**Note:** When running the application on a Linux desktop with a high resolution display with scaling set above 100%, I found it was better to run: 
```
   java -Dsun.java2d.uiScale=2 -cp "out/production/ApplicationLauncher:lib/flatlaf-3.7.2.jar" io.github.scotthamilton7.applicationlauncher.Main
```
Which scales the application GUI to 200%. Change the `uiScale=2` as required. (E.g. `uiScale=1.5` sets the scaling to 150%).

(If using an IDE like IntelliJ IDEA or Eclipse, import the project root, ensure `lib/flatlaf-3.7.2.jar` is added as a module library, mark `res` as a resources root, and run `io.github.scotthamilton7.applicationlauncher.Main`.)


## System Support

Process launching (`Launcher.java`) is currently only set up for **Linux**.
Support for Windows and macOS will be added in the future.



## Attributions & Licenses

- **[FlatLaf](https://formdev.com):** Licensed under Apache License 2.0.
- **[WrapLayout](https://github.com/tips4java/tips4java):** Created by Rob Camick, licensed under the MIT License.
- **Icons:** Provided by [Icons8](https://icons8.com).

Full license terms can be viewed within the application under **About > View third-party licenses** or in the `NOTICE.txt` and `LICENSE.txt` files.



## Disclaimer

Some of this documentation has been partially generated using AI. All commands have been verified to work correctly.
