package com.example.cli.commands;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.example.cli.main.CommandFactory;

public class PipeCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough commands to pipe.");
            return;
        }

        // Assuming args[0] is the first command and args[1] is the second command
        Command firstCommand = CommandFactory.getCommand(args[0], new String[] {}); // Pass appropriate args
        Command secondCommand = CommandFactory.getCommand(args[1], new String[] {}); // Pass appropriate args

        // Capture output from the first command
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        if (firstCommand != null) {
            firstCommand.execute(new String[] {});
        }

        System.setOut(originalOut); // Restore original output

        // Get the output from the first command
        String commandOutput = outputStream.toString();

        // Now we would pass this output to the second command
        // This part will depend on how you implement the second command
        // You might need to change the signature of commands to accept input

        System.out.println("Output from first command: " + commandOutput); // Just for demo purposes
        if (secondCommand != null) {
            // Execute the second command
            secondCommand.execute(new String[] {}); // Replace with actual output input if needed
        }
    }
}
