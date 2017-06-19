package org.services;

import java.util.List;

/**
 * Created by Юлия on 19.06.2017.
 */
public class CommandDefinition {
    private String name;
    private List<ParametrsDefinition> parametrDefinitions;
    private Command <Command> command;


    public void setName(String name) {
        this.name = name;
    }

    public void setParametrDefinitions(List<ParametrsDefinition> parametrDefinitions) {
        this.parametrDefinitions = parametrDefinitions;
    }

    public CommandDefinition(String name, List<ParametrsDefinition> parametrDefinitions,Command<Command> command) {
        this.name = name;
        this.parametrDefinitions = parametrDefinitions;
        this.command = command;
    }

    public void setCommand(Command<Command> command) {
        this.command = command;
    }





  /*  public boolean validation(String args[]){
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
               List <ParametrsDefinition> parametrDefinitions;


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
        }*/
}
