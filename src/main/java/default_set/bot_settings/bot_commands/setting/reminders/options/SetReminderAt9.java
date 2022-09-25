package default_set.bot_settings.bot_commands.setting.reminders.options;

import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.reminders.ReminderSetting;
import support_classes.Support;

public class SetReminderAt9 extends EditCommand {
    protected static final String COMMAND_NAME = "/SetReminderAt9";
    protected static final String BUTTON_TEXT = "9";
    protected static final String COMMAND_RESULT_TEXT = "Ваш час сповіщень - 9 година";
    protected static final String PARENT_COMMAND = ReminderSetting.COMMAND_NAME;

    public SetReminderAt9() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void  setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setReminderTime(9);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
