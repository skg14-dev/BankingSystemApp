package BankingApp;

public interface IBank {
    void createAccount(Account account);
    boolean depositToAccount(long amount, long accountId);
    boolean withdrawFromAccount(long amount, long accountId);
    long checkBalanceOfAccount(long accountId);
}
