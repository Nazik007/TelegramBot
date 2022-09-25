package resources;

import java.util.ListResourceBundle;

public class Resource_ua extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return resources;
    }

    private final Object [][]  resources = {
            {"/startBUTTONTEXT", "Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют"},
            {"/startCOMMANDRESULTTEXT", "/start"},
            {"/getInfoBUTTONTEXT", "Отримати інфо"},
            {"/getInfoCOMMANDRESULTTEXT", "EmptyText"},
            {"resultText", "Результати не знайдені"},
            {"buyText", "Купівля"},
            {"sellText", "Продажа"},
            {"courseText", "Курс в "},
            {"/setPrivatbank", "Приватбанк"},
            {"/setMonobank", "Монобанк"},
            {"/setNBU", "НБУ"},

            {"/settingBUTTONTEXT", "Налаштування"},
            {"/settingCOMMANDRESULTTEXT", "EmptyText"},

            {"/bankSettingBUTTONTEXT", "Банк"},
            {"/bankSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/setMonobankBUTTONTEXT", "Монобанк"},
            {"/setMonobankCOMMANDRESULTTEXT", "Ваш банк - Монобанк"},

            {"/setNBUBUTTONTEXT", "НБУ"},
            {"/setNBUCOMMANDRESULTTEXT", "Ваш банк - НБУ"},

            {"/setPrivatbankBUTTONTEXT", "ПриватБанк"},
            {"/setPrivatbankCOMMANDRESULTTEXT", "Ваш банк - ПриватБанк"},

            {"/currencySettingBUTTONTEXT", "Валюта"},
            {"/currencySettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/setCADBUTTONTEXT", "CAD"},
            {"/setCADCOMMANDRESULTTEXT", "Зміни збережено"},

            {"/setPLZBUTTONTEXT", "PLZ"},
            {"/setPLZCOMMANDRESULTTEXT", "Зміни збережено"},

            {"/setUSDBUTTONTEXT", "USD"},
            {"/setUSDCOMMANDRESULTTEXT", "Зміни збережено"},

            {"/roundDigitSettingBUTTONTEXT", "Кількість знаків після коми"},
            {"/roundDigitSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/roundDigitSetting4BUTTONTEXT", "4"},
            {"/roundDigitSetting4COMMANDRESULTTEXT", "Кількість знаків після коми"},

            {"/roundDigitSetting3BUTTONTEXT", "3"},
            {"/roundDigitSetting3COMMANDRESULTTEXT", "Кількість знаків після коми"},

            {"/roundDigitSetting2BUTTONTEXT", "2"},
            {"/roundDigitSetting2COMMANDRESULTTEXT", "Кількість знаків після коми"},

            {"/reminderSettingBUTTONTEXT", "Час сповіщень"},
            {"/reminderSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/SetReminderAt9BUTTONTEXT", "9"},
            {"/SetReminderAt9COMMANDRESULTTEXT", "Ваш час сповіщень - 9 година"},

            {"/SetReminderAt10BUTTONTEXT", "10"},
            {"/SetReminderAt10COMMANDRESULTTEXT", "Ваш час сповіщень - 10 година"},

            {"/SetReminderAt11BUTTONTEXT", "11"},
            {"/SetReminderAt11COMMANDRESULTTEXT", "Ваш час сповіщень - 11 година"},

            {"/SetReminderAt12BUTTONTEXT", "12"},
            {"/SetReminderAt12COMMANDRESULTTEXT", "Ваш час сповіщень - 12 година"},

            {"/SetReminderAt13BUTTONTEXT", "13"},
            {"/SetReminderAt13COMMANDRESULTTEXT", "Ваш час сповіщень - 13 година"},
            {"/SetReminderAt25BUTTONTEXT", "Вимкнути сповіщення"},
            {"/SetReminderAt25COMMANDRESULTTEXT", "Сповіщення вимкнені"},

            {"/languagesSettingBUTTONTEXT", "Налаштування мови"},
            {"/languagesSettingCOMMANDRESULTTEXT", "EmptyText"},

            {"/languagesSettingUABUTTONTEXT", "Українська"},
            {"/languagesSettingUACOMMANDRESULTTEXT", "Зміни збережено"},

            {"/languagesSettingUSBUTTONTEXT", "English"},
            {"/languagesSettingUSCOMMANDRESULTTEXT", "Changes saved"},

            {"homeButtonText", "Додому"},
            {"backButtonText", "Назад"},

    };
}
