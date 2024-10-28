package com.example.cli.main;

import com.example.cli.commands.*;

public class CommandFactory {
    public static Command getCommand(String commandName, String[] args) {
        return switch (commandName) {
            case "pwd" -> new PwdCommand();
            case "cd" -> new CdCommand();
            case "ls" -> {
                boolean showAll = args.length > 0 && args[0].equals("-a");
                boolean reverse = args.length > 1 && args[1].equals("-r");
                yield new LsCommand(showAll, reverse);
            }
            case "mkdir" -> new MkdirCommand();
            case "rmdir" -> new RmdirCommand();
            case "touch" -> new TouchCommand();
            case "mv" -> new MvCommand();
            case "rm" -> new RmCommand();
            case "cat" -> new CatCommand();
            case ">" -> new RedirectCommand(false);
            case ">>" -> new RedirectCommand(true);
            case "|" -> new PipeCommand();
            case "exit" -> new ExitCommand();
            case "help" -> new HelpCommand();
            default -> null;
        };
    }
}
