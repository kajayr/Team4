package com.leo.User;

import static com.leo.Input.InputValidation.*;

public class UserLogin {
    LoanGenerator loanApply = new LoanGenerator();
    CreditCard creditCard = new CreditCard();
    Checking gotoSavings = new Checking();

    public void secureLogin() {
        System.out.println("For security reasons, we need some information.");
        System.out.println("what is your firstname?");
        String firstname = StringNoSpaceChoice();
        System.out.println("what is your lastname?");
        String lastname = StringNoSpaceChoice();
        System.out.println("what is your phone number");
        String phoneNumber = PhoneNumberChoice();
        // check the storeCustomerData Array list in User class
        // if the firstname, lastname, and phone number is match, show the entire User information
        // else, print a message that you failed passing the security questions
    }

    public void greetUser(User customer) {
        System.out.println("Welcome Back! " + customer.getFirstName() + " " + customer.getLastName() + " Please select an option: ");
        System.out.println("1- Checking my checking account balance");
        System.out.println("2- Checking my saving account balance");
        System.out.println("3- Checking my credit score");
        System.out.println("4- Applying for loan");
        System.out.println("5- Applying for cashback credit card");
        System.out.println("6- Check my cashback credit rewards");
        int input = IntChoice();
        switch (input) {
            case 1:
                System.out.println("Your checking balance is $" + customer.getCheckingBalance());
                break;
            case 2:
                System.out.println("Your saving balance is $" + customer.getSavingsBalance());
                break;
            case 3:
                System.out.println("Your credit score is " + customer.getCreditScore());
                break;
            case 4:
                loanApply.calculateLoan(customer);
                break;
//            case 5:
//                gotoSavings.showSavings(customer);
//                break;
            case 6:
                creditCard.predictRewards();
                break;
        }
    }
}