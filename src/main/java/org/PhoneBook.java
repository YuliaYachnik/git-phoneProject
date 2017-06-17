package org;

import org.parsing.ParseArguments;
import org.parsing.ParseMethodName;
import org.services.add.CommandAddDefinition;


public class PhoneBook {
    public static void main(String args[]) {
        ParseMethodName parseMethodName = new ParseMethodName.ParseMethodNameBilder(args).build();
    }
}
