package com.leo;

import com.leo.User.OpenAccount;
import com.leo.User.User;
import com.leo.User.UserLogin;

import java.util.Scanner;

public class Welcome {
    UserLogin userLogin = new UserLogin();
    OpenAccount openAcc = new OpenAccount();
    public void welcomeMessage(User customer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bank Awesome");
        System.out.println("This is Team4, your virtual assistant. How can I help you today?");
        System.out.println("Press a number in the list to continue the process");
        System.out.println("1- Opening an account");
        System.out.println("2- Checking existing account");
        int input = scanner.nextInt();
        if(input == 1){
            openAcc.openAccount(customer);
        }
            if(input == 2){
                userLogin.secureLogin();
                userLogin.greetUser(customer);
            }
    }
}