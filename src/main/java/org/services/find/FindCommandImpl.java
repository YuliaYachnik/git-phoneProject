package org.services.find;

import org.parsing.ParseArguments;
import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class FindCommandImpl implements Command {
    private CommandFindDefinition commandFindDefinition;
    private ParseArguments parseArguments;

    public FindCommandImpl(CommandFindDefinition commandFindDefinition, ParseArguments parseArguments) {
        this.commandFindDefinition = commandFindDefinition;
        this.parseArguments = parseArguments;
    }

    public void execute() {
        commandFindDefinition.find(parseArguments);

    }
}
