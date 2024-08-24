package ru.susano.no.mikoto.AuxiliaryClasses;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class MessagesLogger {

    public static void writeLog(Update update){
        Calendar time = Calendar.getInstance();
        Path file = Paths.get(System.getenv("MyLogs"));
        try(OutputStream outputStream = new FileOutputStream(file.toFile(),true)){
            outputStream.write((time.getTime().toString()+"\n"
                                +"Chat : "+UserInfo.user_ChatID(update)+"\n"+
                                "Message : "+UserInfo.user_ReceivedMessage(update)+" From "+"@"+UserInfo.user_TagName(update)
                                +"\n" + System.lineSeparator()).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
