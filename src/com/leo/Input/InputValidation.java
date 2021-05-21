package com.leo.Input;

import com.leo.User.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import static java.lang.Character.isDigit;

public class InputValidation {

    static boolean isInt(String value) {
        if(value.length() == 0 || value.length() > ("" + Integer.MAX_VALUE).length()) return false;
        String temp = (value.charAt(0) == '-') ? value.substring(1) : value;

        try { Integer.parseInt(temp); } catch (NumberFormatException e) { return false; }
        int bound = temp.length();
        return IntStream.range(0, bound).allMatch(i -> isDigit(temp.charAt(i))) && temp.length() != 0;
    }

    public static int IntChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for (temp = cin.nextLine(); !isInt(temp); temp = cin.nextLine())
            System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");

        return Integer.parseInt(temp);
    }
    static boolean isDouble(String value) {
        boolean decimal = false;

        if(value.length() == 0 || value.length() > ("" + Double.MAX_VALUE).length()) return false;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '.')
                if (!decimal) decimal = true;
                else return false;
            if (!isDigit(value.charAt(i)) && !decimal) value = value.substring(0, i) + value.substring(i-- + 1);
        }
        return value.length() != 0;
    }

    public static double DoubleChoice() {
        Scanner cin = new Scanner(System.in);
        String temp = cin.nextLine();
        if(isDouble(temp)) {
            System.out.println("Temp: " + temp);
            return Double.parseDouble(temp);
        }
        return 0;
    }

    static boolean isSzt(String value) {
        if(value.length() == 0 || value.length() > ("65535").length()) return false;
        return IntStream.range(0, value.length()).allMatch(i -> isDigit(value.charAt(i)));
    }

    public static int SztChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);
        for (temp = cin.nextLine(); !isSzt(temp); temp = cin.nextLine())
            System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }

    public static String PhoneNumberChoice() {
        Scanner cin = new Scanner(System.in);
        String temp = cin.nextLine();

        for (int i = 0; i < temp.length(); i++)         //When an none digit is removed, prevent i from iterating
            if (!isDigit(temp.charAt(i))) temp = temp.substring(0, i) + temp.substring(i-- + 1);
        return temp.length() == 0 ? "<none>" : temp;
    }

    private static boolean isEmail(String value) {
        boolean at = false, dot = false;

        if(value.length() == 0) return false;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '@')
                if (i > 0 && value.charAt(i-1) != '.' && !at) {
                    at = true;
                    dot = false;
                }
                else return false;
            if (value.charAt(i) == '.' && at)
                if (value.charAt(i - 1) != '@' && !dot) dot = true;
            else return false;
        }
        return at && dot;
    }

    public static String EmailChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;

        for (temp = cin.nextLine(); !isEmail(temp); temp = cin.nextLine())
            System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid email.\n");
        return temp;
        }

/*    public static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);
        for (temp = cin.nextLine(); temp.length() != 1 || (temp.charAt(0) != 'X' && temp.charAt(0) != 'O'); temp = cin.nextLine())
            System.out.println("Please try again. Choose either X or O.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }*/
    static boolean hasSpace(String value) {
        if(value.length() == 0) {
            System.out.print("This field is required. ");
            return true;
        }
        return IntStream.range(0, value.length()).anyMatch(i -> value.charAt(i) == ' ' || value.charAt(i) == ',');
    }

    public static String StringNoSpaceChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for (temp = cin.nextLine(); hasSpace(temp); temp = cin.nextLine())
            System.out.println("Please try again. This time without spaces or commas.");
        return temp;
    }

    public static String StringChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for (temp = cin.nextLine(); temp.length() == 0; temp = cin.nextLine())
            System.out.println("For Tax Purposes, this is a required field. Please try again. That is not a valid string.\n");
        return temp;
    }

    public static int appendNewUserToLoginRecords(User user) throws IOException {
        Path file = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\com\\leo\\database\\LoginRecords.csv");

        System.out.println(Files.write(file,
        String.format("%d,%s,%s\n", user.index(ReadLoginRecords().size()), user.getLogin(), user.getPassword()).getBytes(),
            StandardOpenOption.APPEND).toAbsolutePath());
        return user.getIndex();
    }

    public static ArrayList<String> ReadLoginRecords() throws IOException {
        Path file = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\com\\leo\\database\\LoginRecords.csv");
        System.out.println(file.toAbsolutePath());
        ArrayList<String> buffer = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }

    public static int appendNewUserToCheckingRecords(User user) throws IOException {
        Path file = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\com\\leo\\database\\CheckingRecords.csv");
        System.out.println(Files.write(file,
        String.format("%d,%s,%s,%s,%s,%s,%s,%s\n", user.index(ReadCheckingRecords().size()), user.getFirstName(), user.getLastName(), user.getPhoneNumber(),
        user.getAddress(), user.getSalary(), user.getCheckingBalance(), user.getCreditScore()).getBytes(), StandardOpenOption.APPEND).toAbsolutePath());
        return user.getIndex();
    }


    public static ArrayList<String> ReadCheckingRecords() throws IOException {
        Path file = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\com\\leo\\database\\CheckingRecords.csv");
        ArrayList<String> buffer = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }

    public static User LoadUserData(int index) throws IOException {
        Path file = Paths.get(System.getProperty("user.dir") + "\\Team4\\src\\com\\leo\\database\\CheckingRecords.csv");
        return new User(new ArrayList<>(Arrays.asList(Files.readAllLines(file).get(index).split(","))));
    }

}
