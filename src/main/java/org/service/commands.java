package org.service;

import org.parsing.ParseArguments;

public interface commands {
    public void add(ParseArguments parseArguments);
    public void find(ParseArguments parseArguments);
    public void list(ParseArguments parseArguments);
    public void help(ParseArguments parseArguments);
}
