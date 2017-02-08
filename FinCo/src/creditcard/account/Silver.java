package creditcard.account;

/**
 *
 * @author Manish Karki
 */
public class Silver extends CreditCardAccount {

    public double mi=0.08,mp=0.12;   
    
    @Override
    public String getType() {
        return "Silver";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }

    public double getMi() {
        return mi;
    }

    public void setMi(double mi) {
        this.mi = mi;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

}

