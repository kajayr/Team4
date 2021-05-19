package com.leo.User;

import static com.leo.Input.InputValidation.*;

public class OpenAccount {
    public void openAccount(User customer) {
        System.out.println("Thank you for choosing us. Please select an option: ");
        System.out.println("First We need some information from you in order to create your account");
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
            double salary = DoubleChoice();
            customer.setSalary(salary);
            System.out.println("Thank you, let's review your information");
            System.out.println(customer);
            System.out.println("1. I attest all information is accurate\n2. On second thought I need to change something");
            confirm = IntChoice();
            if (confirm == 1) customer.storeCustomer.add(customer);
        }
    }
}
