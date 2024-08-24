package ru.susano.no.mikoto.AllComands;

public enum Commands {

    /*          This class(enum) contains all commands, which should help in communication with bot         */

    START("Start"),
    STOP("Stop"),
    ADMINPASSWORD("AdPass"),
    HELP("Help");

    private String prefix = "/";

    public final String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return prefix+command;
    }
}
