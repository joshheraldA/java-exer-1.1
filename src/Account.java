abstract class Account {
    private final String accountNum;
    float balance;
    public final float BALANCE_DEFAULT  = 100.0F, MINIMAL_AMOUNT;

    static Packages[] packages = new Packages[]{
            new Random_Package(),
            new Scanner_Package()
    };

    public Account(float minimal) {
        accountNum =  packages[1].get_result();
        this.balance = BALANCE_DEFAULT;
        this.MINIMAL_AMOUNT = minimal;
    }

    abstract void deposit(float amount);

    public void withdraw(float amount) {
        if(get_balance() - amount < getMINIMAL_AMOUNT()) {
            System.err.println("[ERROR] Your balance does not have enough");
            return;
        }

        set_balance(get_balance() - amount);
        System.out.println("[MESSAGE] Your account balance is " + get_balance());
    }

    public float get_balance() { return this.balance; }
    public void set_balance(float amount) { this.balance = amount; }
    public String get_account_num() { return this.accountNum; }
    public float getMINIMAL_AMOUNT() { return this.MINIMAL_AMOUNT; }
}


class SavingAccount extends Account {
    public SavingAccount() {
        super(300.0F);
    }

    @Override
    public void deposit(float amount) {
        if(amount <= 0) {
            System.err.println("[ERROR] Amount should be positive");
            return;
        }

        set_balance(amount + get_balance());
        System.out.println("[MESSAGE] Your account balance is " + get_balance());
    }
}


class CheckingAccount extends Account {
    private final float BALANCE_LIMIT;

    public CheckingAccount(float limit) {
        super(0);
        BALANCE_LIMIT = limit;
    }

    @Override
    public void deposit(float amount) {
        if(amount + get_balance() > BALANCE_LIMIT) {
            System.err.println("[ERROR] Your balance with reach the balance limit");
            return;
        }

        set_balance(amount + get_balance());
        System.out.println("[MESSAGE] Your account balance is " + get_balance());
    }
}

/*

public class LaunderingAccount extends Account {
float dirty_cash;

public
}

*/

