package default_set.bot_settings;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import support_classes.Support;

import static default_set.bot_settings.TelegramBot.getSendCommands;

public abstract class EditCommand extends  Command {


    public EditCommand(String commandName, String buttonText, String commandResultText, String parentCommand) {
        super(commandName, buttonText, commandResultText, parentCommand);
    }

    public EditMessageText execute (ChatSetting chatSetting, int messageID, Support support) {
        setSetting(chatSetting, support);
        return EditMessageText.builder()
                .text(commandResultText)
                .replyMarkup(InlineKeyboardMarkup.builder()
                        .keyboard(getParentCommandObj(parentCommand).getKeyboard(chatSetting))
                        .build())
                .chatId(chatSetting.getChatId())
                .messageId(messageID)
                .build();
    }

    private  SendCommand getParentCommandObj(String parentCommand) {
        return getSendCommands().stream()
                .filter(sendCommand -> sendCommand.getCommandName().equals(parentCommand))
                .findFirst()
                .orElse(null);
    }


    public abstract void setSetting(ChatSetting chatSetting, Support support);


}
