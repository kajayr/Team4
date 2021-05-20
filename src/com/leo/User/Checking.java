package com.leo.User;

import java.util.Scanner;

public class Checking {
    Scanner scanner = new Scanner(System.in);
    public void showChecking(User customer){
        System.out.println("You have $" + customer.getCheckingBalance() + " in this account.");
        System.out.println("Is there anything else you would like to do?");
        System.out.println("0- Go Back");
        System.out.println("1- Deposit");
        System.out.println("2- Withdrawal");
        int input = scanner.nextInt();
        if(input == 0){
           // userLogin.greetUser(customer);
        }
        if(input == 1){
            System.out.println("How much would you like to add?");
            int cash = scanner.nextInt();
            customer.setCheckingBalance(cash);
            System.out.println("$" + cash + " has been successfully added. Your new balance is " + customer.getCheckingBalance());
        }
        if(input == 2){
            System.out.println("How much would you like to withdrawal?");
            int cash = scanner.nextInt();
            customer.setCheckingBalance(cash * -1);
            System.out.println("$" + cash + " has been successfully added. Your new balance is " + customer.getCheckingBalance());
        }
    }
}
