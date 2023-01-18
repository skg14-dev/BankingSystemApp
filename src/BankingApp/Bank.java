package BankingApp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bank implements IBank{
    public Account getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Account currentUser) {
        this.currentUser = currentUser;
    }

    private Account currentUser;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    @Override
    public long createAccount(String fullName, String contact) throws AccountAlreadyExistsException {
        //check existing account
        AtomicBoolean alreadyExist = new AtomicBoolean(false);
        accounts.forEach(a ->{
            if(a.getFullName().toLowerCase().equals(fullName.toLowerCase())
                    || a.getContact().equals(contact.toLowerCase()))
            {
                alreadyExist.set(true);
            }
        });
        if (alreadyExist.get()) throw new AccountAlreadyExistsException();
        Account newAccount = new Account(fullName,contact);
        accounts.add(newAccount);
        System.out.println("Account created successfully");
        System.out.println("Your account number is : " + newAccount.getAccountNo());
        return newAccount.getAccountNo();
    }

    @Override
    public boolean loginUser(String username, String password) {
        AtomicBoolean success = new AtomicBoolean(false);
        accounts.forEach(a -> {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)){
                success.set(true);
                this.currentUser = a;
            }
        });
        return success.get();
    }

    @Override
    public void logoutUser() {
        this.currentUser = null;
        System.out.println("User logged out successfully");
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

    @Override
    public void setUserNameAndPassword(String username, String password, long accountId) {
        var account = accounts.stream().filter(a -> a.getAccountNo() == accountId).findFirst().get();
        account.setPassword(password);
        account.setUsername(username);

    }
}
