package org;

import org.parsing.ParseStartingMethodName;

public class PhoneBook {
    public static void main(String args[]) {
        ParseStartingMethodName parseStartingMethodName = new ParseStartingMethodName.ParseStartingMethodNameBuilder(args).build().run();
    }
}
