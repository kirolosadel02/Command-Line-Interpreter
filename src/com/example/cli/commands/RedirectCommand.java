package com.example.cli.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RedirectCommand implements Command {
    private final boolean append;

    public RedirectCommand(boolean append) {
        this.append = append;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("No output specified.");
            return;
        }

        String filename = args[0]; // Get the filename from the arguments
        StringBuilder output = new StringBuilder();

        // Here you would typically capture the output of the command to redirect
        // For simplicity, let's say we are redirecting a static output
        output.append("This is the output to be redirected.\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
            writer.write(output.toString());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
