package ru.susano.no.mikoto.AllComands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.susano.no.mikoto.AuxiliaryClasses.MessageSender;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ParserCommand {
    public static void execute(Update update){

        try {
            URL url = new URL("https://hh.ru/vacancies/programmist_java");
            InputStream outputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(outputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                MessageSender.send(update, line);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
