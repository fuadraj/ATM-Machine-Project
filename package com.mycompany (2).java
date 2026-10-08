package com.mycompany.atmis;
import java.util.Scanner;

public class ATM_Functionality {
    private float balance;
    private final int pin = 2025;
    private final Scanner sc = new Scanner(System.in); 

    public void pin() {
        System.out.println("Enter Your Pin:");
        int enteredPin = sc.nextInt(); 

        if (enteredPin == pin) {
            System.out.println("Welcome..!");
            menu();
        } else {
            System.out.println("You Entered Wrong Pin..!");
        }
    }

    private void menu() {
        System.out.println("Choose Correct Option::");
        System.out.println("Press 1 :: Check Account Balance");
        System.out.println("Press 2 :: Deposit Money");
        System.out.println("Press 3 :: Withdraw Money");
        System.out.println("Press 4 :: Exit");

        int option = sc.nextInt();
        
        switch(option) {
            case 1:
                checkAccountBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Choose Correct Option");
        }
        menu();
    }

    private void checkAccountBalance() {
        System.out.println("Your current balance is :: " + balance);
    }

    private void depositMoney() {
        System.out.println("Enter amount to deposit:");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Deposit Successful!");
    }

    private void withdrawMoney() {
        System.out.println("Enter Amount To Withdraw:");
        float withdrawAmount = sc.nextFloat();

        if (withdrawAmount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdrawal Successful!");
        }
    }

    private void exit() {
        System.out.println("Are You sure to Exit (y/n)");
        String str = sc.next();

        if (str.equalsIgnoreCase("y")) {
            try (sc) {
                System.out.println("Thank you for visiting....");
                
            }
            System.exit(0);
        }
    }
}
