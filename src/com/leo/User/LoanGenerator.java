package com.leo.User;

import java.util.Scanner;

public class LoanGenerator {
    private int lowInterestRate = 1;
    private int regularInterestRate = 3;
    private int highInterestRate = 6;
    Scanner scanner = new Scanner(System.in);
    public void calculateLoan(User customer){
        System.out.println("Would you like to apply for a loan?");
        String input = scanner.next();
        if(input.equals("yes")){
            if(customer.getCreditScore().equals("Very Good") && customer.getSalary() > 50000){
                System.out.println("Congratulations! Your credit history is great!");
                System.out.println("Based on your " + customer.getCreditScore() + " and salary: $" + customer.getSalary() + ", you are eligible for $500.000 loan with interest rate of %" + lowInterestRate + ".");
                customer.setCheckingBalance(500000);
                System.out.println("Your new balance is " + customer.getCheckingBalance());
            }
            if(customer.getCreditScore().equals("Good") && customer.getSalary() > 40000){
                System.out.println("Congratulations! Your credit history is good!");
                System.out.println("Based on your " + customer.getCreditScore() + " credit history and salary: $" + customer.getSalary() + ", you are eligible for $400.000 loan with interest rate of %" + regularInterestRate + ".");
                customer.setCheckingBalance(400000);
                System.out.println("Your new balance is " + customer.getCheckingBalance());
            }
            if(customer.getCreditScore().equals("Fair") && customer.getSalary() > 30000){
                System.out.println("Congratulations! Your credit history is good enough to apply for a loan!");
                System.out.println("Based on your " + customer.getCreditScore() + " credit history and salary: $" + customer.getSalary() + ", you are eligible for $400.000 loan with interest rate of %" + highInterestRate + ".");
                customer.setCheckingBalance(300000);
                System.out.println("Your new balance is " + customer.getCheckingBalance());
            }
            if(customer.getCreditScore().equals("Bad") && customer.getSalary() < 30000){
                System.out.println("Based on your " + customer.getCreditScore() + " credit history and salary: $" + customer.getSalary() + ", you are not eligible applying for loan");
                System.out.println("Your balance is " + customer.getCheckingBalance());
            }
            else{
                System.out.println("There is no data related to customer");
            }
        }
        else{
            System.out.println("Sure, but remember we are always here to support");
            // go back to Login
        }
    }
}
