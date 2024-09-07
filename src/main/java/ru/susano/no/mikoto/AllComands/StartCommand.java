package ru.susano.no.mikoto.AllComands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.susano.no.mikoto.AuxiliaryClasses.MessageSender;

import static ru.susano.no.mikoto.AuxiliaryClasses.BotAnswers.WELCOME_MESSAGE;

public class StartCommand extends Commands {

    public static void execute(Update update) {
        MessageSender.send(update,WELCOME_MESSAGE.getText());
    }
}
