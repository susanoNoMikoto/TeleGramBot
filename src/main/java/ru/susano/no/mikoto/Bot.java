package ru.susano.no.mikoto;

import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.susano.no.mikoto.AuxiliaryClasses.MessageSender;
import ru.susano.no.mikoto.AuxiliaryClasses.MessagesLogger;
import ru.susano.no.mikoto.AuxiliaryClasses.UserInfo;

import static ru.susano.no.mikoto.AllComands.Commands.*;
import static ru.susano.no.mikoto.AuxiliaryClasses.BotAnswers.*;

public class Bot implements LongPollingSingleThreadUpdateConsumer {
    @Override
    public void consume(Update update) {

        if (UserInfo.user_ReceivedMessage(update).equalsIgnoreCase(START.getCommand())){
            MessageSender.send(update,WELCOME_MESSAGE.getText());
        }

        MessagesLogger.writeLog(update);
    }
}
