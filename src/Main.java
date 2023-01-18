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
            else{
                System.out.println("Please select from available options");

            }
            printMainMenuMessage();
            option = scanner.nextInt();
        }
        System.out.println("Thank you for chosing Emirates NBD");
    }

    private static void printMainMenuMessage() {
        System.out.println("=========== Welcome to Emirates NBD ============");
        System.out.println("Select from available options");
        System.out.println("1. Create new Account");
        System.out.println("2. Log into account");
        System.out.println("3. Exit");
    }
}