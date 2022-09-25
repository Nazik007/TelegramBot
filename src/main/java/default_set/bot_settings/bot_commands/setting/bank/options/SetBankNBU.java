package default_set.bot_settings.bot_commands.setting.bank.options;

import banks_util.nbu.NBUUtils;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.bank.BankSetting;
import support_classes.Support;

public class SetBankNBU extends EditCommand {

    protected static final String COMMAND_NAME = "/setNBU";
    protected static final String BUTTON_TEXT = "НБУ";
    protected static final String COMMAND_RESULT_TEXT = "Ваш банк - НБУ";
    protected static final String PARENT_COMMAND = BankSetting.COMMAND_NAME;

    public SetBankNBU() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }
    @Override
    public void  setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setBank(new NBUUtils());
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
