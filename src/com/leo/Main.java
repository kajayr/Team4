package com.leo;

import com.leo.User.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        User customer = new User();
        welcome.welcomeMessage(customer);

    }
}
