package banks_util.nbu;

import default_set.banks_settings.Exchange;

public class NBUExchange {

    private int r030;
    private String txt;
    private double rate;
    private String cc;

    public NBUExchange() {
    }

    public Exchange getExchange() {
        return new Exchange(this.cc, "UAH", this.rate, this.rate);
    }

    public int getR030() {
        return r030;
    }

    public void setR030 (int r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
