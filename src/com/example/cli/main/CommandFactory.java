package com.example.cli.main;

import com.example.cli.commands.*;

public class CommandFactory {
    public static Command getCommand(String commandName) {
        return switch (commandName) {
            case "pwd" -> new PwdCommand();
            case "exit" -> new ExitCommand();
            case "help" -> new HelpCommand();
            // Add cases for other commands
            default -> null;
        };
    }
}
