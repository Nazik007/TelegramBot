package banks_util.nbu;

import banks_util.HttpUtils;
import com.google.gson.reflect.TypeToken;
import default_set.banks_settings.Bank;
import default_set.banks_settings.Exchange;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NBUUtils extends Bank {

    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    public static final String COMMAND_NAME = "/setNBU";
    protected static final String NAME = "НБУ";
    private static final Type typeToken = new TypeToken<List<NBUExchange>>() {
    }.getType();
    private static final List<Exchange> exchanges = new ArrayList<>();

    public NBUUtils() {
        super(COMMAND_NAME, NAME);
    }

    static {
         updateExchangeList();
    }


    public static void updateExchangeList() {
        List<NBUExchange> nbuExchanges = HttpUtils.getExchangeList(URL, typeToken);
        List<Exchange> exchangeList = nbuExchanges.stream().map(NBUExchange::getExchange).collect(Collectors.toList());
        synchronized (exchanges){
            exchanges.clear();
            exchanges.addAll(exchangeList);
        }
    }

    @Override
    public List<Exchange> getExchangeList() {
        List<Exchange> exchangeList;
        synchronized (exchanges) {
            exchangeList = List.copyOf(exchanges);
        }
        return exchangeList;
    }
}
