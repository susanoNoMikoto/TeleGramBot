package ru.susano.no.mikoto.AuxiliaryClasses;

import org.telegram.telegrambots.client.AbstractTelegramClient;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class MessageSender {

    /*
    *       This Class had only method, which contains c
    * */

    private static TelegramClient telegramClient = new OkHttpTelegramClient(System.getenv("BOTTOKEN"));

    public static void send(Update update, String Bot_Answer) {
        if (update.hasMessage()) {
            SendMessage message = SendMessage
                    .builder()
                    .chatId(UserInfo.user_ChatID(update))
                    .text(Bot_Answer)
                    .build();
            try{
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
