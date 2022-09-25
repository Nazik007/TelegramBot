package default_set.bot_settings.bot_commands.start;

import com.vdurmont.emoji.EmojiParser;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.SendCommand;
import default_set.bot_settings.TelegramBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Start extends SendCommand {

    public static final String COMMAND_NAME = "/start";
    protected static final String BUTTON_TEXT = "/start";
    protected static final String COMMAND_RESULT_TEXT = "Вітаємо. Цей бот допоможе відслідковувати актуальні курси валют";
    protected static final String PARENT_COMMAND = COMMAND_NAME;


    public Start() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    public static InlineKeyboardButton getHomeButton(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(EmojiParser.parseToUnicode(":house:" + TelegramBot.getHomeButtonText()));
        button.setCallbackData(COMMAND_NAME);
        return button;
    }

    @Override
    public SendMessage execute(ChatSetting chatSetting) {

        return SendMessage.builder()
                .text(commandResultText)
                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(getKeyboard(chatSetting)).build())
                .chatId(chatSetting.getChatId())
                .build();
    }

    @Override
    public  List<List<InlineKeyboardButton>> getKeyboard(ChatSetting chatSetting) {
        return settingsButtons;
    }

    @Override
    public InlineKeyboardButton getBackButton() {
        return getHomeButton();
    }
}
