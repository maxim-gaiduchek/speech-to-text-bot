import model.TranslatingSpeechSession;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import utils.SimpleSender;

public class Main extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "Speech100Bot";
    private static final String BOT_TOKEN = "1308407141:AAEGqgU56Gcbg7Y-uEM3MQYqm5VwiGF3dtY";

    private final SimpleSender sender = new SimpleSender(BOT_TOKEN);

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();

        try {
            if (message.hasVoice()) {
                TranslatingSpeechSession.start(sender, message);
            } else if (message.isUserMessage()) {
                sendUserInfo(chatId);
            } else if (message.getNewChatMembers() != null && message.getNewChatMembers().contains(getMe())) {
                sendGroupInfo(chatId);
            }
        } catch (TelegramApiException ignored) {
        }
    }

    private void sendUserInfo(Long chatId) {
        String msg = "User info pattern";

        sender.sendString(chatId, msg);
    } // TODO write a message text

    private void sendGroupInfo(Long chatId) {
        String msg = "Group info pattern";

        sender.sendString(chatId, msg);
    } // TODO write a message text

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Main());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
