abstract class Account {
    private final String accountNum;
    float balance;
    public final float BALANCE_DEFAULT  = 100.0F;
    static Packages[] packages = new Packages[]{
            new Random_Package(),
            new Scanner_Package()
    };

    public Account() {
        accountNum =  packages[1].get_result();
        this.balance = BALANCE_DEFAULT;
    }

    abstract void withdraw(float amount);

    public void deposit(float amount) { set_balance(amount + get_balance()); }
    public float get_balance() { return this.balance; }
    public void set_balance(float amount) { this.balance = amount; }
    public String get_account_num() { return this.accountNum; }
}


class SavingAccount extends Account {
    public final float MINIMAL_AMOUNT = 300.0F;
    public SavingAccount() {
        super();
    }

    @Override
    public void withdraw(float amount) {
        if(get_balance() - amount < MINIMAL_AMOUNT) {
            System.err.println("[ERROR] Not enough money");
            return;
        }
        System.out.println("HELLO WORLD");
        set_balance(get_balance() - amount); }
}

/*
public class CheckingAccount extends Account {
w
}

public class LaunderingAccount extends Account {
float dirty_cash;

public
}

*/

