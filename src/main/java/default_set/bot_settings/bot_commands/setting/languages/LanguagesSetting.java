package default_set.bot_settings.bot_commands.setting.languages;

import com.google.gson.Gson;
import com.vdurmont.emoji.EmojiParser;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.SendCommand;
import default_set.bot_settings.TelegramBot;
import default_set.bot_settings.bot_commands.setting.Setting;
import default_set.bot_settings.bot_commands.start.Start;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LanguagesSetting extends SendCommand {

    public static final String COMMAND_NAME = "/languagesSetting";
    protected static final String BUTTON_TEXT = "Налаштування мови";
    protected static final String COMMAND_RESULT_TEXT = "EmptyText";
    protected static final String PARENT_COMMAND = Setting.COMMAND_NAME;


    public LanguagesSetting() {

        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public List<List<InlineKeyboardButton>> getKeyboard(ChatSetting chatSetting) {
        List<List<InlineKeyboardButton>> settingsButtonsCopy = new ArrayList<>();
        Gson gson = new Gson();
        for (List<InlineKeyboardButton> row : settingsButtons
        ) {
            settingsButtonsCopy.add(
                    row.stream()
                            .map(button -> gson.fromJson(gson.toJson(button), InlineKeyboardButton.class))
                            .peek(button -> {
                                if (button.getCallbackData().equals("/languagesSetting" + chatSetting.getLocale().getLanguage().toUpperCase())) {
                                    button.setText(EmojiParser.parseToUnicode(":white_check_mark:" + button.getText()));
                                }
                            })
                            .collect(Collectors.toList())
            );

        }
        settingsButtonsCopy.add(List.of(Start.getHomeButton(), getBackButton()));
        return settingsButtonsCopy;
    }

    @Override
    public InlineKeyboardButton getBackButton() {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(EmojiParser.parseToUnicode(":back:" + TelegramBot.getBackButtonText()));
        button.setCallbackData(PARENT_COMMAND);
        return button;
    }
}
