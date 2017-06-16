package org;

import org.parsing.ParseArguments;
import org.services.add.CommandAddDefinition;


public class AppRunning {
    public static void main(String args[]) {
        String arguments[] = args;
        CommandAddDefinition commandAddDefinition = new CommandAddDefinition();
        try {
            ParseArguments parseArguments = new ParseArguments();
            if (arguments.length == 0)
                commandAddDefinition.help(parseArguments.checkArgumentforHelp(arguments));
            else if (arguments.length != 0 && arguments[0].equals("help"))
                commandAddDefinition.help(parseArguments.checkArgumentforHelp(arguments));
            else if (arguments.length != 0 && arguments[0].equals("add"))
                commandAddDefinition.add(parseArguments.checkArgumentforAdd(arguments));
            else if (arguments.length != 0 && arguments[0].equals("find"))
                commandAddDefinition.find(parseArguments.checkArgumentforFind(arguments));
            else if (arguments.length != 0 && arguments[0].equals("list"))
                commandAddDefinition.list(parseArguments.checkArgumentforList(arguments));
            else {
                System.out.println("Error syntax. Please,use help-manager.");
                commandAddDefinition.help(parseArguments.checkArgumentforHelp(arguments));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
