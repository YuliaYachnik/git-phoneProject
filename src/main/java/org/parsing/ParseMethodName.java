package org.parsing;

import org.services.Command;
import org.services.add.AddCommandImpl;
import org.services.add.CommandAddDefinition;
import org.services.find.CommandFindDefinition;
import org.services.find.FindCommandImpl;
import org.services.help.CommandHelpDefinition;
import org.services.help.HelpCommandImpl;
import org.services.list.CommandListDefinition;
import org.services.list.ListCommandImpl;

/**
 * Created by Юлия on 17.06.2017.
 */
public class ParseMethodName {

    private final String[]  methodName;

    private ParseMethodName(ParseMethodNameBilder bilder){
        this.methodName = bilder.methodName;
    }

    public String[] getMethodName() {
        return methodName;
    }

    public Command startingParser(String[] args) throws ExceptionInInitializerError{
        String arguments[] = args;
        Command command = null;
        try{
            if(arguments.length == 0){
                System.out.println("Error syntax. Please,use help-manager.");
                System.exit(0);
            }
            else{
                if(arguments.length > 5)
                {
                    System.out.println("So much arguments in function invoke. Please,use help-manager.");
                    System.exit(0);
                }
                else{
                    if(arguments[0].equals("add")) {
                        CommandAddDefinition commandAddDefinition = new CommandAddDefinition();
                        ParseArguments parseArguments = new ParseArguments();
                        command = new AddCommandImpl(parseArguments.checkArgumentForAdd(args),commandAddDefinition);
                    }
                    else if (arguments[0].equals("find")){
                        CommandFindDefinition commandFindDefinition = new CommandFindDefinition();
                        ParseArguments parseArguments = new ParseArguments();
                        command = new FindCommandImpl(commandFindDefinition,parseArguments.checkArgumentForFind(args));
                    }
                    else if (arguments[0].equals("list")) {
                        CommandListDefinition commandListDefinition = new CommandListDefinition();
                        ParseArguments parseArguments = new ParseArguments();
                        command = new ListCommandImpl(commandListDefinition,parseArguments.checkArgumentForList(args));
                    }
                    else if (arguments[0].equals("help")) {
                        CommandHelpDefinition commandHelpDefinition = new CommandHelpDefinition();
                        command = new HelpCommandImpl(commandHelpDefinition);
                    }
                    else {
                        System.out.println("Error syntax. Please,use help-manager.");
                        System.exit(0);
                    }
                }
            }
        }catch (ExceptionInInitializerError exceptionInInitializerError){
            System.out.println(exceptionInInitializerError);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return command;
    }

    public ParseMethodName  run(){
        Command command = startingParser(methodName);
        command.execute();
        return this;
    }

    public static class ParseMethodNameBilder{
        private final String[] methodName;

        public ParseMethodNameBilder(String[] methodName) {
            this.methodName = methodName;
        }

        public String[] getMethodName() {
            return methodName;
        }

        public ParseMethodName build(){
            ParseMethodName parseMethodName = new ParseMethodName(this);
            return parseMethodName;
        }
    }
}
