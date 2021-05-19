package com.leo.User;

import java.util.Scanner;

public class OpenAccount {
    public void openAccount(User customer){
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        System.out.println("Thank you for choosing us. Please select an option: ");
        System.out.println("First We need some information from you in order to create your account");
        while(!isDone){
            System.out.println("What is your first name?");
            String name = scanner.next();
            customer.setFirstName(name);
            System.out.println("What is your last name?");
            String lastname = scanner.next();
            customer.setLastName(lastname);
            System.out.println("What is your address?");
            String address = scanner.next();
            customer.setAddress(address);
            System.out.println("What is your phone number?");
            long phoneNumber = scanner.nextLong();
            customer.setPhoneNumber(phoneNumber);
            System.out.println("How much is your salary?");
            int salary = scanner.nextInt();
            customer.setSalary(salary);
            System.out.println("Thank you, let's review your information");
            System.out.println(customer);
            System.out.println("Do you confirm the information? (yes) for confirm (no) for Edit");
            String confirm = scanner.next();
            if(confirm.equals("yes")){
                customer.storeCustomer.add(customer);
                isDone = true;
            }
        }
    }
}