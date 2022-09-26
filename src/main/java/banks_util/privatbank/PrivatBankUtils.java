package banks_util.privatbank;

import banks_util.HttpUtils;
import com.google.common.reflect.TypeToken;
import default_set.banks_settings.Bank;
import default_set.banks_settings.Exchange;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrivatBankUtils extends Bank {

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    private static final String GBP_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=12";

    public static final String COMMAND_NAME = "/setPrivatbank";
    protected static final String NAME = "ПриватБанк";

    private static final Type TYPE_TOKEN = new TypeToken<List<Exchange>>(){
    }.getType();
    private static final List <Exchange> EXCHANGES = new ArrayList<>();

    static {
        updateExchangeList();
    }
    public PrivatBankUtils () {
        super(COMMAND_NAME, NAME);
    }

    public static void updateExchangeList () {
         List<Exchange> exchangeList = HttpUtils.getExchangeList(URL,TYPE_TOKEN);
         List<Exchange> exchangeListGbp = HttpUtils.getExchangeList(GBP_URL,TYPE_TOKEN);
        synchronized (EXCHANGES){
            for (Exchange exchange : exchangeListGbp){
                if(exchange.getCcy().equals("GBP")){
                    exchangeList.add(exchange);
                    break;
                }
            }
            EXCHANGES.clear();
            EXCHANGES.addAll(exchangeList);
        }
    }

    @Override
    public List<Exchange> getExchangeList() {
        List<Exchange> exchangeList;
        synchronized (EXCHANGES) {
            exchangeList = List.copyOf(EXCHANGES);
        }
        return exchangeList;
    }
}
