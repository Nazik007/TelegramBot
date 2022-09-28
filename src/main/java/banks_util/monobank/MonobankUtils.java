package banks_util.monobank;

import banks_util.HttpUtils;
import com.google.gson.reflect.TypeToken;
import default_set.banks_settings.Bank;
import default_set.banks_settings.Exchange;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MonobankUtils extends Bank  {

    private final static String URL = "https://api.monobank.ua/bank/currency";
    public static final String COMMAND_NAME = "/setMonobank";
    protected static final String NAME = "Монобанк";

    private final static Type typeToken = new TypeToken<List<MonoExchange>>(){
    }.getType();
    private static final List<Exchange> exchanges = new ArrayList<>();

    static {
        updateExchangeList();
    }

    public MonobankUtils() {
        super(COMMAND_NAME, NAME);
    }

    public static void updateExchangeList() {
        List<MonoExchange> monoExchanges = HttpUtils.getExchangeList(URL, typeToken);
        List<Exchange> exchangeList = monoExchanges.stream().map(MonoExchange::getExchange).collect(Collectors.toList());
        synchronized (exchanges){
            exchanges.clear();
            exchanges.addAll(exchangeList);
        }
    }

    @Override
    public List<Exchange> getExchangeList() {
        List<Exchange> exchangeList;
        synchronized (exchanges){
            exchangeList = List.copyOf(exchanges);
        }
        return exchangeList;
    }
    
}
