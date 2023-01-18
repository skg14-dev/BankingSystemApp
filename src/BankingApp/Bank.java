package BankingApp;

public class Bank implements IBank{

    @Override
    public void createAccount(Account account) {

    }

    @Override
    public boolean depositToAccount(long amount, long accountId) {
        return false;
    }

    @Override
    public boolean withdrawFromAccount(long amount, long accountId) {
        return false;
    }

    @Override
    public long checkBalanceOfAccount(long accountId) {
        return 0;
    }
}
