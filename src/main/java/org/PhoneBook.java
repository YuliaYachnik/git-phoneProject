package org;

import org.parsing.ParseMethodName;

public class PhoneBook {
    public static void main(String args[]) {
        ParseMethodName parseMethodName = new ParseMethodName.ParseMethodNameBilder(args).build().run();
    }
}
