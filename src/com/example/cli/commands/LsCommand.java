package com.example.cli.commands;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class LsCommand implements Command {
    @Override
    public void execute(String[] args) {
        File currentDir = new File(System.getProperty("user.dir"));
        File[] files = currentDir.listFiles();

        if (files != null) {
            if (args.length > 0 && args[0].equals("-r")) {
                Arrays.sort(files, Comparator.reverseOrder());
            } else {
                Arrays.sort(files);
            }
            for (File file : files) {
                if (args.length > 0 && args[0].equals("-a")) {
                    System.out.println(file.getName());
                } else if (!file.isHidden()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Could not list files.");
        }
    }
}
