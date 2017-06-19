package org.services;

import org.parsing.ParseArguments;
import org.services.add.AddCommandImpl;
import org.services.add.CommandAddDefinition;
import org.services.find.CommandFindDefinition;
import org.services.find.FindCommandImpl;
import org.services.help.CommandDefinitionToHelp;
import org.services.help.CommandHelpDefinitionToHelp;
import org.services.help.HelpCommandImpl;
import org.services.list.CommandListDefinition;
import org.services.list.ListCommandImpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юлия on 19.06.2017.
 */
public class CommandDefinition {
    private String name;
    private List<ParametrsDefinition> parametrsDefinitions;
    private Command command;

    public CommandDefinition() throws Exception {}


    public void setName(String name) {
        this.name = name;
    }

    public void setParametrsDefinitions(List<ParametrsDefinition> parametrsDefinitions) {
        this.parametrsDefinitions = parametrsDefinitions;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean validation(String args[]){
        if (args.length == 0 || args.length > 5)
            return false;
        else return true;
        }
    public static boolean checkName(String str) {
        Pattern p = Pattern.compile("^add|find|list|help$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public Command checkCommand(String name){
        if(name.equals("add")) command = new AddCommandImpl();
        if (name.equals("find")) command = new FindCommandImpl();
        if (name.equals("list"))command = new ListCommandImpl();
        if(name.equals("help")) command = new HelpCommandImpl();
            return command;
    }

    public ParametrsDefinition getParametrs(String args[]){
        ParametrsDefinition parametrsDefinition;
        if(args.length < 2) return parametrsDefinition = null;
        else{
           for(int i = 0; i < args.length + 1; i++) {
               List <ParametrsDefinition> parametrsDefinitions;


               }
           }
        }
    


    public CommandDefinition parsing(String args[]){
        CommandDefinition commandDefinition;
        if (validation(args) == false || checkName(args[0])!= true) {
            commandDefinition = null;
            System.exit(0);
        }
        else{
            String name = args[0];
           Command command = checkCommand(name);
            //проверить parametrsDefinition на валидность и записать
           // commandDefinition = new CommandDefinition();

        }
        return commandDefinition;
        }
}
