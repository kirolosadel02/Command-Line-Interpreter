package com.example.cli.commands;

public class PwdCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
