package resources;

import java.util.ListResourceBundle;

public class Resources_us extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return resources;
    }

    private final Object[][] resources = {

            {"/startBUTTONTEXT", "Welcome. This bot will help you track current exchange rates"},
            {"/startCOMMANDRESULTTEXT", "/start"},

            {"/getInfoBUTTONTEXT", "Get info"},
            {"/getInfoCOMMANDRESULTTEXT", "EmptyText"},
            {"resultText", "No results found"},
            {"buyText", "Buy"},
            {"sellText", "Sell"},
            {"courseText", "Exchange rates in "},

            {"/setPrivatbank", "Privatbank"},
            {"/setMonobank", "Monobank"},
            {"/setNBU", "NBU"},

            {"/settingBUTTONTEXT", "Settings"},
            {"/settingCOMMANDRESULTTEXT", "EmptyText"},

            {"/bankSettingBUTTONTEXT", "Banks"},
            {"/bankSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/setMonobankBUTTONTEXT", "Monobank"},
            {"/setMonobankCOMMANDRESULTTEXT", "Your bank is Monobank"},

            {"/setNBUBUTTONTEXT", "NBU"},
            {"/setNBUCOMMANDRESULTTEXT", "Your bank is NBU"},

            {"/setPrivatbankBUTTONTEXT", "Privatbank"},
            {"/setPrivatbankCOMMANDRESULTTEXT", "Your bank is Privatbank"},

            {"/currencySettingBUTTONTEXT", "Currencies"},
            {"/currencySettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/setCADBUTTONTEXT", "CAD"},
            {"/setCADCOMMANDRESULTTEXT", "Changes saved"},

            {"/setPLZBUTTONTEXT", "PLZ"},
            {"/setPLZCOMMANDRESULTTEXT", "Changes saved"},

            {"/setUSDBUTTONTEXT", "USD"},
            {"/setUSDCOMMANDRESULTTEXT", "Changes saved"},

            {"/roundDigitSettingBUTTONTEXT", "Accuracy of the result"},
            {"/roundDigitSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/roundDigitSetting4BUTTONTEXT", "4"},
            {"/roundDigitSetting4COMMANDRESULTTEXT", "Accuracy of the result"},

            {"/roundDigitSetting3BUTTONTEXT", "3"},
            {"/roundDigitSetting3COMMANDRESULTTEXT", "Accuracy of the result"},

            {"/roundDigitSetting2BUTTONTEXT", "2"},
            {"/roundDigitSetting2COMMANDRESULTTEXT", "Accuracy of the result"},

            {"/reminderSettingBUTTONTEXT", "Notification time"},
            {"/reminderSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/SetReminderAt9BUTTONTEXT", "9"},
            {"/SetReminderAt9COMMANDRESULTTEXT", "Your notification time is 9 o'clock"},

            {"/SetReminderAt10BUTTONTEXT", "10"},
            {"/SetReminderAt10COMMANDRESULTTEXT", "Your notification time is 10 o'clock"},

            {"/SetReminderAt11BUTTONTEXT", "11"},
            {"/SetReminderAt11COMMANDRESULTTEXT", "Your notification time is 11 o'clock"},

            {"/SetReminderAt12BUTTONTEXT", "12"},
            {"/SetReminderAt12COMMANDRESULTTEXT", "Your notification time is 12 o'clock"},

            {"/SetReminderAt13BUTTONTEXT", "13"},
            {"/SetReminderAt13COMMANDRESULTTEXT", "Your notification time is 13 o'clock"},

            {"/SetReminderAt14BUTTONTEXT", "14"},
            {"/SetReminderAt14COMMANDRESULTTEXT", "Your notification time is 14 o'clock"},

            {"/SetReminderAt15BUTTONTEXT", "15"},
            {"/SetReminderAt15COMMANDRESULTTEXT", "Your notification time is 15 o'clock"},

            {"/SetReminderAt16BUTTONTEXT", "16"},
            {"/SetReminderAt16COMMANDRESULTTEXT", "Your notification time is 16 o'clock"},

            {"/SetReminderAt17BUTTONTEXT", "17"},
            {"/SetReminderAt17COMMANDRESULTTEXT", "Your notification time is 17 o'clock"},

            {"/SetReminderAt18BUTTONTEXT", "18"},
            {"/SetReminderAt18COMMANDRESULTTEXT", "Your notification time is 18 o'clock"},

            {"/SetReminderAt25BUTTONTEXT", "Turn off notifications"},
            {"/SetReminderAt25COMMANDRESULTTEXT", "Notifications are turned off"},

            {"/languagesSettingBUTTONTEXT", "Language settings"},
            {"/languagesSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/languagesSettingUABUTTONTEXT", "Українська"},
            {"/languagesSettingUACOMMANDRESULTTEXT", "Зміни збережено"},

            {"/languagesSettingUSBUTTONTEXT", "English"},
            {"/languagesSettingUSCOMMANDRESULTTEXT", "Changes saved"},

            {"homeButtonText", "Home"},
            {"backButtonText", "Back"},

    };
}
