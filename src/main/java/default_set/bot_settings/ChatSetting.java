package default_set.bot_settings;


import banks_util.monobank.MonobankUtils;
import banks_util.privatbank.PrivatBankUtils;
import default_set.banks_settings.Bank;
import default_set.banks_settings.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ChatSetting {

    private long chatId;
    private int roundDigit;
    private Bank bank;
    private int reminderTime;
    private List<Currency> currencies;
    private Locale locale;

    public ChatSetting(long chatId, int roundDigit, Bank bank, int reminderTime, List<Currency> currencies, Locale locale) {
        this.chatId = chatId;
        this.roundDigit = roundDigit;
        this.bank = bank;
        this.reminderTime = reminderTime;
        this.currencies = currencies;
        this.locale = locale;
    }

    public ChatSetting (long chatId) {
        this.chatId = chatId;
    }

    public  static ChatSetting getDefault (long chatId) {
        ChatSetting setting = new ChatSetting(chatId);
        setting.setBank(new PrivatBankUtils());
        setting.setRoundDigit(2);
        List<Currency> currencyList = new ArrayList<>();

        currencyList.add(Currency.USD);
        setting.setCurrencies(currencyList);
        setting.setReminderTime(13);
        setting.setLocale(new Locale("ua"));
        return setting;

    }

    public long getChatId() {
        return chatId;
    }

//    USELESS PART
//    public void setChatId(long chatId) {
//        this.chatId = chatId;
//    }

    public int getRoundDigit() {
        return roundDigit;
    }

    public void setRoundDigit(int roundDigit) {
        this.roundDigit = roundDigit;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(int reminderTime) {
        this.reminderTime = reminderTime;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    //    USELESS PART
//    public Locale getLocale() {
//        return locale;
//    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatSetting that = (ChatSetting) o;
        return chatId == that.chatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId);
    }


}
