package org.example.utils;

import org.example.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerminalHelper {

    public static int readInt(int maxValue, boolean exitIsExpected) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userAgeString = scanner.nextLine();
            try {

                if (userAgeString.equals("!q") && exitIsExpected) {
                    return -1;
                }

                int value = Integer.parseInt(userAgeString);

                if (value > maxValue || value <= 0) {
                    System.out.println(StringConstants.OUTRANGE_ERROR);
                    continue;
                }

                return value;
            } catch (NumberFormatException exception) {
                System.out.println(StringConstants.NON_INT_VALID_DATA_ERROR);
            }

            //todo ручной выход из цикла
        }
    }

    public static User readUser() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^\\w+ \\w+");
        while (true) {
            String userString = scanner.nextLine();
            Matcher matcher = pattern.matcher(userString);

            if (matcher.find()) {
                String[] userData = userString.split(" ");
                if (userData.length == 2) {
                    User user = new User(userData[0], userData[1]);
                    return user;
                }
            }

            //todo ручной выход из цикла
            System.out.println(StringConstants.INCORRECT_DATA_ERROR);
        }
    }

    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

