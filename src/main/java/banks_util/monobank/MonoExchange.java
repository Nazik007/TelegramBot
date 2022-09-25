package banks_util.monobank;

import default_set.banks_settings.Exchange;

public class MonoExchange {

    public int currencyCodeA;
    public int currencyCodeB;
    public long date;
    public float rateSell;
    public float rateBuy;
    public float rateCross;

    public MonoExchange () {

    }

    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(int currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(int currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getRateSell() {
        return rateSell;
    }

    public void setRateSell(float rateSell) {
        this.rateSell = rateSell;
    }

    public float getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(float rateBuy) {
        this.rateBuy = rateBuy;
    }

    public float getRateCross() {
        return rateCross;
    }

    public void setRateCross(float rateCross) {
        this.rateCross = rateCross;
    }

    public Exchange getExchange() {
        String ccy = CurrencyCode.codes.stream().filter(code -> code.getCode() == this.currencyCodeA).map(Code::getName).findFirst().orElse(" ");
        String base_ccy = CurrencyCode.codes.stream().filter(code -> code.getCode() == this.currencyCodeB).map(Code::getName).findFirst().orElse(" ");
        double bay = rateBuy != 0.0 ? rateBuy : rateCross;
        double sell = rateSell != 0.0 ? rateSell : rateCross;
        return new Exchange(ccy, base_ccy, bay, sell);
    }
}
