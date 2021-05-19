package com.leo.User;

import java.util.Scanner;

public class CreditCard {
    int score = 0;
    Scanner scanner = new Scanner(System.in);
    public void predictRewards(){
        System.out.println("How much is your spending per year?");
        int spending = scanner.nextInt();
        double calculateRate = spending * .025;
        for(int i = 1; i <= 10; i++){
            System.out.println("After " + i + " year, your reward will be $" + calculateRate);
            calculateRate+=calculateRate;
        }
        //go back to the list
    }
}
