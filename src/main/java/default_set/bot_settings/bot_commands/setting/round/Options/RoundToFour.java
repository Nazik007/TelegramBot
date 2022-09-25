package default_set.bot_settings.bot_commands.setting.round.Options;

import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.round.RoundSetting;
import support_classes.Support;

public class RoundToFour extends EditCommand {

    protected static final String COMMAND_NAME = "/roundDigitSetting4";
    protected static final String BUTTON_TEXT = "4";
    protected static final String COMMAND_RESULT_TEXT = "Кількість знаків після коми";
    protected static final String PARENT_COMMAND = RoundSetting.COMMAND_NAME;

    public RoundToFour() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void  setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setRoundDigit(4);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
