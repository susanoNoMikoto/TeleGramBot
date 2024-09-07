package ru.susano.no.mikoto.AllComands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.susano.no.mikoto.AuxiliaryClasses.MessageSender;

import static ru.susano.no.mikoto.AuxiliaryClasses.BotAnswers.HELP_MESSAGE;

public class HelpCommand extends Commands{
    public static void execute(Update update){
        MessageSender.send(update,HELP_MESSAGE.getText());
    }

}
