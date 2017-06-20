package org;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookApplication {
    private List <CommandDefinition> commandDefinition;
    private Map<String,String> params;

    public PhoneBookApplication(List <CommandDefinition> commandDefinition, Map<String, String> params) {
        this.commandDefinition = commandDefinition;
        this.params = params;
    }

    public void run(String args[]){

       // System.out.println(this.commandDefinition);
       // System.out.println(this.params);
        String name = args[0];

    }
}
