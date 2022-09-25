package default_set.bot_settings.bot_commands.setting.round;

import com.google.gson.Gson;
import com.vdurmont.emoji.EmojiParser;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.SendCommand;
import default_set.bot_settings.TelegramBot;
import default_set.bot_settings.bot_commands.setting.Setting;
import default_set.bot_settings.bot_commands.start.Start;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoundSetting extends SendCommand {

    public static final String COMMAND_NAME = "/roundDigitSetting";
    protected static final String BUTTON_TEXT = "Кількість знаків після коми";
    protected static final String COMMAND_RESULT_TEXT = "EmptyText";
    protected static final String PARENT_COMMAND = Setting.COMMAND_NAME;

    public RoundSetting() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public  List<List<InlineKeyboardButton>> getKeyboard(ChatSetting chatSetting) {
        Gson gson = new Gson();
        return Stream.concat(
                settingsButtons.stream()
                        .flatMap(Collection::stream)
                        .map(button -> gson.fromJson(gson.toJson(button), InlineKeyboardButton.class))
                        .peek(button -> {
                            if (button.getText().equals(String.valueOf(chatSetting.getRoundDigit()))) {
                                button.setText(EmojiParser.parseToUnicode(":white_check_mark:" + button.getText()));
                            }
                        })
                        .map(Arrays::asList),
                Stream.of(List.of(Start.getHomeButton(), getBackButton()))).collect(Collectors.toList());
    }

    @Override
    public InlineKeyboardButton getBackButton() {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(EmojiParser.parseToUnicode(":back:" + TelegramBot.getBackButtonText()));
        button.setCallbackData(PARENT_COMMAND);
        return button;
    }
}
