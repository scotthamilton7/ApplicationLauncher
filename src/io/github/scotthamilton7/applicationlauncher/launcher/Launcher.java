package io.github.scotthamilton7.applicationlauncher.launcher;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Launcher {

    public static void launch(String command, List<String> args) throws IOException {
        List<String> cmd;

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("linux")) {
            cmd = getLinuxCommand(command, args);
        }
        else {
            JOptionPane.showMessageDialog(null, "Unsupported operating system: " + os);
            throw new UnsupportedOperationException("Unsupported operating system: " + os);
        }

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.start();
    }

    private static ArrayList<String> getLinuxCommand(String command, List<String> args) {
        ArrayList<String> cmd = new ArrayList<>();
        cmd.add(command);
        cmd.addAll(args);
        return cmd;
    }

}
