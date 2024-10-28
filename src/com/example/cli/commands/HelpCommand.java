package com.example.cli.commands;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Available commands:");
        System.out.println("pwd - Print working directory");
        System.out.println("cd [directory] - Change directory");
        System.out.println("exit - Exit the CLI");
        System.out.println("help - Show this help message");
        // Add descriptions for other commands here
    }
}
