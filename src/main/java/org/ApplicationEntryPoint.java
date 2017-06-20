package org;

import org.services.CommandDefinition;
import org.services.ParametrDefinitions;

import java.util.*;

/**
 * Created by Юлия on 19.06.2017.
 */
public class ApplicationEntryPoint {
    public static void main(String args[]) throws ClassNotFoundException {

        List <ParametrDefinitions> parametrDefinitionsList = new ArrayList <ParametrDefinitions> ();
        ParametrDefinitions parametrDefinitions = new ParametrDefinitions("name",true);
        ParametrDefinitions parametrDefinitions1 = new ParametrDefinitions("phone",true);
        parametrDefinitionsList.add(parametrDefinitions);
        parametrDefinitionsList.add(parametrDefinitions1);
        Class command = Class.forName("org.services.add.AddCommandImpl");
        Class commandFind = Class.forName("org.services.find.FindCommandImpl");
        Map<String,String>  map = new HashMap<String, String>();
        map.put("--filename","myfile.txt");
        map.put("--dir","myfile");
   ;


         PhoneBookApplication phoneBookApplication = new PhoneBookApplicationBuilder()
                 .withCommands(new CommandDefinition("add", parametrDefinitionsList,command))
                 .withConfig(map)
                 .withCommands(new CommandDefinition("find", parametrDefinitionsList,commandFind))
                .withConfig(map)
                .build();

        phoneBookApplication.run(args);
    }
}
