package org;

import org.parsing.ParseArguments;
import org.service.Options;


public class AppRunning {
    public static void main(String args[]) {
        String arguments[] = args;
        Options options = new Options();
        try {
            ParseArguments parseArguments = new ParseArguments();
            if (arguments.length == 0)
                options.help(parseArguments.checkArgumentforHelp(arguments));
            else if (arguments.length != 0 && arguments[0].equals("help"))
                options.help(parseArguments.checkArgumentforHelp(arguments));
            else if (arguments.length != 0 && arguments[0].equals("add"))
                options.add(parseArguments.checkArgumentforAdd(arguments));
            else if (arguments.length != 0 && arguments[0].equals("find"))
                options.find(parseArguments.checkArgumentforFind(arguments));
            else if (arguments.length != 0 && arguments[0].equals("list"))
                options.list(parseArguments.checkArgumentforList(arguments));
            else {
                System.out.println("Error syntax. Please,use help-manager.");
                options.help(parseArguments.checkArgumentforHelp(arguments));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
