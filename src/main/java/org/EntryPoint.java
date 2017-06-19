package org;

import org.services.Command;
import org.services.CommandDefinition;
import org.services.ParametrsDefinition;
import org.services.add.AddCommandImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юлия on 19.06.2017.
 */
public class EntryPoint {
    public static void main(String args[]) {

        ParametrsDefinition parametrsDefinition = new ParametrsDefinition("name","Ivan");
        ParametrsDefinition parametrsDefinition1 = new ParametrsDefinition("phone","12345");
        List<ParametrsDefinition> parametrsDefinitions = new ArrayList<ParametrsDefinition>();
        parametrsDefinitions.add(parametrsDefinition);
        parametrsDefinitions.add(parametrsDefinition1);
        Command command = new AddCommandImpl();

         PhoneBookApplication phoneBookApplication = new
          PhoneBookApplicationBuilder().withCommands(new CommandDefinition("add", parametrsDefinitions,command)).build();
    }
}
