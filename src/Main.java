import BankingApp.AccountAlreadyExistsException;
import BankingApp.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        printMainMenuMessage();

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        while (option != 3){
            if (option == 1){
                System.out.println("Enter full name");
                String fullName = scanner.next();
                System.out.println("Enter contact");
                String contact = scanner.next();
                System.out.println("... processing");
                try{
                    long accountNo = bank.createAccount(fullName,contact);
                    System.out.println("Please set username and password");
                    System.out.println("Username : ");
                    String username = scanner.next();
                    System.out.println("Password :");
                    String password = scanner.next();
                    bank.setUserNameAndPassword(username,password,accountNo);
                }
                catch (AccountAlreadyExistsException e){
                    System.out.println(e.getMessage());
                }

            }
            else if(option==2){
                System.out.println("Username : ");
                String username = scanner.next();
                System.out.println("Password :");
                String password = scanner.next();
                boolean success = bank.loginUser(username,password);
                if (success){
                    printLoggedInUserMenu();
                    int accountOptions = scanner.nextInt();
                    scanner.nextLine();
                    while (accountOptions != 4){
                        switch (accountOptions){
                            case 1:
                                System.out.println("Enter amount to deposit");
                                long amountToDeposit = scanner.nextLong();
                                bank.depositToAccount(amountToDeposit,bank.getCurrentUser().getAccountNo());
                                break;
                            case 2:
                                System.out.println("Enter amount to withdraw");
                                long amountToWithdraw = scanner.nextLong();
                                bank.withdrawFromAccount(amountToWithdraw,bank.getCurrentUser().getAccountNo());
                                break;
                            case 3:
                                long balance = bank.checkBalanceOfAccount(bank.getCurrentUser().getAccountNo());
                                System.out.println("Your total balance is : " + balance );
                                break;
                            default:
                                System.out.println("Please select from available options");
                                printLoggedInUserMenu();
                                accountOptions = scanner.nextInt();
                                scanner.nextLine();
                        }
                    }
                    bank.logoutUser();


                }else{
                    System.out.println("Username or Password incorrect");
                }
            }
            else{
                System.out.println("Please select from available options");

            }
            printMainMenuMessage();
            option = scanner.nextInt();
        }
        System.out.println("Thank you for chosing Emirates NBD");
    }

    private static void printLoggedInUserMenu() {
        System.out.println("=========== Welcome to your account ============");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Log Out");
    }

    private static void printMainMenuMessage() {
        System.out.println("=========== Welcome to Emirates NBD ============");
        System.out.println("Select from available options");
        System.out.println("1. Create new Account");
        System.out.println("2. Log into account");
        System.out.println("3. Exit");
    }
}