package com.leo.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import static java.lang.Character.isDigit;

public class TempName {

    static boolean isInt(String value) {
        if(value.length() == 0 || value.length() > ("" + Integer.MAX_VALUE).length()) return false;
        String temp = (value.charAt(0) == '-') ? value.substring(1) : value;

        return IntStream.range(0, temp.length()).allMatch(i -> isDigit(temp.charAt(i))) && temp.length() != 0;
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
        if(isDouble(temp)) return Double.parseDouble(temp);

        return 0;
    }

    static boolean isSzt(String value) {
        if(value.length() == 0) return false;
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
        return IntStream.range(0, value.length()).anyMatch(i -> value.charAt(i) == ' ');
    }

    public static String StringNoSpaceChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for (temp = cin.nextLine(); hasSpace(temp); temp = cin.nextLine())
            System.out.println("If your name has spaces, please type as a single word.\n");
        return temp;
    }

    public static String StringChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for (temp = cin.nextLine(); temp.length() == 0; temp = cin.nextLine())
            System.out.println("For Tax Purposes, this is a required field. Please try again. That is not a valid string.\n");
        return temp;
    }

    public static ArrayList<String> ReadAFile(Path file) throws IOException {
        ArrayList<String> buffer = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }
}
