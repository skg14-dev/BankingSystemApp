package BankingApp;

public interface IBank {
    long createAccount(String fullName, String contact) throws AccountAlreadyExistsException;
    void setUserNameAndPassword(String username, String password, long accountId);
    boolean loginUser(String username, String password);
    boolean depositToAccount(long amount, long accountId);
    boolean withdrawFromAccount(long amount, long accountId);
    long checkBalanceOfAccount(long accountId);

}
