package com.leo.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.leo.Input.InputValidation.*;

public class Login {

    public void secureLogin() {
        ArrayList<String> buffer = new ArrayList<>();
        try { buffer = ReadLoginRecords(); }
        catch (IOException ignored) {}

        String[][] records = new String[buffer.size()][3];
        for(int i = 0; i < buffer.size(); i++) records[i] = buffer.get(i).split(",");
        System.out.println(Arrays.deepToString(records));

        System.out.println("Username: ");
        String username = StringNoSpaceChoice();

        //Arrays.stream(records).anyMatch(user -> )

        System.out.println("Password: ");
        String password = StringNoSpaceChoice();

        // check the storeCustomerData Array list in User class
        // if the firstname, lastname, and phone number is match, show the entire User information
        // else, print a message that you failed passing the security questions
    }

    public void greetUser(User customer) {
        System.out.println("Welcome Back! " + customer.getFirstName() + " " + customer.getLastName() + " Please select an option: ");
        System.out.println("1- Manage my checking account");
        System.out.println("2- Check my credit score");
        System.out.println("3- Applying for loan");
        System.out.println("4- Applying for cashback credit card");
        System.out.println("5- Check my cashback credit rewards");
        int input = IntChoice();
        switch (input) {
            case 1:
                System.out.println("Your checking balance is $" + customer.getCheckingBalance());
                break;
            case 2:
                System.out.println("Your credit score is " + customer.getCreditScore());
                break;
            case 3:
                LoanGenerator loanApply = new LoanGenerator();
                loanApply.calculateLoan(customer);
                break;
//            case 4:
//                Checking gotoChecking = new Checking();
//                gotoChecking.showChecking(customer);
//                break;
            case 5:
                CreditCard creditCard = new CreditCard();
                creditCard.predictRewards();
                break;
        }
    }
}