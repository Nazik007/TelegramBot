package default_set.bot_settings.bot_commands.setting.currency.options;

import default_set.banks_settings.Currency;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.bot_commands.setting.currency.CurrencySetting;
import support_classes.Support;

import java.util.List;

public class GBP extends EditCommand {

    protected static final String COMMAND_NAME = "/setGBP";
    protected static final String BUTTON_TEXT = "GBP";
    protected static final String COMMAND_RESULT_TEXT = "Зміни збережено";
    protected static final String PARENT_COMMAND = CurrencySetting.COMMAND_NAME;

    public GBP() {

        super (COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void setSetting(ChatSetting chatSetting, Support support) {
        List<Currency> currencies = chatSetting.getCurrencies();
        if (chatSetting.getCurrencies().contains(Currency.GBP)) {
            currencies.remove(Currency.GBP);
        } else {
            currencies.add(Currency.GBP);
        }
        chatSetting.setCurrencies(currencies);
        support.add(chatSetting.getChatId(), chatSetting);
    }
}
