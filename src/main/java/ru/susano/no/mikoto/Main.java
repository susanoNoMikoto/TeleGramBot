package ru.susano.no.mikoto;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;

public class Main {
    public static void main(String[] args) {
        try(TelegramBotsLongPollingApplication application = new TelegramBotsLongPollingApplication()){
            application.registerBot(System.getenv("BOTTOKEN"),new Bot());
            System.out.println("ready");
            Thread.currentThread().join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}