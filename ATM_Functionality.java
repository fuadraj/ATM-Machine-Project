package com.mycompany.atmis;
import java.util.Scanner;

public class ATM_Functionality {
    private float balance;
    private int pin = 2025;
    private Scanner sc = new Scanner(System.in); // Single instance of Scanner

    public void pin() {
        System.out.println("Enter Your Pin:");
        int enteredPin = sc.nextInt();  // Corrected variable name

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

        int option = sc.nextInt(); // Reuse scanner instance
        
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
        menu(); // Loop back to menu after operation
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
            balance -= withdrawAmount; // Fixed subtraction issue
            System.out.println("Withdrawal Successful!");
        }
    }

    private void exit() {
        System.out.println("Are You sure to Exit (y/n)");
        String str = sc.next();

        if (str.equalsIgnoreCase("y")) {
            System.out.println("Thank you for visiting....");
            sc.close(); // Properly closing scanner before exiting
            System.exit(0);
        }
    }
}