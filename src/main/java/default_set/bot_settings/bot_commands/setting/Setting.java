package default_set.bot_settings.bot_commands.setting;

import com.vdurmont.emoji.EmojiParser;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.SendCommand;
import default_set.bot_settings.bot_commands.start.Start;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Setting extends SendCommand {
    public static final String COMMAND_NAME = "/setting";
    protected static final String BUTTON_TEXT = "Налаштування";
    protected static final String COMMAND_RESULT_TEXT = "EmptyText";
    protected static final String PARENT_COMMAND = Start.COMMAND_NAME;

    public Setting() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }


    @Override
    public List<List<InlineKeyboardButton>> getKeyboard(ChatSetting chatSetting) {
        return settingsButtons;
    }

    @Override
    public  InlineKeyboardButton getBackButton() {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(EmojiParser.parseToUnicode(":back:" + "Назад"));
        button.setCallbackData(PARENT_COMMAND);
        return button;
    }

    @Override
    protected void setSettingsButtons() {
        super.setSettingsButtons();
        settingsButtons.add(List.of(Start.getHomeButton(), getBackButton()));
    }
}
