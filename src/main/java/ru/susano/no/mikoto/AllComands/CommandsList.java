package ru.susano.no.mikoto.AllComands;

public enum CommandsList {

    /*          This class(enum) contains all commands, which should help in communication with bot         */

    START("/start"),
    STOP("/stop"),
    ADMINPASSWORD("/adminpassword"),
    HELP("/help"),
    TEMP("/temp"),
    PARSER("/parser"),
    NOT_COMMAND("");


    private String command;

    CommandsList(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command.toString();
    }

    public static CommandsList getReceivedCommand(String command) {
        CommandsList temp = null;
        for (CommandsList c : CommandsList.values()) {
            if(c.command.toString().equalsIgnoreCase(command)) {
                temp = c;
                break;
            } else {
                temp = NOT_COMMAND;
            }
        }
        return temp;
    }

}
