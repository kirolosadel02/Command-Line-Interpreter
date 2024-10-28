package com.example.cli.main;

import com.example.cli.commands.Command;
import com.example.cli.commands.HelpCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private static CommandInvoker instance;
    private final Map<String, Command> commands = new HashMap<>();

    private CommandInvoker() {
        commands.put("help", new HelpCommand());
        commands.put("exit", CommandFactory.getCommand("exit"));
        commands.put("pwd", CommandFactory.getCommand("pwd"));
        // Add other commands here
    }

    public static CommandInvoker getInstance() {
        if (instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, parts.length - 1);

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Command not found: " + commandName);
        }
    }
}
