package ru.susano.no.mikoto.AuxiliaryClasses;

import org.telegram.telegrambots.meta.api.objects.Update;

public class UserInfo {

    public static String getUser_TagName(Update update){
        return update.getMessage().getFrom().getUserName();
    };
    public static String getUser_ReceivedMessage(Update update){
        return update.getMessage().getText();
    }
    public static long getUser_ChatID(Update update){
        return update.getMessage().getChatId();
    }

}
