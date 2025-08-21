public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.deposit(1000);
        savingAccount.withdraw(300);
        System.out.println(savingAccount.get_balance());

        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(300);
        System.out.println(checkingAccount.get_balance());
    }
}