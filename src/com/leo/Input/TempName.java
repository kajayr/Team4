package com.leo.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class TempName {

    static boolean isInt(String value) {
        String temp = (value.charAt(0) == '-') ? value.substring(1) : value;
        for (int i = 0; i < temp.length(); i++)
            if (!isDigit(temp.charAt(i))) return true;
        return temp.length() == 0;
    }

    static int IntChoice() {
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        String temp;
        for (temp = cin.nextLine(); isInt(temp); temp = cin.nextLine())
            if (isInt(temp))
                System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }

    static boolean isSzt(String value) {
        for (int i = 0; i < value.length(); i++)
            if (!isDigit(value.charAt(i))) return true;
        return value.length() == 0;
    }

    static int SztChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for (temp = cin.nextLine(); isSzt(temp); temp = cin.nextLine())
            if (isSzt(temp))
                System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }

/*    static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);
        for (temp = cin.nextLine(); temp.length() != 1 || (temp.charAt(0) != 'X' && temp.charAt(0) != 'O'); temp = cin.nextLine())
            System.out.println("Please try again. Choose either X or O.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }*/

    static String StringChoice() {
        Scanner cin = new Scanner(System.in);
        String temp;
        for (temp = cin.nextLine(); temp.length() == 0; temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");
        return temp;
    }

    static ArrayList<String> ReadAFile(Path file) throws IOException {
        ArrayList<String> buffer = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(buffer::add);
        return buffer;
    }
}
