package org.services.add;

import org.parsing.ParseArguments;
import org.services.Command;
import org.services.help.CommandAddDefinitionToHelp;
import org.services.help.CommandDefinitionToHelp;

/**
 * Created by Юлия on 16.06.2017.
 */
public class AddCommandImpl extends Command{
    private CommandAddDefinition commandAddDefinition;
    private CommandDefinitionToHelp commandDefinitionToHelp;
    private  ParseArguments parseArguments;

    public AddCommandImpl(ParseArguments parseArguments, CommandAddDefinition commandAddDefinition){
        this.parseArguments = parseArguments;
        this.commandAddDefinition = commandAddDefinition;
    }

    public AddCommandImpl(){}

    public void execute() {
        if(parseArguments != null) commandAddDefinition.add(parseArguments);
        else {
            commandDefinitionToHelp = new CommandAddDefinitionToHelp().executeHelp();
            System.exit(0);
        }
    }
}
