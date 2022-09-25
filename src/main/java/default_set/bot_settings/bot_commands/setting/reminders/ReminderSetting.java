package default_set.bot_settings.bot_commands.setting.reminders;

import com.google.gson.Gson;
import com.vdurmont.emoji.EmojiParser;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.SendCommand;
import default_set.bot_settings.TelegramBot;
import default_set.bot_settings.bot_commands.setting.Setting;
import default_set.bot_settings.bot_commands.start.Start;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReminderSetting extends SendCommand {

    public static final String COMMAND_NAME = "/reminderSetting";
    protected static final String BUTTON_TEXT = "Час сповіщень";
    protected static final String COMMAND_RESULT_TEXT = "EmptyText";
    protected static final String PARENT_COMMAND = Setting.COMMAND_NAME;
    public ReminderSetting() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }
    @Override
    public InlineKeyboardButton getBackButton(){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(EmojiParser.parseToUnicode(":back:" + TelegramBot.getBackButtonText()));
        button.setCallbackData(PARENT_COMMAND);
        return button;
    }
    @Override
    protected void  setSettingsButtons() {
        settingsButtons.clear();

        List<InlineKeyboardButton> buttonsRow = new ArrayList<>();
        int counterButtonsInRow = 0;
        for (EditCommand command : TelegramBot.getEditCommands()) {
            if (command.getParentCommand().equals(this.commandName)) {
                buttonsRow.add(command.getButton());
                counterButtonsInRow++;
                if (counterButtonsInRow == 3) {
                    settingsButtons.add(List.copyOf(buttonsRow));
                    buttonsRow.clear();
                    counterButtonsInRow = 0;
                }
            }
        }
        if (counterButtonsInRow != 0) {
            settingsButtons.add(buttonsRow);
        }
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
                                if (button.getCallbackData().equals("/SetReminderAt" + chatSetting.getReminderTime())) {
                                    button.setText(EmojiParser.parseToUnicode(":white_check_mark:" + button.getText()));
                                }
                            })
                            .collect(Collectors.toList())
            );

        }
        settingsButtonsCopy.add(List.of(Start.getHomeButton(), getBackButton()));
        return settingsButtonsCopy;
    }
}
