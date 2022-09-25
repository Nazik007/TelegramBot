import default_set.bot_settings.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import support_classes.InMemorySupport;
import support_classes.Support;

public class AppLauncher {
    public static void main (String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        Support chatSettings = new InMemorySupport();
        try {
            telegramBotsApi.registerBot(new TelegramBot(chatSettings));
        }catch (TelegramApiException ex) {
            ex.printStackTrace();
        }

    }

}
