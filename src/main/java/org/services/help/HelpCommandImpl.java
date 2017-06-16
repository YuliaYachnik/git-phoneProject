package org.services.help;

import org.services.Command;

/**
 * Created by Юлия on 16.06.2017.
 */
public class HelpCommandImpl implements Command {
    private CommandHelpDefinition commandHelpDefinition;

    public HelpCommandImpl(CommandHelpDefinition commandHelpDefinition) {
        this.commandHelpDefinition = commandHelpDefinition;
    }

    public void execute() {
        commandHelpDefinition.help();
    }
}
