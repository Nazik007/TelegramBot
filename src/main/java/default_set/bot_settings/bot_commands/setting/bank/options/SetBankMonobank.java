package default_set.bot_settings.bot_commands.setting.bank.options;

import banks_util.monobank.MonobankUtils;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.bank.BankSetting;
import support_classes.Support;

public class SetBankMonobank extends EditCommand {

     protected static final String COMMAND_NAME = "/setMonobank";
     protected static final String BUTTON_TEXT = "Монобанк";
     protected static final String COMMAND_RESULT_TEXT = "Ваш банк - Монобанк";
     protected static final String PARENT_COMMAND = BankSetting.COMMAND_NAME;


    public SetBankMonobank() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void setSetting(ChatSetting chatSetting, Support support) {
        chatSetting.setBank(new MonobankUtils());
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
