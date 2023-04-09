import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Scanner;

public class Telegram extends TelegramLongPollingBot {
    private final String chatId = "682958008";

    @Override
    public void onUpdateReceived(Update update) {
    }
    @Override
    public String getBotUsername() {
        return "assigment4bot";
    }
    @Override
    public String getBotToken() {
        return "6025352745:AAFDprjRpbgDq-_3Oe8czIIJkT7G3Kg2_dw";
    }
}