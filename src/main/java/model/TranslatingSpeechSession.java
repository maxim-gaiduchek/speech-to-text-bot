package model;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Voice;
import utils.SimpleSender;

public class TranslatingSpeechSession extends Thread {

    private SimpleSender sender;
    private Voice voice;
    private Long chatId;

    private TranslatingSpeechSession(SimpleSender sender, Message message) {
        this.sender = sender;
        voice = message.getVoice();
        chatId = message.getChatId();
    }

    @Override
    public void run() {
        String waitMsg = "Wait message pattern";
        Integer messageId = sender.sendString(chatId, waitMsg).getMessageId();


    } // TODO write the message text

    public static void start(SimpleSender sender, Message message) {
        new TranslatingSpeechSession(sender, message).start();
    }
}
