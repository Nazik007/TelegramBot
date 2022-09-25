package default_set.bot_settings.bot_commands.setting.reminders.options;

import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.reminders.ReminderSetting;
import support_classes.Support;

public class SetReminderAt10 extends EditCommand {
    protected static final String COMMAND_NAME = "/SetReminderAt10";
    protected static final String BUTTON_TEXT = "10";
    protected static final String COMMAND_RESULT_TEXT = "Ваш час сповіщень - 10 година";
    protected static final String PARENT_COMMAND = ReminderSetting.COMMAND_NAME;

    public SetReminderAt10() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setReminderTime(10);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
