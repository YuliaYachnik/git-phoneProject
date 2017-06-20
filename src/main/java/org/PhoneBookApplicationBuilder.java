package org;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.Map;

/**
 * Created by Юлия on 19.06.2017.
 */
public class PhoneBookApplicationBuilder {

    public PhoneBookApplication build(){
       return new PhoneBookApplication();
    }

    public PhoneBookApplicationBuilder withCommands(CommandDefinition commandDefinition){
        return this;
    }

    public PhoneBookApplicationBuilder withConfig(Map<String,String> params){
        return this;
    }
}
