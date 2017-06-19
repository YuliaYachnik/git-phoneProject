package org;

import org.services.Command;
import org.services.CommandDefinition;

import java.util.Map;

/**
 * Created by Юлия on 19.06.2017.
 */
public class PhoneBookApplicationBuilder {
    private PhoneBookApplication phoneBookApplication;

    public PhoneBookApplication build(){
        phoneBookApplication = new PhoneBookApplication();
        return phoneBookApplication;
    }

    public PhoneBookApplication withCommands(CommandDefinition commandDefinition){
        return phoneBookApplication;
    }
}
