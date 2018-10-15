package org.laidu.learn.language.feature.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 输入流
 *
 * @author tiancai.zang
 * on 2018-10-11 16:17.
 */
@Slf4j
public class InputStreamDemo {

    public static void main(String[] args) throws IOException {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");

            String name = reader.readLine();
            System.out.println("Your name is: " + name);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your nationality: ");
        String nationality = scanner.nextLine();
        System.out.println("Your nationality is: " + nationality);

        // using Console
        Console console = System.console();
        if (console == null) {
            System.out.println("No console: not in interactive mode!");
            System.exit(0);
        }

        System.out.print("Enter your username: ");
        String username = console.readLine();

        System.out.print("Enter your password: ");
        char[] password = console.readPassword();

        System.out.println("Thank you!");
        System.out.println("Your username is: " + username);
        System.out.println("Your password is: " + String.valueOf(password));

        // using Console with formatted prompt
        String job = console.readLine("Enter your job: ");

        String passport = console.readLine("Enter your %d (th) passport number: ", 2);

        System.out.println("Your job is: " + job);
        System.out.println("Your passport number is: " + passport);

    }

    public static String consoleInput(String tag) {
        // console input
        Console console = System.console();

        if (console == null) {
            System.out.println("Console is not supported");
            System.exit(1);
        }

        return console.readLine();
    }
}