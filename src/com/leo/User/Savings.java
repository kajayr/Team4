package com.leo.User;

import java.util.Scanner;

public class Savings {
    Scanner scanner = new Scanner(System.in);
    public void showSavings(User customer){
        System.out.println("You have $" + customer.getSavingsBalance() + " in savings.");
        System.out.println("Is there anything else you would like to do regarding to your savings account?");
        System.out.println("1- Add to savings");
        System.out.println("2- Withdrawal from savings");
        System.out.println("3- Go Back");
        int input = scanner.nextInt();
        if(input == 3){
           // userLogin.greetUser(customer);
        }
        if(input == 1){
            System.out.println("How much would you like to add to your Savings?");
            int cash = scanner.nextInt();
            customer.setSavingsBalance(cash);
            System.out.println("$" + cash + " has been successfully added to your Savings. Your new balance is " + customer.getSavingsBalance());
        }
        if(input == 2){
            System.out.println("How much would you like to withdrawal from your Savings?");
            int cash = scanner.nextInt();
            customer.setSavingsBalance(cash * -1);
            System.out.println("$" + cash + " has been successfully added to your Savings. Your new balance is " + customer.getSavingsBalance());
        }
    }
}
