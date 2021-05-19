package com.leo.User;

import java.util.ArrayList;

public class User implements UserRequired{
    private String firstName;
    private String lastName;
    private String address;
    private long phoneNumber;
    private int salary;
    private int savingsBalance;
    private int checkingBalance;
    private String creditScore = "Good";
    public ArrayList<Object> storeCustomer = new ArrayList<>();
    public User(){

    }
    public User(String firstName, String lastName, String address, long phoneNumber, int salary, int savingsBalance, int checkingBalance, String creditScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.savingsBalance = savingsBalance;
        this.checkingBalance = checkingBalance;
        this.creditScore = creditScore;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(int savingsBalance) {
        this.savingsBalance += savingsBalance;
    }

    public int getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(int checkingBalance) {
        this.checkingBalance += checkingBalance;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return  "Name: " + firstName + " " + lastName + "\n" +
                "Address: " + address + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "Salary: " + salary + "\n" +
                "Savings Balance: " + savingsBalance + "\n" +
                "Checking Balance: " + checkingBalance + "\n" +
                "Credit Score: '" + creditScore;
    }
}
