package ru.susano.no.mikoto.AllComands;

import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import ru.susano.no.mikoto.AuxiliaryClasses.MessageSender;

import java.util.ArrayList;

import static ru.susano.no.mikoto.AuxiliaryClasses.BotAnswers.ADMIN_PASSWORD;

public class AdminPasswordCommand {
    private static TelegramClient telegramClient = new OkHttpTelegramClient(System.getenv("BOTTOKEN"));
    private static ArrayList<BotCommand> botComm = new ArrayList<>();
    public static void execute(Update update) {
        MessageSender.send(update,ADMIN_PASSWORD.getText());
        botComm.add(new BotCommand("/stop", "Стоп"));
        botComm.add(new BotCommand("/help", "HELP"));
        botComm.add(new BotCommand("/AdminPassword", "Пароль Админа"));
        botComm.add(new BotCommand("/start", "vty."));
        try{
            telegramClient.execute(new SetMyCommands(botComm, new BotCommandScopeDefault(),null));

        } catch (TelegramApiException e) {

        }
    }
}
