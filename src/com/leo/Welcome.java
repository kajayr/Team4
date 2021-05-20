package com.leo;

import com.leo.Input.InputValidation;
import com.leo.User.Checking;
import com.leo.User.Login;
import com.leo.User.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.leo.Input.InputValidation.*;

public class Welcome {
    Login login = new Login();

    public void welcomeMessage() {
        System.out.println("Welcome to Bank NotAScam");
        System.out.println("This is Team4, your virtual assistant. How can I help you today?");
        System.out.println("Press a number in the list to continue the process");
        int index;
        boolean inUse = true;
        while(inUse){
            for (index = 0; index == 0; ) {
                System.out.println("1- Setup a new account");
                System.out.println("2- Login");
                int input = SztChoice();
                if (input == 1) index = openAccount();
                if (input == 2) {
                    index = login.secureLogin();

                }
            }
            try {

                User user = LoadUserData(index+1);
                Checking checking = new Checking();
                checking.showChecking(user);

            } catch (IOException ignored) {}
            System.out.println("You have been succesfully logged out." +
                    "\nType in '0' to close the application");
            int exit = InputValidation.IntChoice();

            if(exit == 0){
                inUse = false;
            }
        }


    }
    public int openAccount() {
        System.out.println("Thank you for choosing us. Please select an option: ");
        System.out.println("First We need some information from you in order to create your account");
        User customer = new User();
        for (int confirm = 0; confirm != 1;) {
            System.out.println("What is your first name?");
            customer.setFirstName(StringNoSpaceChoice());
            System.out.println("What is your last name?");
            customer.setLastName(StringNoSpaceChoice());
            System.out.println("What is your address?");
            customer.setAddress(StringChoice());
            System.out.println("What is your phone number?");
            customer.setPhoneNumber(PhoneNumberChoice());
            System.out.println("How much is your salary?");
            customer.setSalary(DoubleChoice());
            System.out.println("Thank you, let's review your information");
            System.out.println(customer);
            System.out.println("1. I attest all information is accurate\n2. On second thought I need to change something");
            confirm = IntChoice();
            if (confirm == 1) customer.storeCustomer.add(customer);
        }

        System.out.print("Choose a username: ");
        customer.setLogin(StringNoSpaceChoice());

        System.out.print("Choose a password: ");
        customer.setPassword(StringNoSpaceChoice());

        System.out.println("Please enter your email address so we can sell it to car warranty companies: ");
        customer.setEmail(EmailChoice());
        try {
            if( appendNewUserToLoginRecords(customer) != appendNewUserToCheckingRecords(customer)) {
                System.out.println("Database Mismatch Detected. Launch all nuclear missiles!");
                return 0;
            }
        } catch (IOException e) {
            System.out.println("We cannot open an account at this time either because your internet sucks or Cathy crashed the server again.");
            return 0;
        }
        return customer.getIndex();
    }
}