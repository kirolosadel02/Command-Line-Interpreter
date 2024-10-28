package com.example.cli.commands;

import java.io.File;

public class RmCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify a file name.");
            return;
        }
        File file = new File(System.getProperty("user.dir") + File.separator + args[0]);
        if (file.exists() && file.delete()) {
            System.out.println("Deleted file: " + file.getName());
        } else {
            System.out.println("Failed to delete file: " + args[0]);
        }
    }
}
