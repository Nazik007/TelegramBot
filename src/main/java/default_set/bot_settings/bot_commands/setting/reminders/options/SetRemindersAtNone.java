package default_set.bot_settings.bot_commands.setting.reminders.options;

import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.reminders.ReminderSetting;
import support_classes.Support;

public class  SetRemindersAtNone extends EditCommand {

    protected static final String COMMAND_NAME = "/SetReminderAt25";
    protected static final String BUTTON_TEXT = "Вимкнути сповіщення";
    protected static final String COMMAND_RESULT_TEXT = "Сповіщення вимкнені";
    protected static final String PARENT_COMMAND = ReminderSetting.COMMAND_NAME;

    public SetRemindersAtNone() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setReminderTime(25);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
