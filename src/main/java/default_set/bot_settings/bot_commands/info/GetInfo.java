package default_set.bot_settings.bot_commands.info;

import default_set.banks_settings.Bank;
import default_set.banks_settings.Currency;
import default_set.banks_settings.Exchange;
import default_set.bot_settings.ChatSetting;
import default_set.bot_settings.SendCommand;
import default_set.bot_settings.TelegramBot;
import default_set.bot_settings.bot_commands.start.Start;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GetInfo extends SendCommand {
    public static final String COMMAND_NAME = "/getInfo";
    protected static final String BUTTON_TEXT = "Отримати інфо";
    protected static final String COMMAND_RESULT_TEXT = "EmptyText";
    protected static final String PARENT_COMMAND = Start.COMMAND_NAME;
    protected static  String resultText = "Результати не знайдені";
    protected static  String buyText = "Купівля ";
    protected static  String sellText = "Продаж ";
    protected static  String courseText = "Курс в ";
    public GetInfo() {
        super(COMMAND_NAME, BUTTON_TEXT, COMMAND_RESULT_TEXT, PARENT_COMMAND);
    }

    private  String getExchangeAfterRoundResults(Exchange exchange, ChatSetting chatSetting) {
        BigDecimal sale = BigDecimal.valueOf(exchange.getSale()).setScale(chatSetting.getRoundDigit(), RoundingMode.HALF_UP);
        BigDecimal buy = BigDecimal.valueOf(exchange.getBuy()).setScale(chatSetting.getRoundDigit(), RoundingMode.HALF_UP);
        return exchange.ccy + '\\' + exchange.base_ccy + System.lineSeparator() +
                buyText + buy + System.lineSeparator() +
                sellText + sale + System.lineSeparator();
    }

    @Override
    public SendMessage execute(ChatSetting chatSetting) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatSetting.getChatId());
        sendMessage.setText(resultText);
        StringBuilder result = new StringBuilder();

        List<Bank> banks = TelegramBot.getBanks();
        List<Exchange> exchangeList = null;
        for (Bank bank: banks
        ) {
            if (bank.getCommandName().equals(chatSetting.getBank().getCommandName())){
                exchangeList = bank.getExchangeList();
                result.append(courseText).append(bank.getName()).append(System.lineSeparator());
                break;
            }

        }

        if (Objects.nonNull(exchangeList)) {
            for (Currency v : chatSetting.getCurrencies()
            ) {
                Optional<Exchange> exchange = exchangeList.stream()
                        .filter(ex -> ex.ccy.equalsIgnoreCase(v.name()))
                        .findFirst();
                exchange.ifPresent(ex -> result.append(getExchangeAfterRoundResults(ex, chatSetting))
                        .append(System.lineSeparator()));
            }

            sendMessage.setText(result.toString());
        }

        return sendMessage;
    }

//    THIS PART IS USELESS
//    public static void setResultText(String resultText) {
//        GetInfo.resultText = resultText;
//    }
//
//    public static void setBuyText(String buyText) {
//        GetInfo.buyText = buyText;
//    }
//
//    public static void setSellText(String sellText) {
//        GetInfo.sellText = sellText;
//    }
//
//    public static void setCourseText(String courseText) {
//        GetInfo.courseText = courseText;
//    }

    @Override
    public List<List<InlineKeyboardButton>> getKeyboard(ChatSetting chatSetting) {
        return settingsButtons;
    }

    @Override
    public InlineKeyboardButton getBackButton() {
        return null;
    }
}
