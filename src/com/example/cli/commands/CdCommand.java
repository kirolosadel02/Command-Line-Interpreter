package com.example.cli.commands;

import java.io.File;

public class CdCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify a directory.");
        } else {
            File directory = new File(args[0]);
            if (directory.isDirectory() && directory.exists()) {
                System.setProperty("user.dir", directory.getAbsolutePath());
                System.out.println("Directory changed to " + directory.getAbsolutePath());
            } else {
                System.out.println("Directory not found: " + args[0]);
            }
        }
    }
}
