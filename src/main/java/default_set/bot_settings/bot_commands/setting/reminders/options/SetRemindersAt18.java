package default_set.bot_settings.bot_commands.setting.reminders.options;

import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.reminders.ReminderSetting;
import support_classes.Support;

public class  SetRemindersAt18 extends EditCommand {

    protected static final String COMMAND_NAME = "/SetReminderAt18";
    protected static final String BUTTON_TEXT = "18";
    protected static final String COMMAND_RESULT_TEXT = "Ваш час сповіщень - 18 година";
    protected static final String PARENT_COMMAND = ReminderSetting.COMMAND_NAME;

    public SetRemindersAt18 () {super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);}

    @Override
    public void setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setReminderTime(18);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
