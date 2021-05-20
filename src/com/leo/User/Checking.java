package com.leo.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static com.leo.Input.InputValidation.*;

public class Checking {
    private final Path transactionHistoryPath = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\com\\leo\\database\\TransactionHistory.csv");
    public void showChecking(User customer) throws IOException {


        System.out.println("You have $" + customer.getCheckingBalance() + " in this account.");
        System.out.println("Is there anything else you would like to do?");
        System.out.println("0- Go Back");
        System.out.println("1- Deposit");
        System.out.println("2- Withdrawal");
        System.out.println("3- Transfer");
        int input = IntChoice();
        if(input == 0){

        }else if(input == 1){
            System.out.println("How much would you like to deposit?");
            deposit(customer);
            showChecking(customer);
        } else if(input == 2){
            System.out.println("How much would you like to withdraw?");
            withdraw(customer);
            showChecking(customer);
        }else if(input == 3){
            transfer(customer);
            showChecking(customer);
        }
    }

    private void deposit(User customer) throws IOException {
        double cash = DoubleChoice();
        customer.setCheckingBalance(cash);
        System.out.println("$" + cash + " has been successfully added. Your new balance is " + customer.getCheckingBalance());

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        String message = ("\n"+customer.getIndex()+","+formattedDate+",Deposit,"+cash+","+"0.00,"+customer.getCheckingBalance());

        // TO DO:  Update users records with data


        //Write info to TransactionalHistory
        try{
            Files.writeString(transactionHistoryPath,message, StandardOpenOption.APPEND);
        }catch (Exception e){
            System.out.println("Something went wrong please try again later");
        }

        ArrayList<String> records = ReadCheckingRecords();

        //Replace string
        String newData = String.format("%d,%s,%s,%s,%s,%s,%s,%s", customer.getIndex(), customer.getFirstName(), customer.getLastName(), customer.getAddress(),
                customer.getPhoneNumber(), customer.getSalary(), customer.getCheckingBalance(), customer.getCreditScore());

        //ReUpload File
        Path checkingRecordsFile = Path.of("Team4/src/com/leo/database/CheckingRecords.csv");

        records.set(customer.getIndex(),newData );
        Files.write(checkingRecordsFile,"".getBytes());

        //Write line by line the file
        for (String record : records)
            Files.write(checkingRecordsFile, (record + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    private void depositSilent(User customer, double cash) throws IOException {
        customer.setCheckingBalance(cash);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        String message = ("\n"+customer.getIndex()+","+formattedDate+",Deposit,"+cash+","+"0.00,"+customer.getCheckingBalance());

        // TO DO:  Update users records with data


        //Write info to TransactionalHistory
        try{
            Files.writeString(transactionHistoryPath,message, StandardOpenOption.APPEND);
        }catch (Exception e){
            System.out.println("Something went wrong please try again later");
        }

        ArrayList<String> records = ReadCheckingRecords();

        //Replace string
        String newData = String.format("%d,%s,%s,%s,%s,%s,%s,%s", customer.getIndex(), customer.getFirstName(), customer.getLastName(), customer.getAddress(),
                customer.getPhoneNumber(), customer.getSalary(), customer.getCheckingBalance(), customer.getCreditScore());

        //ReUpload File
        Path checkingRecordsFile = Path.of("Team4/src/com/leo/database/CheckingRecords.csv");

        records.set(customer.getIndex(),newData );
        Files.write(checkingRecordsFile,"".getBytes());

        //Write line by line the file
        for (String record : records)
            Files.write(checkingRecordsFile, (record + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    //Returns the amount withdrawn
    public double withdraw(User customer) throws IOException {
        double cash = DoubleChoice();

        if(customer.getCheckingBalance() >= cash){
            customer.setCheckingBalance(cash * -1);
            System.out.println("$" + cash + " has been successfully withdrawn. Your new balance is " + customer.getCheckingBalance());

            //Save new balance
            ArrayList<String> records = ReadCheckingRecords();
            //Replace string
            String newData = String.format("%d,%s,%s,%s,%s,%s,%s,%s", customer.getIndex(), customer.getFirstName(), customer.getLastName(), customer.getAddress(),
                    customer.getPhoneNumber(), customer.getSalary(), customer.getCheckingBalance(), customer.getCreditScore());

            //ReUpload File
            Path checkingRecordsFile = Path.of("Team4/src/com/leo/database/CheckingRecords.csv");

            records.set(customer.getIndex(),newData );
            Files.write(checkingRecordsFile,"".getBytes());

            //Write line by line the file
            for (String record : records)
                Files.write(checkingRecordsFile, (record + "\n").getBytes(), StandardOpenOption.APPEND);
        }else{
            System.out.println("You have entered an amount that is greater than your current balance");
        }
        return cash;
    }

    public void transfer(User customer) throws IOException {
        System.out.println("What is the ID of the person who you want to transfer money too?");
        int id = IntChoice();

        User receive = LoadUserData(id);
        double cash = withdraw(customer);
        depositSilent(receive,cash);
    }
}
