package BankingApp;

public class AccountAlreadyExistsException extends Exception{

    public AccountAlreadyExistsException() {
        this("Account already exists");
    }

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
