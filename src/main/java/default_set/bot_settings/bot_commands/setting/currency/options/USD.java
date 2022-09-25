package default_set.bot_settings.bot_commands.setting.currency.options;

import default_set.banks_settings.Currency;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.currency.CurrencySetting;
import support_classes.Support;

import java.util.List;

public class USD extends EditCommand {

    protected static final String COMMAND_NAME = "/setUSD";
    protected static final String BUTTON_TEXT = "USD";
    protected static final String COMMAND_RESULT_TEXT = "Зміни збережено";
    protected static final String PARENT_COMMAND = CurrencySetting.COMMAND_NAME;

    public USD() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }


    @Override
    public void  setSetting(ChatSetting chatSetting, Support support) {
        List<Currency> currencies = chatSetting.getCurrencies();
        if (chatSetting.getCurrencies().contains(Currency.USD)) {
            currencies.remove(Currency.USD);
        } else {
            currencies.add(Currency.USD);
        }
        chatSetting.setCurrencies(currencies);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
