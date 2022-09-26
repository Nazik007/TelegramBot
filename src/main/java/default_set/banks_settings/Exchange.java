package default_set.banks_settings;

import java.util.Objects;

public class Exchange {

    public String ccy;
    public String base_ccy;
    public double buy;
    public double sale;

    public Exchange () {

    }

    public Exchange(String ccy, String base_ccy, double buy, double sale) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return ccy.equals(exchange.ccy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccy);
    }

    @Override
    public String toString() {
        return ccy + '\'' + base_ccy + System.lineSeparator() +
                "Купівля: " + buy +
                "Продаж: " + sale + System.lineSeparator();
    }
}
