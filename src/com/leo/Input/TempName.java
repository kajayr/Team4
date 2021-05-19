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
        if(value.length() == 0) return false;
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

    static boolean isSzt(String value) {
        if(value.length() == 0) return false;
        return IntStream.range(0, value.length()).allMatch(i -> isDigit(value.charAt(i)));
    }

    public static int SztChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for (temp = cin.nextLine(); !isSzt(temp); temp = cin.nextLine())
            System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }

/*    public static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);
        for (temp = cin.nextLine(); temp.length() != 1 || (temp.charAt(0) != 'X' && temp.charAt(0) != 'O'); temp = cin.nextLine())
            System.out.println("Please try again. Choose either X or O.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }*/
    static boolean hasSpace(String value) {
        if(value.length() == 0) return true;
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
            System.out.println("Please try again. That is not a valid string.\n");
        return temp;
    }

    public static ArrayList<String> ReadAFile(Path file) throws IOException {
        ArrayList<String> buffer = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }
}
