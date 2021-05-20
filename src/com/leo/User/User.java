package com.leo.User;

import java.util.ArrayList;

public class User implements Required {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private double salary;
    private int checkingBalance;
    private String creditScore = "Good";
    public ArrayList<Object> storeCustomer = new ArrayList<>();
    private String login;
    private String email;
    private String password;

    public User(){
    }
    public User(String firstName, String lastName, String address, String phoneNumber, int salary, int checkingBalance, String creditScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.checkingBalance = checkingBalance;
        this.creditScore = creditScore;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Name: " + firstName + " " + lastName + "\n" +
                "Address: " + address + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "Salary: " + salary + "\n" +
                "Checking Balance: " + checkingBalance + "\n" +
                "Credit Score: '" + creditScore;
    }
}
