package com.example.cli.commands;

import java.io.File;

public class MvCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Please specify source and destination.");
            return;
        }
        File source = new File(System.getProperty("user.dir") + File.separator + args[0]);
        File destination = new File(System.getProperty("user.dir") + File.separator + args[1]);

        if (source.exists() && source.renameTo(destination)) {
            System.out.println("Moved " + source.getName() + " to " + destination.getName());
        } else {
            System.out.println("Failed to move " + source.getName());
        }
    }
}
