package ru.susano.no.mikoto;

import org.telegram.telegrambots.client.AbstractTelegramClient;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.description.SetMyDescription;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import ru.susano.no.mikoto.AllComands.*;
import ru.susano.no.mikoto.AuxiliaryClasses.MessageSender;
import ru.susano.no.mikoto.AuxiliaryClasses.MessagesLogger;
import ru.susano.no.mikoto.AuxiliaryClasses.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;

import static ru.susano.no.mikoto.AllComands.CommandsList.*;
import static ru.susano.no.mikoto.AuxiliaryClasses.BotAnswers.*;

public class Bot implements LongPollingSingleThreadUpdateConsumer {
    private ArrayList<BotCommand> botComm = new ArrayList<>();
    private static TelegramClient telegramClient = new OkHttpTelegramClient(System.getenv("BOTTOKEN"));
    Bot(){
        botComm.add(new BotCommand(START.getCommand(), "Стартовая команда"));
        botComm.add(new BotCommand(STOP.getCommand(), "Стоповая команда"));
        botComm.add(new BotCommand(HELP.getCommand(), "Хелповая команда"));
        botComm.add(new BotCommand(PARSER.getCommand(), "Запуск парсера"));
        botComm.add(new BotCommand(ADMINPASSWORD.getCommand(), "Админская"));
        botComm.add(new BotCommand(TEMP.getCommand(), "Темповая команда"));
        try{
            telegramClient.execute(new SetMyCommands(botComm, new BotCommandScopeDefault(),null));

        } catch (TelegramApiException e) {
           e.printStackTrace();
        }
    }
    @Override
    public void consume(Update update) {

        switch (CommandsList.getReceivedCommand(UserInfo.getUser_ReceivedMessage(update))) {
            case START -> StartCommand.execute(update);
            case HELP -> HelpCommand.execute(update);
            case STOP -> MessageSender.send(update,STOP_MESSAGE.getText());
            case PARSER -> ParserCommand.execute(update);
            case ADMINPASSWORD -> AdminPasswordCommand.execute(update);
            default -> MessageSender.send(update,NOT_COMMAND_MESSAGE.getText());

        }

        MessagesLogger.writeLog(update);
    }
}
