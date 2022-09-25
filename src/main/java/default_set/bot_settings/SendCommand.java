package default_set.bot_settings;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public abstract class SendCommand extends Command {

    protected List<List<InlineKeyboardButton>> settingsButtons = new ArrayList<>();

    public SendCommand(String commandName, String buttonText, String commandResultText, String parentCommand) {
        super(commandName, buttonText, commandResultText, parentCommand);
        setSettingsButtons();
    }

    public SendMessage execute(ChatSetting chatSetting) {
        return SendMessage.builder()
                .text(buttonText)
                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(getKeyboard(chatSetting)).build())
                .chatId(chatSetting.getChatId())
                .build();
    }

    public abstract List<List<InlineKeyboardButton>> getKeyboard(ChatSetting chatSetting);
    public abstract InlineKeyboardButton getBackButton();
    protected void setSettingsButtons() {
        settingsButtons = new ArrayList<>();
        for (EditCommand command : TelegramBot.getEditCommands()) {
            if (command.getParentCommand().equals(commandName)) {
                settingsButtons.add(List.of(command.getButton()));
            }
        }
         for (SendCommand command : TelegramBot.getSendCommands()) {
            if (command.getParentCommand().equals(commandName)) {
                settingsButtons.add(List.of(command.getButton()));
            }
        }
    }
}
