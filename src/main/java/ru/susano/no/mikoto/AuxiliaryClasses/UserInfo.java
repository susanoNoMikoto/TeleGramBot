package ru.susano.no.mikoto.AuxiliaryClasses;

import org.telegram.telegrambots.meta.api.objects.Update;

public class UserInfo {

    public static String user_TagName(Update update){
        return update.getMessage().getFrom().getUserName();
    };
    public static String user_ReceivedMessage(Update update){
        return update.getMessage().getText();
    }
    public static long user_ChatID(Update update){
        return update.getMessage().getChatId();
    }

}
