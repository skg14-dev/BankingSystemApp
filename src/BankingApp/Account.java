package BankingApp;

public class Account {
    private String fullName;

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    private long accountBalance = 0;
    private String contact;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private long accountNo;
    private String username;
    private String password;

    public Account(String fullName, String contact, long accountNo, String username, String password) {
        this.fullName = fullName;
        this.contact = contact;
        this.accountNo = accountNo;
        this.username = username;
        this.password = password;
    }
}
