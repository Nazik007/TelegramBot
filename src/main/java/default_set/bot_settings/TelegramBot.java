package default_set.bot_settings;

import banks_util.monobank.MonobankUtils;
import banks_util.nbu.NBUUtils;
import banks_util.privatbank.PrivatBankUtils;
import default_set.banks_settings.Bank;
import default_set.bot_settings.bot_commands.info.GetInfo;
import default_set.bot_settings.bot_commands.setting.Setting;
import default_set.bot_settings.bot_commands.setting.bank.BankSetting;
import default_set.bot_settings.bot_commands.setting.bank.options.SetBankMonobank;
import default_set.bot_settings.bot_commands.setting.bank.options.SetBankNBU;
import default_set.bot_settings.bot_commands.setting.bank.options.SetBankPrivatbank;
import default_set.bot_settings.bot_commands.setting.currency.CurrencySetting;
import default_set.bot_settings.bot_commands.setting.currency.options.EUR;
import default_set.bot_settings.bot_commands.setting.currency.options.GBP;
import default_set.bot_settings.bot_commands.setting.currency.options.USD;
import default_set.bot_settings.bot_commands.setting.reminders.ReminderSetting;
import default_set.bot_settings.bot_commands.setting.reminders.options.*;
import default_set.bot_settings.bot_commands.setting.round.Options.RoundToFour;
import default_set.bot_settings.bot_commands.setting.round.Options.RoundToThree;
import default_set.bot_settings.bot_commands.setting.round.Options.RoundToTwo;
import default_set.bot_settings.bot_commands.setting.round.RoundSetting;
import default_set.bot_settings.bot_commands.start.Start;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import support_classes.Support;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TelegramBot extends TelegramLongPollingBot  {

    private static String homeButtonText = "Додому";
    private static String backButtonText = "Назад";
    private static final List<EditCommand> editCommands = new ArrayList<>();
    private static final List<SendCommand> sendCommands = new ArrayList<>();
    private static final List<Bank> banks = new ArrayList<>();
    private static final int TIME_ZONE = 3;

    public final Support support;

    public TelegramBot (Support support) {
        super();
        setEditCommandList();
        setSendCommandList();
        setBanks();
        this.support = support;
        startScheduledTasks();
        startUpdateBankInfoTask();
    }

    public static List<SendCommand> getSendCommands() {

        return List.copyOf(sendCommands);
    }

    public static List<EditCommand> getEditCommands() {
        return List.copyOf(editCommands);
    }

    public static List<Bank> getBanks() {
        return List.copyOf(banks);
    }

    public static String getBackButtonText() {
        return backButtonText;
    }

    private static void setBackButtonText(String backButtonText) {
        TelegramBot.backButtonText = backButtonText;
    }

    private static void setHomeButtonText(String homeButtonText) {
        TelegramBot.homeButtonText = homeButtonText;
    }


    private void startScheduledTasks() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        int pauseBeforeStart = (60 - LocalTime.now().getMinute()) * 60;

        Runnable task1 = () -> {
            int hour = LocalTime.now().getHour() + TIME_ZONE;
            List<ChatSetting> settings = this.support.getListOfSettings();
            for (ChatSetting chatSet: settings){
                if (chatSet.getReminderTime() == hour) {
                    Update update = new Update();
                    Message message = new Message();
                    Chat chat = new Chat();
                    chat.setId(chatSet.getChatId());
                    message.setChat(chat);
                    message.setText("/getInfo");
                    update.setMessage(message);
                    onUpdateReceived(update);
                }
            }
        };
        executor.scheduleAtFixedRate(task1, pauseBeforeStart, 3600, TimeUnit.SECONDS);
    }

    private void startUpdateBankInfoTask() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        int pauseBeforeStartFirstTask = 60;

        Runnable task1 = () -> {
            MonobankUtils.updateExchangeList();
            PrivatBankUtils.updateExchangeList();
            NBUUtils.updateExchangeList();
        };
        executor.scheduleAtFixedRate(task1, pauseBeforeStartFirstTask, 60, TimeUnit.SECONDS);
    }

    private static void setBanks() {
        banks.add(new PrivatBankUtils());
        banks.add(new MonobankUtils());
        banks.add(new NBUUtils());
    }

    private static void setSendCommandList() {
        sendCommands.add(new BankSetting());
        sendCommands.add(new CurrencySetting());
        sendCommands.add(new RoundSetting());
        sendCommands.add(new GetInfo());
        sendCommands.add(new ReminderSetting());
        sendCommands.add(new Setting());
        sendCommands.add(new Start());
    }

    private void setEditCommandList() {
        editCommands.add(new USD());
        editCommands.add(new EUR());
        editCommands.add(new GBP());
        editCommands.add(new SetBankMonobank());
        editCommands.add(new SetBankPrivatbank());
        editCommands.add(new SetBankNBU());
        editCommands.add(new RoundToTwo());
        editCommands.add(new RoundToThree());
        editCommands.add(new RoundToFour());
        editCommands.add(new SetReminderAt9());
        editCommands.add(new SetReminderAt10());
        editCommands.add(new SetReminderAt11());
        editCommands.add(new SetRemindersAt12());
        editCommands.add(new SetRemindersAt13());
        editCommands.add(new SetRemindersAt14());
        editCommands.add(new SetRemindersAt15());
        editCommands.add(new SetRemindersAt16());
        editCommands.add(new SetRemindersAt17());
//        editCommands.add(new SetRemindersAt18()); just to have the None notification as separte button not using the 18 hour
        editCommands.add(new SetRemindersAtNone());

    }

    public static String getHomeButtonText() {
        return homeButtonText;
    }

    @Override
    public String getBotUsername() {
        return BotConstance.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BotConstance.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            SendMessage message = new SendMessage();
            ChatSetting chatSetting = support.contains(chatId) ? support.getSetting(chatId) : ChatSetting.getDefault(chatId);
            for (SendCommand command : sendCommands) {
                if (command.canExecute(messageText)) {
                    message = command.execute(chatSetting);
                }
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
            String callData = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            ChatSetting chatSetting = support.contains(chatId) ? support.getSetting(chatId) : ChatSetting.getDefault(chatId);
            EditMessageText editMessage = null;
            for (EditCommand command : editCommands) {
                if (command.canExecute(callData)) {
                    editMessage = command.execute(chatSetting, messageId, support);
                    break;
                }
            }
            SendMessage message = null;
            if (Objects.isNull(editMessage)) {
                for (SendCommand command : sendCommands) {
                    if (command.canExecute(callData)) {
                        message = command.execute(chatSetting);
                        break;
                    }
                }
            }
            try {
                if (Objects.nonNull(editMessage)) {
                    execute(editMessage);
                }
                if (Objects.nonNull(message)) {
                    execute(message);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


}
