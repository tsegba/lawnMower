package kata.lawnmower.app.parsers;

import kata.lawnmower.domain.enums.Command;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CommandParser {
    private final String commandString;

    public CommandParser(final String commandString) {
        this.commandString = commandString;
    }

    public Queue<Command> getCommands() throws InvalidParameterException {
        if(isNullOrEmpty(commandString))
            throw new InvalidParameterException("Command is empty, retry!");

        return buildCommand(commandString);
    }
    private Queue<Command> buildCommand(final String commandString) throws InvalidParameterException {
        Queue<Command> commands = new LinkedList<>();
        for (int i = 0; i < commandString.length(); i++) {
            Character command = commandString.charAt(i);
            try {
                Command mappedCommand = Command.valueOf(command.toString());
                commands.add(mappedCommand);
            }catch (IllegalArgumentException exception){
                throw new InvalidParameterException("Invalid command for the mower! [" + command + "].");
            }
        }
        return commands;
    }
    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }
}
