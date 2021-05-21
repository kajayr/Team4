package com.leo.User;

import java.io.IOException;
import java.util.ArrayList;
import static com.leo.Input.InputValidation.*;

public class Login {

    public int secureLogin() {      //If successful returns user.index else returns 0
        ArrayList<String> buffer = new ArrayList<>();
        try { buffer = ReadLoginRecords(); } catch (IOException ignored) {}

        String[][] records = new String[buffer.size()][3];
        for(int i = 0; i < buffer.size(); i++) records[i] = buffer.get(i).split(",");

        System.out.print("Username: ");
        String username = StringNoSpaceChoice();

        System.out.print("Password: ");
        String password = StringNoSpaceChoice();

        for(int index = 1; index < records.length; index++) {
            if (records[index][1].matches(username))
                if(records[index][2].matches(password)) {
                    System.out.println("Thank You!");
                    return index;
                }
            else System.out.println("Wrong Password.");
        }
        System.out.println("Username " + username + " doesn't exist. Please try again.");
        return 0;
    }
}