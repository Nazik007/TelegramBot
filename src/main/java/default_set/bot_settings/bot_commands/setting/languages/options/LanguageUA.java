package default_set.bot_settings.bot_commands.setting.languages.options;

import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.EditCommand;
import default_set.bot_settings.TelegramBot;
import default_set.bot_settings.bot_commands.setting.languages.LanguagesSetting;
import support_classes.Support;

import java.util.Locale;

public class LanguageUA extends EditCommand {

    public static final String COMMAND_NAME = "/languagesSettingUA";
    protected static final String BUTTON_TEXT = "Українська";
    protected static final String COMMAND_RESULT_TEXT = "Зміни збережено";
    protected static final String PARENT_COMMAND = LanguagesSetting.COMMAND_NAME;

    public LanguageUA() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    @Override
    public void setSetting(ChatSetting chatSetting, Support support) {
        Locale localeUA = new Locale("ua");
        chatSetting.setLocale(localeUA);
        support.add(chatSetting.getChatId(), chatSetting);
        TelegramBot.changeLocal(localeUA);
    }
}
