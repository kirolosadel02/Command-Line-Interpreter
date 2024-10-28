package com.example.cli.commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Exiting CLI...");
        System.exit(0);
    }
}